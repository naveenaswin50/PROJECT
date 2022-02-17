import java.util.*;
class Customer{
    static Scanner s = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    String name;
    String user_id;
    String phone;
    boolean is_male;
    int pin;
    int age;
    int _index;
    int wallet_bal;
    ArrayList<String> tickets = new ArrayList<String>();

    static{
        customers.add(new Customer("user1", "user1", "0000000000", true, 1000, 25, 0));
    }

    public Customer(String name,String user_id,String phone,boolean is_male,int  pin,int age, int _index){
        this.name = name;
        this.user_id = user_id;
        this.phone = phone;
        this.is_male = is_male;
        this.pin = pin;
        this.age = age;
        this._index = _index;
        this.wallet_bal = 1000;
    }

    public static void cls(){
        try{
            System.out.print("\033[H\033[2J");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static int isUser(String user_id){
        for(int i = 0; i < customers.size(); i++){
            if (customers.get(i).user_id.equals(user_id)){
                return i;
            }
        }
        return -1;
    }

    public static void enter_wait(){
        System.out.print("Press Enter to Continue!!..");
        s.nextLine();
    }

    public static void customerWelcome(){
        int com = 0;
        l : while(true){
            cls();
            System.out.println("   Welcome to E - Rail Booking - Customer  ");
            System.out.println("Select User Type:\n1:Existing Customer\n2:New Customer\n0:Back");
            
            if(com == -1){
                System.out.println("Please Enter a valid Choise.");
            }

            System.out.print("Choise : ");
            com = s.nextInt();s.nextLine();

            switch(com){
                case 1:
                    customerLogin();
                    break;
                case 2:
                    newCustomer();
                    break;
                case 0:
                    break l;
                default:
                    com = -1;
            } 
        }
    }

    public static void customerLogin(){
        int attempt = 0;
        while(attempt++ < 3){
            cls();
            System.out.println("   Welcome to E - Rail Booking - Customer Login  ");

            System.out.print("User Id : ");
            String user_id = s.next(); s.nextLine();

            System.out.print("Pin : ");
            int pin = s.nextInt(); s.nextLine();

            int ind = isUser(user_id);
            if(ind != -1){
                if(customers.get(ind).pin == pin){
                    customers.get(ind).userMenu();
                    break;
                }
            }
            System.out.println("Entered Credentials are Wrong");
            enter_wait();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
    }

    public static void newCustomer(){
        System.out.println("  New Customer Registration ");
        System.out.print("Name : ");
        String name = s.nextLine();
        String id;
        int count=0;
        do{
            if(++count>1)System.out.println("User id already exist");
            System.out.print("User Id : ");
            id = s.next(); s.nextLine();
        }
        while(isUser(id)!=-1);
        System.out.print("Pin : ");
        int pin = s.nextInt(); s.nextLine();
        System.out.print("Age : ");
        int age = s.nextInt(); s.nextLine();
        System.out.print("Phone Number : ");
        String phone = s.next(); s.nextLine();
        System.out.print("Gender(M/F) : ");
        boolean is_male = false;
        String gender = s.next(); s.nextLine();
        if(gender.equals("M")){
            is_male = true;
        }
        System.out.print("Confirm (y/n) : ");
        String conf = s.next(); s.nextLine();
        if(conf.equals("y")){
            int _index = customers.size();
            customers.add(new Customer(name, id, phone, is_male, pin, age, _index));
            System.out.println("User Has been Created Successfully");
        }else{
            System.out.println("Entered Details are discarded");
        }
        enter_wait();
    }
    public void booking(){
        int com = 0;
        while (true){
            cls();
            System.out.println("Please Select Train (0 - Exit)");
            int train_count = 1;
            for(Train t:Train.trains){
                System.out.println(train_count++ + " - " + t.number + " : " + t.name);
            }
            if(com == -1){
                System.out.println("Enter a valid option: ");
            }
            System.out.print("Enter Choise : " );
            com= s.nextInt(); s.nextLine();
            if(com > 0 && com <= train_count){
                Train.trains.get(com-1).booking(_index);
                // t.booking(_index);
                break;
            }
            else if(com == 0){
                break;
            }else{  
                com =- 1;
            }
        }
    }
    public void wallet(){
        System.out.println(wallet_bal);
        enter_wait();
    }
    public void cancelation(){
        int com = 0;
        while (true){
            cls();
            System.out.println("Please Select Ticket to Cancel(0 - Exit)");
            int tic_count = tickets.size();
            for(int i = 1; i <= tic_count; i++){
                String[] details = tickets.get(i-1).split(":");
                int train_num = Integer.parseInt(details[0]);
                int ticket_num = Integer.parseInt(details[1]);
                System.out.println("Ticket ID :" + i);
                Train cur_train = Train.trains.get(Train.getTrainByNumber(train_num));
                cur_train.displayTicket(cur_train.getTicketByRegNo(ticket_num));
            }

            if(com == -1){
                System.out.println("Enter a valid option: ");
            }

            System.out.print("Enter Choise : " );
            com= s.nextInt(); s.nextLine();

            if(com > 0 && com <= tic_count){
                String[] details = tickets.get(com-1).split(":");
                int train_num = Integer.parseInt(details[0]);
                int ticket_num = Integer.parseInt(details[1]);

                Train cur_train = Train.trains.get(Train.getTrainByNumber(train_num));
                System.out.println("Are you sure you want to cancel the ticket ? Refund : " + (cur_train.cancelReturn(cur_train.getTicketByRegNo(ticket_num))));
                System.out.print("Confirm Ticket Cancel (y/n) : " );
                String conf = s.next();s.nextLine();
                if(conf.equals("y")){
                    wallet_bal += cur_train.cancelTicket(cur_train.getTicketByRegNo(ticket_num));
                    System.out.println("Ticket Cancelled !. The refund will be credited to wallet Balance");
                    tickets.remove(com-1);
                }else{
                    System.out.println("Ticket Cancellation aborted");
                }
                enter_wait();
            }

            else if(com == 0){
                break;
            }else{  
                com =- 1;
            }
        }
    }
    public void add_ticket(String ticket, int price){
        tickets.add(ticket);
        wallet_bal -= price;
    }
    public void userMenu(){
        int com = 0;
        loop : while(true){
            cls();  
            System.out.println("   Welcome to E - Rail Booking, " + name);
            System.out.println("Select User Type:\n1:Booking\n2:Cancelation\n3:Wallet\n0:Exit");
            if(com == -1){
                System.out.println("Please Enter a valid Choise.");
            }
            System.out.print("Choise : ");
            com = s.nextInt();s.nextLine();
            switch(com){
                case 1:
                    booking();
                    break;
                case 2:
                    cancelation();
                    break;
                case 3:
                    wallet();
                    break;
                case 0:
                    break loop;
                default:
                    com = -1;
            } 
        }
    }
}

package Zoho.Train;
import java.util.*;
class Train{
    static Scanner s = new Scanner(System.in);
    static ArrayList<Train> trains = new ArrayList<Train>();

    String[] stops;
    int[][] seats;
    int number;
    String name;
    int seat_nos;
    int waiting_list;
    int[] prices; 
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    static{
        String[] _stops = {"CBE", "TUP", "ERD", "SAL", "KPD", "MAS"};
        int[] _prices = {50,60,80,150,110};
        Train t1 = new Train("Coimbatore-Chennai Express", 665110, 10, _prices, _stops);
        trains.add(t1);
    }
    public static void cls(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void enter_wait(){
        System.out.print("Press Enter to Continue...");
        s.nextLine();
    }
    public static int getTrainByNumber(int train_num){
        for(int i = 0; i < trains.size(); i++){
            if(trains.get(i).number == train_num){
                return i;
            }
        }
        return -1;
    }
    public int getTicketByRegNo(int ticketRegNo){
        for(int i = 0; i < tickets.size(); i++){
            if (tickets.get(i).regNo == ticketRegNo){
                return i;
            }
        }
        return -1;
    }
    public Train(String name, int number, int seat_nos,int[] prices, String[] stops){
        this.name = name;
        this.number = number;
        this.seat_nos = seat_nos;
        this.stops = stops;
        this.prices = prices;
        this.seats = new int[seat_nos][stops.length-1];
        this.waiting_list = 0;
        empty();
    }
    class Ticket{
        static int Ticket_Id = 0;
        int _index;
        int price;
        int regNo;
        int board;
        int leave;
        int seat_nos;
        int passengerId;
        boolean confirmed;
        ArrayList<Integer> seat_nums = new ArrayList<Integer>();
        public Ticket(int _index, int price, int board, int leave, int passengerId, ArrayList<Integer> seat_nums){
            this._index = _index;
            this.price = price;
            this.regNo = Ticket_Id++;
            this.board = board;
            this.leave = leave;
            this.passengerId = passengerId;
            this.seat_nums = seat_nums;
            this.seat_nos = seat_nums.size();
            this.confirmed = true;
        }
        public Ticket(int _index, int price, int board, int leave, int passengerId,int seat_nos){
            this._index = _index;
            this.price = price;
            this.regNo = Ticket_Id++;
            this.board = board;
            this.leave = leave;
            this.passengerId = passengerId;
            this.seat_nos = seat_nos;
            this.confirmed = false;

        }
    }
    public void empty(){
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[0].length; j++){
                seats[i][j] = 0;
            }
        }
    }
    public void disp_seats(){
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[0].length; j++){
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int gen_price(int start, int stop){
        int price = 0;
        for(int i = start; i < stop; i++){
            price += prices[i];
        }
        return price;
    }
    public boolean seat_avail(int start, int end, int nos){
        int avail = 0;
        for(int i = 0; i < seats.length; i++){
            boolean is_free = true;
            for(int j = start; j < end; j++){
                if(seats[i][j] == 1){
                    is_free = false;
                }
            }
            if(is_free){
                avail++;
            }
            if(avail==nos){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Integer> seat_book(int start, int end, int nos){
        ArrayList<Integer> booked_seats = new ArrayList<Integer>();
        for(int i = 0; i < seats.length; i++){
            boolean is_free = true;
            for(int j = start; j < end; j++){
                if(seats[i][j] == 1){
                    is_free = false;
                }
            }
            if(is_free){
                for(int j = start; j < end; j++){
                    seats[i][j] = 1;
                }
                booked_seats.add(i);
                if(--nos == 0){
                break;
                }
            }       
        }
        return booked_seats; 
    }
    public void booking(int user_id){
        int com = 0, start = -1, leave = 1;
        boolean stop = false;
        while (true){
            cls();
            disp_seats();
            System.out.println("Please " + (stop==false?"Boarding":"Leaving") + " Stop (0 - Exit)");
            for(int i = start+2; i <= stops.length-leave; i++){
                System.out.println(i + " - " + stops[i-1]);
            }
            if(com == -1){System.out.println("Please Enter Valid Input !");}
            if(!stop){   
                System.out.print("Boarding Point : ");
                com = s.nextInt(); s.nextLine();
                if(com==0){
                    break;
                }else if(com > 0 && com < stops.length){
                    stop = true;
                    start = com-1;
                    leave = 0;
                }else if(com == stops.length){
                    System.out.println("Don't Enter The Last Stop");
                    enter_wait();
                }else{
                    com = -1;
                }
            }
            else{   
                System.out.println("Boarding Point : "+ stops[start]);
                System.out.print("Leaving Point : ");
                com = s.nextInt(); s.nextLine();
                if(com==0){
                    break;
                }else if(com > start && com <= stops.length){
                    leave = com-1;
                    System.out.println("Boarding Point : " + stops[start] + " - Leaving Point : " + stops[leave]);

                    int count;
                    while(true){
                    System.out.print("No of Passengers : ");
                    count = s.nextInt(); s.nextLine();
                    if(count < 1){System.out.println("Invalid No of Passengers !");continue;}
                    else if(count > seat_nos){System.out.println("Required Seats not available in this train");continue;}
                    break;
                    }
                    if(seat_avail(start, leave, count)){

                        int ticket_price = gen_price(start, leave)*count;

                        System.out.println("The Ticket(s) Price is : "+ ticket_price);
                        System.out.print("Confirm Purchase (y/n) : " );
                        String conf = s.next(); s.nextLine();

                        if(conf.equals("y")){
                            ArrayList<Integer> booked_seats = seat_book(start, leave, count);
                            int _index = tickets.size();
                            Ticket tic = new Ticket(_index, ticket_price, start, leave, user_id, booked_seats);
                            tickets.add(tic);
                            Customer.customers.get(user_id).add_ticket(number+":"+tic.regNo,ticket_price);
                            System.out.println("Ticket Booked!");

                        }else{
                            System.out.println("Details Discarded ! ");
                        }
                    }else{
                        if(waiting_list == 10){
                            System.out.println("Requied seat Unavailable and Waiting list is full.");
                        }else{
                            System.out.println("Required Seat Unavailable! Add to Waiting list");
                            int ticket_price = gen_price(start, leave);
                            System.out.println("The Ticket(s) Price is : "+ (ticket_price*count));
                            System.out.print("Confirm Purchase (y/n) : " );
                            String conf = s.next(); s.nextLine();

                            if(conf.equals("y")){
                                int _index = tickets.size();
                                Ticket tic = new Ticket(_index, ticket_price, start, leave, user_id, count);
                                tickets.add(tic);
                                Customer.customers.get(user_id).add_ticket(number+":"+tic.regNo,ticket_price);
                                System.out.println("Added To Waiting List!");
                            }else{
                                System.out.println("Details Discarded !");
                            }
                        }
                    }
                    enter_wait();
                    break;
                }else{
                    com = -1;
                }
            }
        }
    }
    public void displayTicket(int ticket_id){
        Ticket ticket = tickets.get(ticket_id);
        System.out.println("Ticket Number : "+ticket.regNo +"\nBoarding : " + stops[ticket.board] + "\nUnboarding : " + stops[ticket.leave] + "\nTicket Status : " + (ticket.confirmed?"Confirmed":"Waiting") +"\nNumber of Passengers : "+ticket.seat_nos+ "\nPrice : " + ticket.price);
        if(ticket.confirmed){
            System.out.print("Seat Number : ");
            for(int i:ticket.seat_nums){
                System.out.print(i+" ");
            }
            System.out.println("\n");
        }
    }
    public int cancelTicket(int ticket_ind){
        Ticket ticket = tickets.get(ticket_ind);
        int price = 0;
        if(ticket.confirmed){
            for(int i:ticket.seat_nums){
                for(int j = ticket.board; j < ticket.leave; j++){
                    seats[i][j] = 0;
                }
            }
            price = ticket.price/2;
            tickets.remove(ticket_ind);
            evalWaitingList();
        }else{
            price = ticket.price;
            tickets.remove(ticket_ind);
        }
        return price;
    }
    public int cancelReturn(int ticket_ind){
        Ticket ticket = tickets.get(ticket_ind);
        int price = 0;
        if(ticket.confirmed){
            price = ticket.price/2;
        }else{
            price = ticket.price;
        }
        return price;
    }
    public void evalWaitingList(){
        for(Ticket tic:tickets){
            if(!tic.confirmed){
                if(seat_avail(tic.board, tic.leave, tic.seat_nos)){
                    tic.seat_nums = seat_book(tic.board, tic.leave, tic.seat_nos);
                    tic.confirmed = true;

                }
            }
        }
    }
}
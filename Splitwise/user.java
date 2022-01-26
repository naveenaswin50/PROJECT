import java.util.*;
public class user {
    String name;
    String EmailID;
    String password;
    int wallet;
    int indexs;
    List<payment>pay=new ArrayList<>();
    String trans;
    public user(String a,String b,String c,int d){
        this.name=a;
        this.EmailID=b;
        this.password=c;
        this.wallet=500;
        this.indexs=d;
        this.trans="";
    }
    public user(){}
    static List<user>use=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    private void cls() {
        System.out.print("\033[H\033[2J");
    }
    public void signin() {
        int attempt=0;
        l:while(attempt++<3){
            cls();
            System.out.println("Welcome User");
            System.out.print("Enter your EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter your Password : ");
            String b=sc.nextLine();
            int ind = isuser(a);
            if(ind!=-1){
                if(use.get(ind).password.equals(b)){
                    usermenu(ind);
                    break l;
                }
            }
            System.out.println("Entered Credentials are Wrong");
            next();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
        next();
    }
    public void usermenu(int ind) {
        group g=new group();
        int cho=0;
        while(true){
            cls();
            System.out.println("""
                    WELCOME
            1 - Add an Expense
            2 - Update wallet
            3 - Creat a gorup
            4 - Add friend to group
            5 - remove friend from group
            6 - View/pay pending dues
            7 - Transaction History
            0 - Logout""");
            if(cho==-1)System.out.println("Invalid Input!!..");
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    addexpense(ind);
                break;
                case 2:
                    update(ind);
                break;
                case 3:
                    g.create_group(ind);
                break;
                case 4:
                    g.add_friend(ind);
                    break;
                case 5:
                g.remove_friend(ind);
                break;
                case 6:
                    V_P_due(ind);
                break;
                case 7:
                V_trans(ind);
                break;
                case 0:
                    login z=new login();
                    z.welcome();
                    break ;
                default:
                cho=-1;
            }
        }
    }
    private void V_trans(int ind) {
        if(use.get(ind).trans.equals("")){
            System.out.println("No transation are done");
            next();
            usermenu(ind);
        }
        System.out.println(use.get(ind).trans);
        next();
    }
    private void V_P_due(int ind) {
        cls();
        int total=0;
        if(use.get(ind).pay.size()==0){
            System.out.println("There is no dues pending");
            next();
            usermenu(ind);
        }
        for(int i=0;i<use.get(ind).pay.size();i++){
            System.out.println("Your group name : "+use.get(ind).pay.get(i).Gname);
            System.out.println("Your Request EmailID : "+use.get(ind).pay.get(i).Reqname);
            System.out.println("Your Expence details : "+use.get(ind).pay.get(i).Expname);
            System.out.println("Your amount : "+use.get(ind).pay.get(i).amount);
            total+=use.get(ind).pay.get(i).amount;
            System.out.println("Date : "+use.get(ind).pay.get(i).date);
            System.out.println("-----------------------------");
            System.out.println();
        }
        System.out.println("Total amount : "+total);
        int cho=0;
        int n=use.get(ind).pay.size();
        while(true){
            System.out.println("press 1 to pay dues(0 - back)");
            System.out.print("Choise : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                if(use.get(ind).wallet>total){
                    use.get(ind).wallet-=total;
                    System.out.println("Due payed Successfully!!..");
                    for(int i=n-1;i>=0;i--){
                        int index=isuser(use.get(ind).pay.get(i).Reqname);
                        use.get(index).wallet+=use.get(ind).pay.get(i).amount;
                        use.get(index).trans+=use.get(ind).pay.get(i).amount+" amount is creit to your wallet from "+use.get(ind).name+"\n";
                        use.get(ind).trans+=use.get(ind).pay.get(i).amount+" amount is debited from your wallet to "+use.get(index).name+"\n";
                        use.get(ind).pay.remove(i);
                    }
                    next();
                    usermenu(ind);
                }else{
                    System.out.println("There is not enough amount in your's wallet");
                    next();
                    usermenu(ind);
                }
                break;
                case 0:
                usermenu(ind);
                break;
                default:
                System.out.println("Invalid input;");
            }
        }
    }
    private void update(int ind) {
        int cho=0;
        l:while(true){
            cls();
            System.out.println("Your Wallet amount is = "+use.get(ind).wallet);
            System.out.println("""
            1 - Add money
            0 - Back""");
            if(cho==-1){
                System.out.println("Enter valid Choise!!..");
            }
            cho=sc.nextInt();
            switch(cho){
                case 1:
                System.out.print("Enter money to add in wallet : ");
                use.get(ind).wallet+=sc.nextInt();sc.nextLine();
                System.out.println("Amount Added Succesfully!.");
                next();
                break l;
                case 0:
                break l;
            }
        }
    }
    private void addexpense(int ind) {
        int cho=0;
        l:while(true){
            cls();
            System.out.println("""
            WELCOME
            1 - Group Expense
            2 - Non Group Expense
            0 - Back""");
            if(cho==-1)System.out.println("Invalid Input!!..");
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                groupexpense(ind);
                break;
                case 2:
                nongroupexpence(ind);
                break;
                case 0:
                break l;
                default:
                cho=-1;
            }
        }
    }
    private void nongroupexpence(int ind) {
        System.out.print("Enter no.of users(including you) : ");
        int n=sc.nextInt();sc.nextLine();
        System.out.print("Enter expense detais : ");
        String c=sc.nextLine();
        System.out.print("Enter total amount : ");
        int d=sc.nextInt()/n;sc.nextLine();
        System.out.print("Enter date in formate of (DD/MM/YYYY) : ");
        String e=sc.nextLine();
        for(int i=0;i<n-1;){
            System.out.print("Enter EmailID : ");
            String users=sc.nextLine();
            int index=isuser(users);
            if(index!=-1){
                System.out.print("Enter user's password : ");
                String pass=sc.nextLine();
                if(pass.equals(use.get(index).password)){
                    use.get(index).pay.add(new payment("non group expense",use.get(ind).EmailID,c,d,e));
                    i++;
                }
            }
        }

    }
    private void groupexpense(int ind) {
        group z=new group();
        System.out.print("Enter your group name : ");
        String a=sc.nextLine();
        String b=use.get(ind).EmailID;
        if(z.isgroup(a)){
            if(z.isgroup_user(a,b)){
                System.out.print("Enter Expense details : ");
                String c=sc.nextLine();
                System.out.print("Enter Expense amount : ");
                int d=sc.nextInt()/group.x.get(a).size();sc.nextLine();
                System.out.print("Enter date in formate of (DD/MM/YYYY) : ");
                String e=sc.nextLine();
                System.out.print("Press (y/n) to update or discard it : ");
                char ans=sc.nextLine().charAt(0);
                if(ans=='y'){
                    for(int i=0;i<group.x.get(a).size();i++){
                        if(b.equals(group.x.get(a).get(i).EmailID)){
                            continue;
                        }else{
                            use.get(group.x.get(a).get(i).indexs).pay.add(new payment(a,b,c,d,e));
                        }
                    }
                }else{
                    System.out.println("Enter details are discarded");
                }
                next();
            }else{
                System.out.println("Enter Details are Wrong");
                next();
            }
        }else{
            System.out.println("Enter Details are Wrong");
            next();
        }
    }
    protected int isuser(String a) {
        for(int i=0;i<use.size();i++){
            if(a.equals(use.get(i).EmailID)){
                return i;
            }
        }
        return -1;
    }
    void next() {
        System.out.print("Press ENTER to Continue!!..");
        sc.nextLine();
    }
    public void adduser() {
        System.out.print("Enter user name : ");
        String a=sc.nextLine();
        String b;
        int count=0;
        do{
            if(++count>1)System.out.println("User id already exist");
            System.out.print("Enter user EmailID : ");
            b = sc.nextLine();
        }
        while(isuser(b)!=-1);
        System.out.print("Enter user Password : ");
        String c=sc.nextLine();
        use.add(new user(a, b, c,use.size()));
        // for(int i=0;i<use.size();i++){
        //     System.out.println(use.get(i).indexs);
        // }
        next();
    }
}

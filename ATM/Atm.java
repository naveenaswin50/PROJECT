import java.util.*;
class Admin{
    static Scanner sc;
    static int amount[]={0,10,2,0};
    static Admin ad=new Admin();
    void addmoney(){
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.print("Enter the no of 2000 notes : ");
        amount[0]+=sc.nextInt();
        System.out.print("Enter the no of 500 notes : ");
        amount[1]+=sc.nextInt();
        System.out.print("Enter the no of 200 notes : ");
        amount[2]+=sc.nextInt();
        System.out.print("Enter the no of 100 notes : ");
        amount[3]+=sc.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("\n\t\tMoney add to ATM succesfully..");
        System.out.println("press 0 and enter..");
        int a=sc.nextInt();
        if(a==0){
            ad.Alogin(); 
        }
    }
    void show(){
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.print("no.of 2000 notes in ATM : ");
        System.out.println(amount[0]);
        System.out.print("no.of 500 notes in ATM : ");
        System.out.println(amount[1]);
        System.out.print("no.of 200 notes in ATM : ");
        System.out.println(amount[2]);
        System.out.print("no.of 100 notes in ATM : ");
        System.out.println(amount[3]);
        System.out.println("press 0 and enter..");
        int a=sc.nextInt();
        if(a==0){
            ad.Alogin(); 
        }
    }
    void Alogin(){
        sc=new Scanner(System.in);
        boolean flag=true;
        int n=0;
        while(flag){
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            System.out.println("Logged in Succesufully\nAdmin");
            System.out.print("1:Add Money\n2:Show Money\n3:exit\nEnter Your Choise :");
            n=sc.nextInt();
            switch(n){
                case 1:
                ad.addmoney();
                break;
                case 2:
                ad.show();
                break;
                case 3:
                ATM z=new ATM();
                z.mainfun();
                flag=false;
                break;
                default:
                System.out.println("Invalid inut");
                break;
            }
        }
    }
}
class Customer{
    static Scanner sc;
    static String str[]={"",""};
    int bal[]={50000,55000};
    static Customer cu=new Customer();
    void getdrawal(int i){
        int with[]={0,0,0,0};
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("Enter the amount to withdrawal");
        int dra=sc.nextInt();
        int temp=dra;
        int a=dra%10;
        int b=(dra/10)%10;
        int TA=2000*Admin.amount[0]+500*Admin.amount[1]+200*Admin.amount[2]+100*Admin.amount[3];
        if((a==0&&b==0)){
        if(dra<bal[i]){
        if(temp<=TA){
                while(2000<=dra && Admin.amount[0]>0){
                    dra=dra-2000;
                    with[0]++;
                    Admin.amount[0]--;
                }
                while(500<=dra && Admin.amount[1]>0){
                    dra=dra-500;
                    with[1]++;
                    Admin.amount[1]--;
                }
                while(200<=dra && Admin.amount[2]>0){
                    dra=dra-200;
                    with[2]++;
                    Admin.amount[2]--;
                }
                while(100<=dra && Admin.amount[3]>0){
                    dra=dra-100;
                    with[3]++;
                    Admin.amount[3]--;
                }
            if(Admin.amount[0]>=0&&Admin.amount[1]>=0&&Admin.amount[2]>=0&&Admin.amount[3]>=0&&dra==0){
            bal[i]-=temp;
        System.out.println("Your amount is sucessfully withdraval");
        System.out.println("2000  ->  "+with[0]);
        System.out.println("500  ->  "+with[1]);
        System.out.println("200  ->  "+with[2]);
        System.out.println("100  ->  "+with[3]);
        System.out.println("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        str[i]+=temp+" amount is debit and your closing balance "+bal[i]+",";
        if(c==0){
            cu.Clogin(i);
        }
    }else{
        Admin.amount[0]+=with[0];
        Admin.amount[1]+=with[1];
        Admin.amount[2]+=with[2];
        Admin.amount[3]+=with[3];
        System.out.println("Insufficient balance in ATM");
        System.out.print("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
    }
    }else{
        System.out.println("Insufficient balance in ATM");
        System.out.print("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
    }
    }else{
    System.out.println("Insufficient balance in Account");
    System.out.print("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
}

    }else{
        System.out.print("Invalid Input");
        System.out.print("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
    }
    }
    void showbalance(int i){
        System.out.println("Your balance is : "+bal[i]);
        System.out.println("\n\n\tPress 0 and enter");
        int a=sc.nextInt();
        if(a==0){
            cu.Clogin(i);
        }
    }
    void pinchange(int i){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.print("Enter your old pin : ");
        int old=sc.nextInt();
        if(old==ATM.pin[i]){
            System.out.print("Enter your new Pin : ");
            int newpin=sc.nextInt();
            ATM.pin[i]=newpin;
            System.out.print("\n\npin Change Sucessfully!...");
            str[i]+=" your pin is changed from"+old+"to new pin"+newpin+",";
            System.out.println("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
        }
    }
    void deposite(int i){
        System.out.print("Enter the amount to be deposite : ");
        int dep=sc.nextInt();
        bal[i]+=dep;
        System.out.print("Enter no of 2000 notes : ");
        int c2000=sc.nextInt();
        Admin.amount[0]+=c2000;
        System.out.print("Enter no of 500 notes : ");
        int c500=sc.nextInt();
        Admin.amount[1]+=c500;
        System.out.print("Enter no of 200 notes : ");
        int c200=sc.nextInt();
        Admin.amount[2]+=c200;
        System.out.print("Enter no of 100 notes : ");
        int c100=sc.nextInt();
        Admin.amount[3]+=c100;
        if(c2000*2000+c500*500+c200*200+c100*100==dep){
            System.out.println("\n\tAmount deposited Sucessfully!!...");
            str[i]+=dep+" amount is credit and your closing balance "+(bal[i])+",";
            System.out.println("\n\n\tPress 0 and enter");
        int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
        }
    }
    void transfer1(int i){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.print("Enter the user name : ");
        sc.nextLine();
        String cus=sc.nextLine();
        int k=-1;
        boolean fla=false;
        f:for(int j=0;j<ATM.cusname.length;j++){
            if(ATM.cusname[j].equals(cus)){
                fla=true;
                k=j;
                break f;
            }
        }
            if(fla){
            System.out.print("Enter amount to transfer : ");
            int tamount=sc.nextInt();
            if(tamount<bal[i]){
                bal[i]-=tamount;
                bal[k]+=tamount;
                System.out.println("Fund Sucessfully transfered!!");
                str[i]+=tamount+" amount is transfered to "+ATM.cusname[k]+",";
                System.out.println("\n\n\tPress 0 and enter");
            int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
            }
        }else{
            System.out.println("\n\t\tUser not found!!!..");
            System.out.println("\n\n\tPress 0 and enter");
            int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
        }
    }
    void minist(int i){
        String arr[]=str[i].split(",");
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        for(String k : arr){
            System.out.println(k);
        }
        System.out.println("\n\n\tPress 0 and enter");
            int c=sc.nextInt();
        if(c==0){
            cu.Clogin(i);
        }
    }
    boolean flag=true;
    void Clogin(int i){
        sc=new Scanner(System.in);
        int n=0;
        while(flag){
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            System.out.println("Logged in Succesfully\nCustomer");
            System.out.print("1:Withdrawal\n2:Show balance\n3:Pin Change\n4:Transfer fund\n5:deposite\n6:Ministatement\n7:exit\nEnter Your Choise :");
            n=sc.nextInt();
            switch(n){
                case 1:
                    cu.getdrawal(i);
                    break;
                case 2:
                    cu.showbalance(i);
                    break;
                case 3:
                    cu.pinchange(i);
                    break;
                case 4:
                    cu.transfer1(i);
                    break;
                case 5:
                    cu.deposite(i);
                    break;
                case 6:
                    cu.minist(i);
                    break;
                case 7:
                    ATM z=new ATM();
                    z.mainfun();
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid inut");
                break;
            }
        }
    }
}
class ATM {
    static Scanner sc;
    static boolean f=false;
    static String cusname[]={"user 1","user 2"};
    static int pin[]={2345,5432};
    void mainfun(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        sc=new Scanner(System.in);
        int n=0;
        int c=0;
        while(!f){
            if(c==3){
                f=true;
                System.out.println("\nyour account is blocked for 24 hours!!.");
                System.exit(0);
            }
            System.out.println("ATM");
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            System.out.print("Enter your Choice : ");
            n=sc.nextInt();
        switch(n){
            case 1:
                System.out.print("Enter your Admin username : ");
                sc.nextLine();
                String name=sc.nextLine();
                    System.out.print("Enter your Admin password : ");
                    String pass=sc.nextLine();
                    if(pass.equals("123456")&&name.equals("admin")){
                        Admin z=new Admin();
                        z.Alogin();
                        f=true;
                    }else{
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        System.out.println("Invalid user name or password");
                    }
                break;
            case 2:
                System.out.print("Enter your Customer username : ");
                sc.nextLine();
                String cname=sc.next();
                System.out.print("Enter your Customer password : ");
                int cpass=sc.nextInt();
                    if(cpass==pin[0]&&cname.equals(cusname[0])){
                        Customer z=new Customer();
                        int i=0;
                        z.Clogin(i);
                    }
                    else if(cpass==pin[1]&&cname.equals(cusname[1])){
                        Customer z=new Customer();
                        int i=1;
                        z.Clogin(i);
                    }else{
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        c++;
                        System.out.println("Invalid user name or password");
                    }
                break;
            case 3:
                f=true;
                System.exit(0);
                break;
            default:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Invalid input");
                break;
        }
    }
     }
    public static void main(String[] args) {
        ATM z=new ATM();
        z.mainfun();
    }
}

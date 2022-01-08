package Zoho.Amazon;
import java.util.*;
public class Buyer{
    String buyer;
    String pin;
    String Bid;
    String cart;
    int vallet;
    String odd;
    Buyer(String a,String b,String c){
        this.buyer=a;
        this.pin=b;
        this.Bid=c;
        this.cart="";
        this.vallet=0;
        this.odd="";
    }
    static Scanner sc;
    static Buyer z=new Buyer();
    static List<Buyer>buy=new ArrayList<>();
    static int bu=100;
    Buyer(){}
    void bmainfun(){
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J");

        while(true){
            System.out.println("""
                                    WELCOME 
                                    1.New Buyer
                                    2.Existing Buyer
                                    3.Back""");
            System.out.print("Enter your choise : ");
            int a=sc.nextInt();
            switch(a){
                case 1:
                    z.adduser();
                break;
                case 2:
                    z.existuser();
                break;
                case 3:
                    Amazon h=new Amazon();
                    h.mainfun();
                break;
            }
        }
    }
    void adduser(){
        sc.nextLine();
        System.out.print("Enter your name : ");
        String a=sc.nextLine();
        System.out.print("Enter your password : ");
        String b=sc.nextLine();
        bu++;
        String c="B"+bu;
        buy.add(new Buyer(a, b, c));
        System.out.println("your id is : "+c);
        System.out.println("Buyer added Successfully!!.");
        System.out.println("\npress enter to continue..");
        sc.nextLine();
        z.bmainfun();
    }
    void existuser(){
        sc.nextLine();
        System.out.print("Enter your id : ");
        String a=sc.nextLine();
        boolean fla=false;
        int k=-1;
        for(int i=0;i<buy.size();i++){
            if(a.equals(buy.get(i).Bid)){
                k=i;
                fla=true;
            }
        }if(fla){
            System.out.print("Enter your pin : ");
            String b=sc.nextLine();
            if(buy.get(k).pin.equals(b)){
                System.out.println("\npress enter to continue..");
                order z=new order();
                z.omainfun(k);
            }
        }
        else{
            System.out.println("user is not found!!..");
            System.out.println("\npress enter to continue..");
            sc.nextLine();
            z.bmainfun();
        }
    }
}

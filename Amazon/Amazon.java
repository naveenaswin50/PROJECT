package Zoho.Amazon;
import java.util.*;
public class Amazon {
    static Scanner sc;
    static Amazon z=new Amazon();
    void mainfun(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        while(true){
            System.out.println("WELCOME TO AMAZON");
            System.out.println("1:Admin\n2:Merchant\n3:Buyer\n4:Exit");
            System.out.print("Enter your option : ");
            int choise=sc.nextInt();
            switch(choise){
                case 1:
                System.out.print("Enter your username : ");
                String name=sc.next();
                System.out.print("Enter your passcode : ");
                int pass=sc.nextInt();
                if(name.equals("login")&&pass==1234){
                    Admin x=new Admin();
                    x.mainfun();   
                }else{
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Invalid user or password");
                }
                    break;
                case 2:
                    Marchent z=new Marchent();
                    z.mainpage();
                    break ;
                case 3:
                    Buyer h=new Buyer();
                    h.bmainfun();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        z.mainfun();
    }
}

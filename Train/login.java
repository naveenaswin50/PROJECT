package Zoho.Train;
import java.util.*;
class bookingh{
    public static void main(String[] args){
        welcome();
    }
    static Scanner  s = new Scanner(System.in);

    public static void cls(){
        try{
            System.out.print("\033[H\033[2J");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void welcome(){
        int com = 0;
        while(true){
            cls();
            System.out.println("            Welcome to E - Rail Booking  ");
            System.out.println("Select User Type:\n1:Customer\n0:Exit");
            
            if(com == -1){
                System.out.println("Please Enter a valid Choise.");
            }
            System.out.print("Choise : ");
            com = s.nextInt();s.nextLine();

            switch(com){
                case 1:
                    Customer.customerWelcome();
                    break;
                case 0:
                    System.exit(0);
                    break ;
                default:
                    com = -1;
            } 
        }
    }
}
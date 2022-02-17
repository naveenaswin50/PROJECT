import java.util.*;
class Login {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Login z=new Login();
        z.welcome();
        // String s=String.format("book %d has been issued to %s Succesfully", 1234,"naveen");
        // System.out.println(s);
    }
    void cls(){
        try{
            System.out.print("\033[H\033[2J");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void  welcome(){
        int com=0;
        while (true) {
            cls();
            System.out.println("            Welcome");
            System.out.println("Select User Type:\n1 - Admin\n2 - Barrower\n0 - Exit");
            
            if(com == -1){
                System.out.println("Please Enter a valid Choise.");
            }
            System.out.print("Choise : ");
            com = sc.nextInt();sc.nextLine();

            switch(com){
                case 1:
                Admin x=new Admin();
                    x.adminpage();
                    break;
                case 2:
                    Borrower z=new Borrower();
                    z.barrowerpage();
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

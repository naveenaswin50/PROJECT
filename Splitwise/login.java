package Zoho.Splitwise;
import java.util.*;
public class login {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        user.use.add(new user("user1", "user1", "123",0));
        user.use.add(new user("user2", "user2", "123",1));
        user.use.add(new user("user3", "user3", "123",2));
        user.use.add(new user("user4", "user4", "123",3));
        user.use.add(new user("user5", "user5", "123",4));
        user.use.add(new user("user6", "user6", "123",5));
        login z=new login();
        z.welcome();
    }
    private void cls() {
        System.out.print("\033[H\033[2J");
    }
    public void welcome() {
        int cho=0;
        user x=new user();
        while(true){
            cls();
            System.out.println("""
            1 - Sign in
            2 - Sign up
            0 - Exit""");
            if(cho==-1)System.out.println("Invalid input");
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    x.signin();
                break;
                case 2:
                    x.adduser();
                break;
                case 0:
                System.exit(0);
                break;
                default :
                cho=-1;
            }
        }
    }
}

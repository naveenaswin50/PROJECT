package Zoho.Amazon;
import java.util.*;
public class Marchent {
    String username;
    String id;
    int pin;
    String status;
    Marchent(String a,String b,int c,String d){
        this.username=a;
        this.id=b;
        this.pin=c;
        this.status=d;
    }
    Marchent(){}
    static int b=101;
    static List<Marchent>ls=new ArrayList<>();
    Scanner sc;
    void mainpage(){
        ls.add(new Marchent("naveen","m100",1234,"ok"));
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        while(true){
            System.out.println("\t Welcome Merchant");
            System.out.println("1:New Merchant\n2:Existing Merchant\n3:Back");
            System.out.print("Enter your choice : ");
            int a=sc.nextInt();
            switch(a){
                case 1:
                     newm();
                    break;
                case 2:
                    existing();
                    break;
                case 3:
                    Amazon z=new Amazon();
                    z.mainfun();
                    break;
                default:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Invalid input!!..");
                    break;
            }
        }
    }
    void newm(){
        System.out.print("\033[H\033[2J");
        sc.nextLine();
        System.out.print("Enter your username : ");
        String a=sc.nextLine();
        System.out.print("Enter your password : ");
        int c=sc.nextInt();
        sc.nextLine();
        int h=b++;
        String B="M"+h;
        ls.add(new Marchent(a,B,c,"no"));
        System.out.println("user is wating for approval!!.");
        System.out.println("your id : "+B);
        System.out.println("Press enter to continue....");
        sc.nextLine();
        Marchent z=new Marchent();
        z.mainpage();
    }
    int findapp(int v){
        if(ls.get(v).status.equals("ok")){
            return 1;
        }
        else if(ls.get(v).status.equals("ban")){
            return 2;
        }
        return 3;
    }
    void existing(){
        System.out.print("\033[H\033[2J");
        sc.nextLine();
        int k=-1;
        boolean fla=false;
        System.out.print("Enter your user id : ");
        String id=sc.nextLine();
        for(int i=0;i<ls.size();i++){
            if(ls.get(i).id.equals(id)){
                k=i;
                fla=true;
                break;
            }
        }
        if(fla){
            System.out.print("Enter your password : ");
            int pass=sc.nextInt();
            if(ls.get(k).pin==pass){
            if(ls.get(k).id.equals(id)&&findapp(k)==1){
                Product x=new Product();
                x.pmainpage(k);
            }else if(findapp(k)==2){
                System.out.println("Yours account is banned \n please contact admin !..");
                System.out.println("Press enter to continue ");
                sc.nextLine();
                sc.nextLine();
                Marchent z=new Marchent();
                z.mainpage();
            }else{
                System.out.println("Wating for approval");
                System.out.println("Press enter to continue ");
                sc.nextLine();
                sc.nextLine();
                Marchent z=new Marchent();
                z.mainpage();
            }
        }else{
            System.out.println("Enter pin correctly");
            System.out.println("press enter to continue ");
            sc.nextLine();
            sc.nextLine();
            Marchent z=new Marchent();
            z.mainpage();
        }
        }else{
            System.out.println("Merchant not found!!..");
            System.out.println("press enter to continue ");
            sc.nextLine();
            Marchent z=new Marchent();
            z.mainpage();
        }
    }
}

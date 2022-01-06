package Zoho.Amazon;
import java.util.Scanner;
class Admin{
    static Scanner sc;
    static Amazon z=new Amazon();
    static Admin x=new Admin();
    void mainfun(){
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        while(true){
            System.out.println("\tlogged in Successfully!!..");
            System.out.println("Admin");
            System.out.println("1:Add Merchant\n2:Remove Merchant\n3:Approval Merchant\n4:Back");
            System.out.print("Enter your choice : ");
            int a=sc.nextInt();
            switch(a){
                case 1:
                    addMerchant();
                    break;
                case 2:
                     RemoveMerchant();
                    break;
                case 3:
                     ApprovalMearchant();
                    break;
                case 4:
                    z.mainfun();
                    break;
                default :
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Invalid input");
                break;
            }
        }
    }
    void addMerchant(){
        sc.nextLine();
        System.out.print("Enter your username : ");
        String a=sc.nextLine();
        System.out.print("Enter your pin : ");
        int c=sc.nextInt();
        int d=Marchent.b++;
        String h="M"+d;
        Marchent.ls.add(new Marchent(a,h,c,"ok"));
        System.out.print("\033[H\033[2J");  
        System.out.println("User name:"+a);
        System.out.println("User id:"+h);
        System.out.println("Mearchent is added!!..");
        System.out.println("Press enter to continue");
        sc.nextLine();
        sc.nextLine();
        System.out.print("\033[H\033[2J");  
        x.mainfun();
    }
    void RemoveMerchant(){
        System.out.print("\033[H\033[2J");
        sc.nextLine();
        System.out.print("Enter user id : ");
        String a=sc.nextLine();
        int k=-1;
        boolean fla=false;
        for(int i=0;i<Marchent.ls.size();i++){
            if(Marchent.ls.get(i).id.equals(a)){
                k=i;
                fla=true;
                break;
            }
        }
        if(fla){
            Marchent.ls.get(k).status="ban";
            System.out.println("Merchant is baned Successfully!!.");
            System.out.println("\nPress enter to continue");
            sc.nextLine();
            sc.nextLine();
            x.mainfun();
        }else{
            System.out.println("Merchant is not found!!..");
            System.out.println("\nPress enter to continue");
            sc.nextLine();
            sc.nextLine();
            x.mainfun();
        }
    }
    void ApprovalMearchant(){
        System.out.print("\033[H\033[2J");
        boolean flag=false;
        String str="";
        for(int i=0;i<Marchent.ls.size();i++){
            if(Marchent.ls.get(i).status.equals("no")){
                str+=i+",";
                flag=true;
            }
        }
        if(flag){
            String arr[]=str.split(",");
            for(int i=0;i<arr.length;i++){
                int k=Integer.parseInt(arr[i]);
                System.out.println("Merchant username:"+Marchent.ls.get(k).username);
                System.out.println("Merchant id:"+Marchent.ls.get(k).id);
                System.out.println("Enter 1 to Apporval");
                System.out.println("Enter 0 to ban the Merchant");
                int a=sc.nextInt();
                if(a==1){
                    Marchent.ls.get(k).status="ok";
                    System.out.println("Merchant Appovraled successfully");
                    System.out.println("press enter to continue;");
                    sc.nextLine();
                    String dd=sc.nextLine();
                    if(dd.equals("")){}
                    System.out.print("\033[H\033[2J");
                }else if(a==0){
                    Marchent.ls.get(k).status="ban";
                    System.out.println("Merchant banned successfully");
                    System.out.println("press enter to continue;");
                    sc.nextLine();
                    String dd=sc.nextLine();
                    if(dd.equals("")){}
                    System.out.print("\033[H\033[2J");
                }
            }
            System.out.println("No Merchant for appovral!!..");
            System.out.println("press enter to continue;");
            sc.nextLine();
        }else{
            System.out.println("No Merchant for appovral!!..");
            System.out.println("press enter to continue;");
            sc.nextLine();
            sc.nextLine();
        }
        x.mainfun();
    }
}
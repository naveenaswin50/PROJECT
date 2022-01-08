package Zoho.Amazon;
import java.util.*;
public class order {
    static Scanner sc;
    static order z=new order();
    void omainfun(int k){
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J"); 
        while (true){
            // sc.nextLine();
            System.out.println("WELCOME "+Buyer.buy.get(k).buyer);
            System.out.println("""
                            1.Add to cart
                            2.Remove from cart
                            3.Check out
                            4.place order
                            5.Return
                            6.wallet
                            7.pin change
                            8.back""");
            System.out.print("Enter your choise : ");
            int a=sc.nextInt();
            switch(a){
                case 1:
                z.addtocart(k);
                break;
                case 2:
                z.remove(k);
                break;
                case 3:
                Checkout(k);
                break;
                case 4:
                placeod(k);
                break;
                case 5:
                Return(k);
                break;
                case 7:
                pincha(k);
                break;
                case 6:
                valet(k);
                break;
                case 8:
                Buyer x=new Buyer();
                x.bmainfun();
                break;
                default:
                System.out.print("\033[H\033[2J"); 
                System.out.println("Invalid input!");
                break;
            }
        }
    }
    void Return(int k) {
        System.out.print("\033[H\033[2J");
        // try{ 
        String arr[]=Buyer.buy.get(k).odd.split(",");
        int ars[]=new int[arr.length];
        System.out.print("Product name "); 
        System.out.print(" product id "); 
        System.out.print(" Merchant id "); 
        System.out.print(" Price"); 
        System.out.print(" Waranty "); 
        System.out.print(" Return time ");
        System.out.println();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<Product.pl1.size();j++){
                int tp=Integer.parseInt(arr[i]);
                if(tp==Product.pl1.get(j).pro_id){
                    System.out.printf("%10s",Product.pl1.get(j).name+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).pro_id+" "); 
                    System.out.printf("%15s",Product.pl1.get(j).M_id+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).Price+" "); 
                    System.out.printf("%9s",Product.pl1.get(j).War+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).Return+" ");
                    System.out.println();
                    ars[i]=Product.pl1.get(j).Price;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter product id to return : ");
        int f=sc.nextInt();
        if(checkk(f,arr)){
            String ar="";
            int c=0;
        for(int i=0;i<arr.length;i++){
            int tp=Integer.parseInt(arr[i]);
            if(f==tp&&c<1){
                Buyer.buy.get(k).vallet+=ars[i];
                System.out.println("Return Successfully!!.");
                System.out.println("press enter to continue!!.");
                sc.nextLine();
                c++;
                ar+="";  
            }
            else{
            ar+=(tp+",");
        }
    }
    Buyer.buy.get(k).odd=ar;
    }else{
        System.out.println("Enter correct product id!!..");
        System.out.println("press enter to continue!!.");
        sc.nextLine();
        sc.nextLine();
    }
    // }catch(Exception NumberFormatException){
        // System.out.println("ther is no product in order ");
        // System.out.println("Press Enter to buy product for now");
        // sc.nextLine();
        // sc.nextLine();
        // z.placeod(k);
    // }
    }
    void pincha(int k) {
        sc.nextLine();
        System.out.print("Enter your pin :");
        String asd=sc.nextLine();
        if(asd.equals(Buyer.buy.get(k).pin)){
            System.out.print("Enter your new Pin : ");
            Buyer.buy.get(k).pin=sc.nextLine();
            System.out.println("Pin change Successfully!!.");
            System.out.println("Press Enter to Continue !");
            sc.nextLine();
            omainfun(k);
        }else{
            System.out.println("Enter your pin correctly : ");
            System.out.println("Press Enter to Continue !");
            sc.nextLine();
            omainfun(k);
        }
    }
    void placeod(int k) {
        System.out.print("\033[H\033[2J"); 
        System.out.print("Product name "); 
        System.out.print(" product id "); 
        System.out.print(" Merchant id "); 
        System.out.print(" Pricr "); 
        System.out.print(" Waranty "); 
        System.out.print(" Quantity "); 
        System.out.print(" Return time ");
        System.out.println();
        for(int i=0;i<Product.pl1.size();i++){
            System.out.printf("%10s",Product.pl1.get(i).name+" "); 
            System.out.printf("%10s",Product.pl1.get(i).pro_id+" "); 
            System.out.printf("%15s",Product.pl1.get(i).M_id+" "); 
            System.out.printf("%10s",Product.pl1.get(i).Price+" "); 
            System.out.printf("%9s",Product.pl1.get(i).War+" "); 
            System.out.printf("%8s",Product.pl1.get(i).quantity+" "); 
            System.out.printf("%10s",Product.pl1.get(i).Return+" "); 
            System.out.println();
        }
        System.out.print("Enter product id : ");
        int a=sc.nextInt();
        boolean fla=false;
        sc.nextLine();
        System.out.print("Enter Merchant id : ");
        String b=sc.nextLine();
        for(int i=0;i<Product.pl1.size();i++){
            if(a==Product.pl1.get(i).pro_id&&b.equals(Product.pl1.get(i).M_id)){
                if(Product.pl1.get(i).Price<Buyer.buy.get(k).vallet){
                Buyer.buy.get(k).odd+=a+",";
                Buyer.buy.get(k).vallet-=Product.pl1.get(i).Price;
                Product.pl1.get(i).quantity--;
                System.out.println("product odred Successfully!!..");
                System.out.println("press enter to continue!!.");
                sc.nextLine();
                fla=true;
                omainfun(k);
                break;
            }else{
                System.out.println("Add moner in Wallet..");
                System.out.println("press enter to continue!!.");
                fla=true;
                sc.nextLine();
                valet(k);
                }
            }
        }if(fla){
                System.out.println("Enter product id correctly or merchant id ..");
                sc.nextLine();
                omainfun(k);
        }
    }
    void valet(int k) {
        System.out.print("\033[H\033[2J"); 
        System.out.println("Your Wallet Balance : "+Buyer.buy.get(k).vallet);
        System.out.println("Enter 1 for add money  ");
        System.out.println("Enter 0 for go back ");
        System.out.println("Enter your choice : ");
        int w=sc.nextInt();
        if(w==1){
            System.out.print("Enter amount to add wallet amount:");
            int as=sc.nextInt();
            Buyer.buy.get(k).vallet+=as;
            System.out.println("Amount Added Successfully!!.");
            System.out.println("Press Enter to go to main Page : ");
            sc.nextLine();
            sc.nextLine();
            omainfun(k);
        }else{
            omainfun(k);
        }
    }
    void Checkout(int k) {
        try{ 
        System.out.print("\033[H\033[2J"); 
        int total=0;
        String arr[]=Buyer.buy.get(k).cart.split(",");
        System.out.print("Product name "); 
        System.out.print(" product id "); 
        System.out.print(" Merchant id "); 
        System.out.print(" Price"); 
        System.out.print(" Waranty "); 
        System.out.print(" Return time ");
        System.out.println();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<Product.pl1.size();j++){
                int tp=Integer.parseInt(arr[i]);
                if(tp==Product.pl1.get(j).pro_id){
                    System.out.printf("%10s",Product.pl1.get(j).name+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).pro_id+" "); 
                    System.out.printf("%15s",Product.pl1.get(j).M_id+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).Price+" ");
                    total+=Product.pl1.get(j).Price;
                    System.out.printf("%9s",Product.pl1.get(j).War+" ");  
                    System.out.printf("%10s",Product.pl1.get(j).Return+" ");
                    System.out.println();
                }
            }
        }
        System.out.println("Total price of all product in cart ="+total);
        System.out.println("Press enter to place order all product!!..");
        if(total<Buyer.buy.get(k).vallet){
            System.out.println("order placed Successfully!!..");
            Buyer.buy.get(k).odd+=Buyer.buy.get(k).cart+",";
            Buyer.buy.get(k).vallet-=total;
            Buyer.buy.get(k).cart="";
            sc.nextLine();
            sc.nextLine();
            omainfun(k);
        }else{
            System.out.println("not enough money in Wallet!.");
            System.out.println("Press enter to add moner in Wallet.");
            sc.nextLine();
            sc.nextLine();
            valet(k);
        }
        
    }catch(Exception NumberFormatException){
        System.out.println("ther is no product in cart ");
        System.out.println("Press Enter to add product for cart");
        sc.nextLine();
        sc.nextLine();
        z.addtocart(k);
    }
}
    void addtocart(int k){
        System.out.print("\033[H\033[2J"); 
        System.out.print("Product name "); 
        System.out.print(" product id "); 
        System.out.print(" Merchant id "); 
        System.out.print(" Pricr "); 
        System.out.print(" Waranty "); 
        System.out.print(" Quantity "); 
        System.out.print(" Return time ");
        System.out.println();
        for(int i=0;i<Product.pl1.size();i++){
            System.out.printf("%10s",Product.pl1.get(i).name+" "); 
            System.out.printf("%10s",Product.pl1.get(i).pro_id+" "); 
            System.out.printf("%15s",Product.pl1.get(i).M_id+" "); 
            System.out.printf("%10s",Product.pl1.get(i).Price+" "); 
            System.out.printf("%9s",Product.pl1.get(i).War+" "); 
            System.out.printf("%8s",Product.pl1.get(i).quantity+" "); 
            System.out.printf("%10s",Product.pl1.get(i).Return+" "); 
            System.out.println();
        }
        while(true){
            System.out.println("1:for add product ");
            System.out.println("2:for go back ");
            System.out.print("Enter your choice : ");
            int n=sc.nextInt();
            switch(n){
                case 1:
                    System.out.print("Enter product id : ");
                    int a=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Merchant id : ");
                    String b=sc.nextLine();
                    for(int i=0;i<Product.pl1.size();i++){
                        if(a==Product.pl1.get(i).pro_id&&b.equals(Product.pl1.get(i).M_id)){
                            Buyer.buy.get(k).cart+=a+",";
                            Product.pl1.get(i).quantity--;
                            System.out.println("product added Successfully!!..");
                            System.out.println("press enter to continue!!.");
                            sc.nextLine();
                        }
                    }
                break;
                case 2:
                z.omainfun(k);
                break;
                default:
                System.out.println("Invalid input");
                break;
            }
        }
    }
    void remove(int k){
        System.out.print("\033[H\033[2J");
        try{ 
        String arr[]=Buyer.buy.get(k).cart.split(",");
        System.out.print("Product name "); 
        System.out.print(" product id "); 
        System.out.print(" Merchant id "); 
        System.out.print(" Price"); 
        System.out.print(" Waranty "); 
        System.out.print(" Return time ");
        System.out.println();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<Product.pl1.size();j++){
                int tp=Integer.parseInt(arr[i]);
                if(tp==Product.pl1.get(j).pro_id){
                    System.out.printf("%10s",Product.pl1.get(j).name+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).pro_id+" "); 
                    System.out.printf("%15s",Product.pl1.get(j).M_id+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).Price+" "); 
                    System.out.printf("%9s",Product.pl1.get(j).War+" "); 
                    System.out.printf("%10s",Product.pl1.get(j).Return+" ");
                    System.out.println();
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter product id to remove : ");
        int f=sc.nextInt();
        if(checkk(f,arr)){
            String ar="";
            int c=0;
        for(int i=0;i<arr.length;i++){
            int tp=Integer.parseInt(arr[i]);
            if(f==tp&&c<1){
                System.out.println("Removed Successfully!!.");
                System.out.println("press enter to continue!!.");
                sc.nextLine();
                c++;
                ar+="";  
            }
            else{
            ar+=(tp+",");
        }
    }
    Buyer.buy.get(k).cart=ar;
    }else{
        System.out.println("Enter correct product id!!..");
        System.out.println("press enter to continue!!.");
        sc.nextLine();
        sc.nextLine();
    }
    }catch(Exception NumberFormatException){
        System.out.println("ther is no product in cart ");
        System.out.println("Press Enter to add product for cart");
        sc.nextLine();
        sc.nextLine();
        z.addtocart(k);
    }
    }
    boolean checkk(int f,String arr[]){
        for(int i=0;i<arr.length;i++){
            int tp=Integer.parseInt(arr[i]);
            if(tp==f){
                return true;
            }
        }
        return false;
    }

}

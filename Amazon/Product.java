package Zoho.Amazon;
import java.util.*;
public class Product {
    static Scanner sc;
    static Product z=new Product();
    static List <Product>pl1=new ArrayList<>();
    static List <Product>pl2=new ArrayList<>();
    static List <Product>pl3=new ArrayList<>();
    static int q=100;
    String name;
    int pro_id;
    String M_id;
    int Price;
    String War;
    int quantity;
    String Return;
    Product(String a,int b,String c,int d,String e,int f,String g){
        this.name=a;
        this.pro_id=b;
        this.M_id=c;
        this.Price=d;
        this.War=e;
        this.quantity=f;
        this.Return=g;
    }
    Product(){}
    void pmainpage(int k){
        sc=new Scanner(System.in);
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("WELCOME "+Marchent.ls.get(k).username);
            System.out.print("""
                                1.Add Product
                                2.Remove product
                                3.Update Product
                                4.compare Product
                                5.Show My product
                                6.Back
                                Enter your choice : """);
            int n=sc.nextInt();
            switch(n){
                case 1:
                z.addpro(k);
                break;
                case 2:
                z.removepro(k);
                break;
                case 3:
                z.uproduct(k);
                break;
                case 4:
                break;
                case 5:
                z.Showpro(k);
                break;
                case 6:
                    Marchent y=new Marchent();
                    y.mainpage();
                break;
                default:
                break;
            }
        }
    }
    void addpro(int k){
        sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.print("Enter product name : ");
        String a=sc.nextLine();
        System.out.print("Enter product price : ");
        int d=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter product Waranty : ");
        String e=sc.nextLine();
        System.out.print("Enter product Quantity : ");
        int f=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter product return time : ");
        String g=sc.nextLine();
        pl1.add(new Product(a,++q,(Marchent.ls.get(k).id),d,e,f,g));
        System.out.print("\033[H\033[2J");
        System.out.println("Product name : "+a);
        System.out.println("Product id : "+(q));
        System.out.println("Merchant id : "+(Marchent.ls.get(k).id));
        System.out.println("Product price : "+(d));
        System.out.println("Product Warranty : "+(e));
        System.out.println("Product quantity : "+(f));
        System.out.println("Product Return time : "+(g));
        System.out.println("Product is added Successfully!!..");
        System.out.println("\nPress enter to continue!");
        sc.nextLine();
        z.pmainpage(k);
    }
    void removepro(int k){
        System.out.print("Enter your product id : ");
        int a=sc.nextInt();
        int j=0;
        boolean fla=false;
        for(int i=0;i<pl1.size();i++){
            if(a==pl1.get(i).pro_id){
                j=i;
                fla=true;
                break;
            }
        }
        if(fla){
            pl1.remove(j);
            System.out.println("Product deleted Successfully!!..");
            System.out.println("\n Press enter to continue!!.");
            sc.nextLine();
            sc.nextLine();
            z.pmainpage(k);
        }else{
            System.out.println("Product not found!!..");
            System.out.println("\n Press enter to continue!!.");
            sc.nextLine();
            sc.nextLine();
            z.pmainpage(k);
        }
    }
    void uproduct(int k){
        System.out.print("Enter Product id to Update : ");
        int a=sc.nextInt();
        int j=0;
        boolean fla=false;
        for(int i=0;i<pl1.size();i++){
            if(a==pl1.get(i).pro_id){
                j=i;
                fla=true;
                break;
            }
        }if(fla){
            System.out.print("Enter your product price to update : ");
            pl1.get(j).Price=sc.nextInt();
            System.out.print("Enter quantity to Update : ");
            pl1.get(j).quantity=sc.nextInt();
            System.out.println("Product Updated Successfully!!..");
            System.out.println("\n Press enter to continue!!.");
            sc.nextLine();
            sc.nextLine();
            z.pmainpage(k);
        }else{
            System.out.println("Product not found!!..");
            System.out.println("\n Press enter to continue!!.");
            sc.nextLine();
            sc.nextLine();
            z.pmainpage(k);
        }
    }
    void Showpro(int k){
        sc.nextLine();
        System.out.print("Enter your id : ");
        String a=sc.nextLine();
        if(Marchent.ls.get(k).id.equals(a)){
            System.out.print("Product name "); 
            System.out.print(" product id "); 
            System.out.print(" Merchant id "); 
            System.out.print(" Pricr "); 
            System.out.print(" Waranty "); 
            System.out.print(" Quantity "); 
            System.out.print(" Return time "); 
            System.out.println();
            for(int i=0;i<Product.pl1.size();i++){
                if(a.equals(Product.pl1.get(i).M_id)){
                    System.out.printf("%10s",Product.pl1.get(i).name+" "); 
                    System.out.printf("%10s",Product.pl1.get(i).pro_id+" "); 
                    System.out.printf("%15s",Product.pl1.get(i).M_id+" "); 
                    System.out.printf("%10s",Product.pl1.get(i).Price+" "); 
                    System.out.printf("%9s",Product.pl1.get(i).War+" "); 
                    System.out.printf("%8s",Product.pl1.get(i).quantity+" "); 
                    System.out.printf("%10s",Product.pl1.get(i).Return+" "); 
                }
                System.out.println();
            }
            System.out.println("\n Press enter to continue!!.");
            sc.nextLine();
            // sc.nextLine();
            z.pmainpage(k);
        }else{
            System.out.println("Entered id is not correctly");
            System.out.println("\n Press enter to continue!!.");
            sc.nextLine();
            sc.nextLine();
            z.pmainpage(k);
        }
    }
}
package Zoho.Amazon;
import java.util.*;
public class order {
    static Scanner sc;
    static order z=new order();
    void omainfun(int k){
        sc=new Scanner(System.in);
        System.out.print("\033[H\033[2J"); 
        while (true){
            sc.nextLine();
            System.out.println("WELCOME "+Buyer.buy.get(k).buyer);
            System.out.print("""
                            1.Add to cart
                            2.Remove from cart
                            3.place order
                            4.back""");
            System.out.print("Enter your choise : ");
            int a=sc.nextInt();
            switch(a){
                case 1:
                    z.addtocart(k);
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                default:
                System.out.print("\033[H\033[2J"); 
                System.out.println("Invalid input!");
                break;
            }
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
        while(true){
        }
    }
}

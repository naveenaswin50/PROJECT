package Zoho.Librarymanagment;
import java.util.*;
class Book {
    String book_name;
    String author;
    int ISBN;
    int quntity;
    int book_price;
    int borrowcount;
    List<Borrower>borroebook=new ArrayList<>();
    Book(String a,String b,int c,int d,int e){
        this.book_name=a;
        this.author=b;
        this.ISBN=c;
        this.quntity=d;
        this.book_price=e;
    }
    Book(){}
    static Scanner sc=new Scanner(System.in);
    static List<Book>boks=new ArrayList<>();
    static int FineperDay=2;
    static{
        boks.add(new Book("The Iliad", "Homer",121,10,119));
        boks.add(new Book("The Odyssey", "Homer",125,15,168));
        boks.add(new Book("Jane Eyre", "Charlotte Bronte",155,10,176));
        boks.add(new Book("Middlemarch", "George Eliot",195,7,126));
        boks.add(new Book("The Sonnets", "William Shakespeare",168,10,275));
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
    private void nextbutton() {
        System.out.println("Press ENTER to Continue..");
        sc.nextLine();
    }
    public void bookmenu() {
        cls();
        int cho=0;
    l:while(true){
            System.out.println(""" 
                        Welcome Edit menu
            1 - Add Book
            2 - Remove Book
            3 - Modify book details(Quantity and price)
            4 - Sort list by name
            5 - Sort list by Quantity
            0 - Back""");
            if(cho == -1){
                System.out.println("Please Enter a valid Choise.");
            }
            System.out.print("Choise : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    addbook();
                    break;
                case 2:
                    removebook();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                for (int i=0;i<boks.size();i++){
                    int min=i;
                    for (int j=i+1;j<boks.size();j++){
                        if (boks.get(j).book_name.compareTo(boks.get(min).book_name)>0){
                            min=j;
                        }
                    }
                    Book temp=boks.get(i);
                    boks.set(i,boks.get(min));
                    boks.set(min,temp);
                }
                cls();
                System.out.println("Books Sorted in Alphabetic Order");
                printbooklist();
                nextbutton();
                bookmenu();
                break;
                case 5:
                for (int i=0;i<boks.size();i++){
                    int min=i;
                    for (int j=i+1;j<boks.size();j++){
                        if (boks.get(j).quntity<(boks.get(min).quntity)){
                            min=j;
                        }
                    }
                    Book temp=boks.get(i);
                    boks.set(i,boks.get(min));
                    boks.set(min,temp);
                }
                cls();
                System.out.println("Books Sorted in by Quantity");
                printbooklist();
                nextbutton();
                bookmenu();
                break;
                case 0:
                cls();
                 break l;
                default :
                    cho=-1;
            }
        }
    }
    private void printbooklist() {
        System.out.print("Book Name ");
        System.out.print("    Author Name ");
        System.out.print("       Book ISBN ");
        System.out.print("   Book Quantity");
        System.out.print("   Book Price");
        System.out.println();
        for(int i=0;i<boks.size();i++){
            System.out.print(boks.get(i).book_name+" ");
            System.out.printf("%15s",boks.get(i).author+" ");
            System.out.printf("%15s",boks.get(i).ISBN+" ");
            System.out.printf("%15s",boks.get(i).quntity+" ");
            System.out.printf("%15s",boks.get(i).book_price+" ");
            System.out.println();
        }
    }
    private void modify() {
        int attempt=0;
        while(attempt++<3){
            cls();
            System.out.print("Enter book name : ");
            String bookname=sc.nextLine();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=isbook(bookname);
            if(ind!=-1){
                if(boks.get(ind).ISBN==isbn){
                    System.out.println("Enter Quantity of the book : ");
                    boks.get(ind).quntity=sc.nextInt();
                    System.out.println("Enter Price of the book : ");
                    boks.get(ind).book_price=sc.nextInt();
                    System.out.println("Book Updated Succesfully!!..");
                    nextbutton();
                    break;   
                }
            }
            System.out.println("Entered Details are Wrong!!");
            nextbutton();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
        nextbutton();
    }
    private void removebook() {
        int attempt=0;
        while(attempt++<3){
            cls();
            System.out.print("Enter book name : ");
            String bookname=sc.nextLine();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=isbook(bookname);
            if(ind!=-1){
                if(boks.get(ind).ISBN==isbn){
                    boks.remove(ind);
                    System.out.println("Book Removed Succesfully!!..");
                    nextbutton();
                    break;   
                }
            }
            System.out.println("Entered Details are Wrong!!");
            nextbutton();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
    }
    protected int isbook(String a) {
        for(int i=0;i<boks.size();i++){
            if(a.equals(boks.get(i).book_name)){
                return i;
            }
        }
        return -1;
    }
    protected int isbook(int a) {
        for(int i=0;i<boks.size();i++){
            if(a==(boks.get(i).ISBN)){
                return i;
            }
        }
        return -1;
    }
    private void addbook() {
        System.out.print("Enter Book name : ");
        String a=sc.nextLine();
        System.out.print("Enter Book Author name : ");
        String b=sc.nextLine();
        System.out.print("Enter ISBN : ");
        int c=sc.nextInt();
        System.out.print("Enter book Quantity : ");
        int d=sc.nextInt();
        System.out.print("Enter Book Price : ");
        int e=sc.nextInt();sc.nextLine();
        boks.add(new Book(a, b, c, d, e));
        System.out.println("Book Added Successfully!!..");
        nextbutton();
        bookmenu();
    }
    public void booksearch() {
        while(true){
            cls();
            System.out.print("Enter book name : ");
            String bookname=sc.nextLine();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=isbook(bookname);
            if(ind!=-1){
                if(boks.get(ind).ISBN==isbn){
                    displaybook(ind); 
                }
            }
            System.out.println("Entered Book Details are Wrong!!");
            nextbutton();
        }
    }
    private void displaybook(int i) {
        System.out.print("Book Name ");
        System.out.print("    Author Name ");
        System.out.print("       Book ISBN ");
        System.out.print("  Book Quantity");
        System.out.print("  Book Price");
        System.out.println();
        System.out.print(boks.get(i).book_name+" ");
        System.out.printf("%15s",boks.get(i).author+" ");
        System.out.printf("%15s",boks.get(i).ISBN+" ");
        System.out.printf("%15s",boks.get(i).quntity+" ");
        System.out.printf("%15s",boks.get(i).book_price+" ");
        System.out.println();
        nextbutton();
    }
    public void bookRet() {
        Borrower z=new Borrower();
        l:while(true){
            cls();
            System.out.print("Enter Borrowe's EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter Borrowe's Password : ");
            String pass=sc.nextLine();
            int ind=z.isborrower(a);
            if(ind!=-1&&pass.equals(Borrower.bor.get(ind).pass)){
            System.out.print("Enter Book ISBN : ");
            int b=sc.nextInt();sc.nextLine();
            int bookind=isbook(b);
                if(bookind!=-1){
                int borrowind=z.isbookin_borrower(b,ind);
                    if(borrowind!=-1){
                    int bookborrowerind=z.isbookofborrower(bookind,a);
                        if(borrowind!=-1&&bookborrowerind!=-1&&ind!=-1&&bookind!=-1){
                            System.out.print("Enter the no.of.Returning day : ");
                            int returnday=sc.nextInt();sc.nextLine();
                            if(returnday<=15){
                                boks.get(bookind).quntity++;
                                Borrower.bor.get(ind).borrowb.remove(borrowind);
                                System.out.println(Book.boks.get(bookind).book_name+" is Returned by "+Borrower.bor.get(ind).name+" Successfully");
                                boks.get(bookind).borroebook.remove(bookborrowerind);
                                // System.out.println("Book is removed Successfully");
                                nextbutton();
                                break l;
                            }else{
                                returnday-=15;
                                int n=returnday/10+1;
                                int r=returnday%10+1;
                                int res=(((int)Math.pow(2,n)*10)-20)+(r*n*2);
                                if(res>(int)boks.get(bookind).book_price*0.8){
                                    System.out.println("Your Fine Amount is : "+(int)boks.get(bookind).book_price*0.8);
                                    System.out.println("This Amount is debited in your wallet!!..");
                                    Borrower.bor.get(ind).wallet-=(int)boks.get(bookind).book_price*0.8;
                                    Borrower.bor.get(ind).Fine+="Rs."+boks.get(bookind).book_price*0.8+" is Fine for "+boks.get(bookind).book_name+"\n";
                                    boks.get(bookind).quntity++;
                                    Borrower.bor.get(ind).borrowb.remove(borrowind);
                                    System.out.println(Book.boks.get(bookind).book_name+" is Returned by "+Borrower.bor.get(ind).name+" Successfully");
                                    boks.get(bookind).borroebook.remove(bookborrowerind);
                                    nextbutton();
                                    break l;
                                }else{
                                    System.out.println("Your Fine Amount is : "+res);
                                    System.out.println("This Amount is debited in your wallet!!..");
                                    Borrower.bor.get(ind).wallet-=res;
                                    Borrower.bor.get(ind).Fine+="Rs."+res+" is Fine for "+boks.get(bookind).book_name+"\n";
                                    boks.get(bookind).quntity++;
                                    Borrower.bor.get(ind).borrowb.remove(borrowind);
                                    System.out.println(Book.boks.get(bookind).book_name+" is Returned by "+Borrower.bor.get(ind).name+" Successfully");
                                    boks.get(bookind).borroebook.remove(bookborrowerind);
                                    nextbutton();
                                    break l;
                                }
                            }
                        }else{
                            System.out.println("Enter Details are Wrong!!.");
                            nextbutton();
                        }
                    }else{
                        System.out.println("Book is not Borrowed By that Borrower!!..");
                        nextbutton();
                    }
                }else{
                    System.out.println("ISBN no : "+(b)+" is not avalable in Library ");
                    nextbutton();
                }
            }else{
                System.out.println("Enter Correct EmailId or Password!!.");
                nextbutton();
            }
        }
    }
    public void lostbook() {
        Borrower z=new Borrower();
        l:while(true){
            cls();
            System.out.print("Enter Borrower's EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter Borrower's Password : ");
            String pass=sc.nextLine();
            int ind=z.isborrower(a);
            if(ind!=-1&&pass.equals(Borrower.bor.get(ind).pass)){
            System.out.print("Enter Book ISBN : ");
            int b=sc.nextInt();sc.nextLine();
            int bookind=isbook(b);
                if(bookind!=-1){
                int borrowind=z.isbookin_borrower(b,ind);
                    if(borrowind!=-1){
                    int bookborrowerind=z.isbookofborrower(bookind,a);
                        if(borrowind!=-1&&bookborrowerind!=-1&&ind!=-1&&bookind!=-1){
                            System.out.println("Your Fine Amount is : "+(int)boks.get(bookind).book_price*0.5+"for lost"+boks.get(bookind).book_name+" book");
                            System.out.println("This Amount is debited in your wallet!!..");
                            Borrower.bor.get(ind).wallet-=(int)boks.get(bookind).book_price*0.5;
                            Borrower.bor.get(ind).Fine+="Rs."+boks.get(bookind).book_price*0.5+" is Fine for lost "+boks.get(bookind).book_name+" book\n";
                            Borrower.bor.get(ind).borrowb.remove(borrowind);
                            boks.get(bookind).borroebook.remove(bookborrowerind);
                            nextbutton();
                            break l;
                        }else{
                            System.out.println("Enter Details are Wrong!!.");
                            nextbutton();
                        }
                    }else{
                        System.out.println("Book is not Borrowed By that Borrower!!..");
                        nextbutton();
                    }
                }else{
                    System.out.println("ISBN no : "+(b)+" is not avalable in Library ");
                    nextbutton();
                }
            }else{
                System.out.println("Enter Correct EmailId or Password!!.");
                nextbutton();
            }
        }
    }
    public void borrowcount() {
        for (int i=0;i<boks.size();i++){
            int min=i;
            for (int j=i+1;j<boks.size();j++){
                if (boks.get(j).borrowcount>(boks.get(min).borrowcount)){
                    min=j;
                }
            }
            Book temp=boks.get(i);
            boks.set(i,boks.get(min));
            boks.set(min,temp);
        }
        cls();
        System.out.println("Books Sorted in borrow count in highes borrowed count to least borrowed count");
        printbooklist();
        nextbutton();
        Admin z=new Admin();
        z.reportmenu();
    }
}
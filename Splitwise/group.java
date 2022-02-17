import java.util.*;
public class group {
    static Scanner sc=new Scanner(System.in);
    static TreeMap<String,List<user>> x = new TreeMap<>();
    static{
        List<user>ls=new ArrayList<>();
        ls.add(user.use.get(0));
        ls.add(user.use.get(1));
        ls.add(user.use.get(2));
        x.put("1",ls);
    }
    boolean isgroup(String a){
        for(String i : x.keySet()){
            if(i.equals(a))return true;
        }
        return false;
    }
    boolean isgroup_user(String a,String b){
        for(int i=0;i<x.get(a).size();i++){
            if(x.get(a).get(i).EmailID.equals(b))return true;
        }
        return false;
    }
    public void create_group(int ind) {
        user z=new user();
        int cho=0;
        String a;
        int count=0;
        List<user>ls=new ArrayList<>();
        ls.add(user.use.get(ind));
        do{
            if(++count>1)System.out.println("Group name is already exist");
            System.out.print("Enter Group name : ");
            a = sc.nextLine();
        }
        while(isgroup(a));
        System.out.print("Enter no.of user : ");
        int n=sc.nextInt();sc.nextLine();
        for(int i=0;i<n-1;){
            if(cho==-1)System.out.println("Enter valid EmailID");
            System.out.print("Enter user EmailID : ");
            String b=sc.nextLine();
            int index=z.isuser(b);
            boolean fla=true;
            if(b.equals(user.use.get(ind).EmailID)){fla=false;}
            if(index!=-1&&fla&&check(ls,b)){
                ls.add(user.use.get(index));
                cho=0;
                i++;
            }else{
                cho=-1;
                // System.out.println("Entered user EmailID is invalid");
            }
        }
        x.put(a,ls);
        System.out.println("Group created Successfully!!..");
        next();
    }
    private boolean check(List<user> ls, String b) {
        for(int i=0;i<ls.size();i++){
            if(b.equals(ls.get(i).EmailID))return false;
        }
        return true;
    }
    void next() {
        System.out.print("Press ENTER to Continue!!..");
        sc.nextLine();
    }
    public void add_friend(int ind) {
        user u=new user();
        System.out.print("Enter your group name : ");
        String a=sc.nextLine();
        String b=user.use.get(ind).EmailID;
        // System.out.println(x.get(a).size());
        if(isgroup(a)){
            if(isgroup_user(a,b)){
                int count=0;
                String c="";
                do{
                    if(++count>1)System.out.println("user is already in the group");
                    System.out.print("Enter your Friend's EmailID : ");
                    c=sc.nextLine();
                }while(!check(x.get(a), c));
                int index=u.isuser(c);
                if(index!=-1){
                x.get(a).add(user.use.get(index));
                System.out.println("friend add Succssfully!!..");
                // System.out.println(x.get(a).size());
                next();
                }else{
                    System.out.println(c+" is not user!!..");
                    next();
                }
            }else{
                System.out.println("Enter Details are Wrong");
                next();
            }
        }else{
            System.out.println("Enter Details are Wrong");
            next();
        }
    }
    public void remove_friend(int ind) {
        System.out.print("Enter your group name : ");
        String a=sc.nextLine();
        String b=user.use.get(ind).EmailID;
        // System.out.println(x.get(a).size());
        if(isgroup(a)){
            if(isgroup_user(a,b)){
                int count=0;
                String c="";
                do{
                    if(++count>1)System.out.println("Don't Enter your EmailID");
                    System.out.print("Enter your Friend's EmailID : ");
                    c=sc.nextLine();
                }while(c.equals(user.use.get(ind).EmailID));
                int index=find_ind(x.get(a), c);
                if(index!=-1){
                    x.get(a).remove(index);
                    System.out.println("user is removed Successfully!!..");
                    next();
                }else{
                    System.out.println("user is not in your group!!..");
                    next();
                }
            }else{
                System.out.println("Enter Details are Wrong");
                next();
            }
        }else{
            System.out.println("Enter Details are Wrong");
            next();
        }
    }
    private int find_ind(List<user> ls, String b) {
        for(int i=0;i<ls.size();i++){
            if(b.equals(ls.get(i).EmailID))return i;
        }
        return -1;
    }
}

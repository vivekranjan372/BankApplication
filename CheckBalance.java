import java.util.*;
import java.io.*;
public class CheckBalance
{
       public static void check() throws IOException
       {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.nextLine();
        System.out.println("please enter your account number");
        int accountNumber=sc.nextInt();
        Map<String,List<String>>map=Main.getUserList();
        if(map.containsKey(name))
        {
            List<String>list=map.get(name);
            if(list.contains(String.valueOf(accountNumber)))
            {
             System.out.println("your Balance is : "+list.get(2));
                   
            }
            else{
             System.out.println("Account number is not vaild");
            }
        }
        else{
            System.out.println("User not exist");
        }
       }
}
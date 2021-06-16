import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[]args) throws IOException
    {
    
    while(true)
    {   
        int exit=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose option");
        System.out.println(
       "1.<== for create an account"+
        "\n2.<== Add Money "+
        "\n3.<== Withdraw money  "+
        "\n4.<== check Balance "+
        "\n0.<== Exit "
        );
        int option=sc.nextInt();
        sc.nextLine();
        switch(option)
        {
            case 1:
            {   
                System.out.println("Enter your name ");
                  String name=sc.nextLine();
                if(Create.createAccount(name))
                {
                    System.out.println("Account created ...");
                }
                break;
               
            }
            case 2:
            {
                System.out.println(
                  "1.<==Via cash Mode "+
                  "\n2<==Via Online Mode ");
                 option=sc.nextInt();
                switch(option)
                {
                    case 1:
                    {
                        Add.cashMethod();
                        break;
                    }
                    case 2:
                    {
                     Add.onlineMethod();
                        break;
                    }
                }

                break;
            }
            case 3:
            {
              System.out.println(
                  "1.<==Via cash Mode "+
                  "\n2.<==Via Online Mode "+
                  "\n3.<==Via Atm Mode "
                  );
                 option=sc.nextInt();
                switch(option)
                {
                    case 1:
                    {
                        Withdraw.cashMethod();
                        break;
                    }
                    case 2:
                    {
                     Withdraw.onlineMethod();
                        break;
                    }
                    case 3:
                    {
                        Withdraw.atmMethod();
                        break;
                    }
                }
                break;
            }
            case 4:
            {
                CheckBalance.check();
                break;
            }
            case 0:
            {
           exit=1;
              break;
            }
        }
        if(exit==1)
        {
            System.out.
            println("<==Thank For Using Our Bank Application==> \n      Developer:- Vivek Ranjan");
            break;
        } 
    }

        
    }

    public static Map<String,List<String>> getUserList() throws IOException
    {
        Map<String,List<String>>map=new HashMap<>();
          BufferedReader reader=new  
          BufferedReader(new FileReader("./account.csv"));
          int ch;
          int flag=0;
          while((ch=reader.read())!=-1)
          {
    if(flag!=0)
    {
        String []s=reader.readLine().split(",");
        //  System.out.println((char)ch+" "+Arrays.toString(s));
        List<String>list=new ArrayList<>();
        list.add(String.valueOf((char)ch));
        list.add(s[1]);
        list.add(s[2]);
        map.put(s[1],list);

    }
    else{
        reader.readLine();
    }
    flag=1;
          }
          return map;
    }
    
}
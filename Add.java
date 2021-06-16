import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
public class Add
{
      public static void cashMethod() throws IOException
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
                  System.out.println("Enter the Amount: ");
                  int amount=sc.nextInt();
                     addMoney(list,amount,"Cr","Cash");
              }
              else{
               System.out.println("Account number is not vaild");
              }
          }
          else{
              System.out.println("User not exist");
          }
    
          }

          private static void 
          addMoney(List<String>list,int amount,String type,String mode) throws IOException
          {
                 File file=new File("./account.csv");
                 FileReader fileReader=new FileReader(file);
                 BufferedReader reader=new BufferedReader(fileReader);
                 String s=null;
                 List<String>modifyLines=new ArrayList<>();
                int totalMoney=0;
                 while((s=reader.readLine())!=null)
                 {
                     String arr[]=s.split(",");
                     if(list.get(0).equals(arr[0]))
                     {
                         arr[2]=String.
                         valueOf(Integer.parseInt(list.get(2))
                         +(amount));
                         s="";
                         totalMoney=Integer.parseInt(arr[2]);
                        for(int i=0;i<arr.length;i++)
                        {
                           s+=i!=arr.length-1?arr[i]+",":arr[i];
                        }
                     }
                     modifyLines.add(s);
                     
                 }
                 fileReader.close();
                 reader.close();
               FileWriter fileWriter=new FileWriter(file);
               BufferedWriter writer=new BufferedWriter(fileWriter);
               PrintWriter print=new PrintWriter(writer);
               for(String ss:modifyLines)
               {
                   print.println(ss);
               }
               print.flush();
               print.close();   
              fileWriter=
               new FileWriter(new File("./account_statement.csv"),true);
               writer=new BufferedWriter(fileWriter);
            print=new PrintWriter(writer);
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
               LocalDateTime now = LocalDateTime.now();
               print.println
               (String.valueOf(dtf.format(now))+","+type+","+list.get(0)+","+(amount)+","+(totalMoney)+","+mode); 
               print.flush();
               print.close();
               System.out.println("Money Added Successfully "); 
            }
            public static void onlineMethod() throws IOException
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
                        System.out.println("Enter the Amount: ");
                        int amount=sc.nextInt();
                           addMoney(list,amount,"Cr","online");
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
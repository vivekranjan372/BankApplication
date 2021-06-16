import java.io.*;
public class Create{
    
    public static boolean createAccount(String name) throws IOException
    {
        int lastAccountNumber=lengthFile("./account.csv");
            BufferedWriter write=new BufferedWriter(new FileWriter("./account.csv",true));
            PrintWriter pw=new PrintWriter(write);
            pw.println((lastAccountNumber+1)+","+name+","+"0");
            pw.flush();
            pw.close();
            return true;
        

    }

    public static int lengthFile(String path) throws IOException
    {
           BufferedReader reader=new BufferedReader(new FileReader(path));
           int flag=0;
          int ch;
          int count=0;
          char c='a';
           while((ch=reader.read())!=-1)
           {     

             if(flag==0)
             {
                reader.readLine();
                
             }
             else
             {
                
                String s[]=reader.readLine().split(",");
                 c=(char)ch;
             
             
             }
            flag=1;
           }
          
           return Integer.parseInt(c+"");
    }
}
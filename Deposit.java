package deposit; // change class name to Deposit
import java.lang.Math.*;
import java.io.*;
import java.util.*;
public class Deposit
{
    public void depositMoney(String id,String password,String balance,int damt) //
    {
        try
        {
            Scanner scan=new Scanner(System.in);
            Scanner s=new Scanner(new File("abcdef.txt"));
            
            String s6="";
            while(s.hasNext())
            {
                String tempid=s.next();
                String temppass=s.next();
                String tempbal=s.next();
                if(id.equals(tempid) && password.equals(temppass))
                {
                    int vv=Integer.parseInt(tempbal);
                    vv+=damt;
                    tempbal=vv+" ";
                }
                s6=s6+tempid+" "+temppass+" "+tempbal+"\n";
            }
            FileWriter writer = new FileWriter("abcdef.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(s6);
            bufferedWriter.close();
            System.out.println("-----------------------------------------------------------------");
            System.out.println(damt+" Rs. Successfully Deposited ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Press any key to go to main menu");
            // String vs=scan.next();
            System.in.read();
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
    }
}

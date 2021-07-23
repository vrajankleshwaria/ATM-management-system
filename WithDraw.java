package withdraw;
import java.lang.Math.*;
import java.io.*;
import java.util.*;
public class WithDraw
{
    public boolean withDrawMoney(String id,String password,String balance,int wamt)
    {
        try
        {
            Scanner scan=new Scanner(System.in);
            Scanner s7=new Scanner(new File("abcdef.txt"));

            String s6="";
            while(s7.hasNext())
            {
                String tempid=s7.next();
                String temppass=s7.next();
                String tempbal=s7.next();
                if(id.equals(tempid) && password.equals(temppass))
                {
                    int balint=Integer.parseInt(tempbal);
                    if(balint<wamt)
                    {
                        System.out.println("Insufficient Balance");
                        System.out.println("Press any key to go to main menu");
                        String vs=scan.next();
                        return false;
                    }
                    balint-=wamt;
                    tempbal=balint+" ";
                }
                s6=s6+tempid+" "+temppass+" "+tempbal+"\n"; // s6=s6 + ???
            }
            FileWriter writer = new FileWriter("abcdef.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(s6);
            bufferedWriter.close();
            System.out.println("-----------------------------------------------------------------");
            System.out.println(wamt+" Rs. Successfully Withdrawan ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Press any key to go to main menu");
            // String vs=scan.next();
            System.in.read();
            return true;
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
        return false;
    }
}

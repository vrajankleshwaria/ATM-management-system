package changepass;
import java.lang.Math.*;
import java.io.*;
import java.util.*;
public class PasswordChange
{
    public void passChange(String n , String k)
    {
        try
        {
            String s3="",s4="",s5="";
            Scanner scan = new Scanner(System.in);
            Scanner s7 = new Scanner(new File("abcdef.txt"));
            String s6 = "";
            while(s7.hasNext())
            {
                s3=s7.next();
                s4=s7.next();
                s5=s7.next();
                if(n.equals(s4) && k.equals(s3))
                {
                    String ss = "";
                    System.out.println("Enter new Password : ");
                    ss = scan.next();
                    s6 = s6+s3+" "+ss+" "+s5+"\n";
                }
                else
                {
                    s6 = s6+s3+" "+s4+" "+s5+"\n";
                }
                FileWriter writer = new FileWriter("abcdef.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(s6);
                bufferedWriter.close();
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Password changed successfully");
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Enter any key for go to main menu");
            //String vs=scan.next();
            System.in.read();
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
}

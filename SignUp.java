package signup;
import java.lang.Math.*;
import java.io.*;
import java.util.*;
public class SignUp //
{
    boolean flag = true;
    public void signUp() // 
    {
        try
        {
            int otp;
            boolean flag = true;
            while(true)
            {
                otp=(int)(Math.random()*1000000);
                Scanner s7=new Scanner(new File("abcdef.txt"));
                int already=1;
                while(s7.hasNext())
                {
                    String tempid=s7.next();
                    String temppass=s7.next();
                    String tempbal=s7.next();
                    int idint=Integer.parseInt(tempid);
                    if(idint==otp)
                    {
                        already=2;
                        break;
                    }
                }
                if(already==2) continue;
                else break;
            }
            Scanner scan=new Scanner(System.in);
            System.out.println();
            System.out.println("Your ID is : "+otp);
            String password="";
            while(flag)
            {
                while(true)
                {
                    System.out.print("Choose a PassWord : ");
                    String p;
                    password=p=scan.nextLine();
                    Scanner s7=new Scanner(new File("abcdef.txt"));
                    int already=1;
                    while(s7.hasNext())
                    {
                        String tempid=s7.next();
                        String temppass=s7.next();
                        String tempbal=s7.next();
                        //System.out.println("temp password "+temppass);
                        if(temppass.equals(password))
                        {
                            already=2;
                            System.out.println("Taken Password , Please try another one...");
                            System.out.println();
                            break;
                        }
                    }
                    if(already==2) continue;
                    else break;
                }
                boolean check = password.contains(" ");
                if(check)
                {
                    System.out.println("Password can't contain Blank space , Please try another one...");
                    System.out.println();
                }
                else
                {
                    flag=false;
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                        Successfull SignUp                        ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println();
            System.out.println("Press 1.Money Deposit");
            System.out.println("Else enter any other key to exit");
            String choice="";
            choice=scan.next();
            int nakamo=0;
            if(choice.equals("1"))
            {
                int damt;
                System.out.print("Enter the amount to Deposite : ");
                while(true)
                {
                    try
                    {
                        Scanner scan1=new Scanner(System.in);
                        nakamo=damt=scan1.nextInt();
                        break;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Amount must be in integer only...Please try again");
                        continue;
                    }
                }
                System.out.println();
                password=otp+" "+password+" "+damt;
            }
            else
            {
                password=otp+" "+password+" "+"0";
            }

            FileWriter writer = new FileWriter("abcdef.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.newLine();
            bufferedWriter.write(password);
            bufferedWriter.close();
            System.out.println("Current balance = "+ nakamo); //
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

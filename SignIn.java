package signin;
import changepass.PasswordChange;
import balance.Balance;
import withdraw.WithDraw;
import deposit.Deposit;
import java.lang.Math.*;
import java.io.*;
import java.util.*;
public class SignIn extends PasswordChange
{
    public void signIn() //
    {
        String tempid="",temppass="",tempbal="",id="",password="";
        Scanner scan=new Scanner(System.in); // 
        try
        {
            Scanner s; //
            outer: while(true)
            {
                s=new Scanner(new File("abcdef.txt"));
                System.out.print("Enter ID : ");
                id=scan.next();
                System.out.print("Enter Password : ");
                password=scan.next();
                System.out.println();
                
                inner: while(s.hasNext())
                {
                    tempid=s.next();
                    temppass=s.next();
                    tempbal=s.next();
                    if(id.equals(tempid) && password.equals(temppass))
                    {
                        break outer;
                    }
                }
                System.out.print("Please Enter a valid ID and Password");
                // continue outer;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                return;
            }
            int choice=1;
            try
            {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                        Successfull LogIn                        ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Please select a transaction ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1.Balance Inquiry");
            System.out.println("2.Deposit");
            System.out.println("3.Cash Withdrawal");
            System.out.println("4.Change Password");
            
            choice=scan.nextInt();
            switch(choice)
            {
                case 1:
                    {
                        Balance balobj=new Balance(); //
                        System.out.println("Current balance = "+balobj.checkBalance(tempbal)); 
                        s.close();
                        System.out.println("Press any key to go to main menu");
                        //String vs=scan.next(); // ???????
                        System.in.read();
                        break;
                    }
                case 2:
                    {
                        Deposit depobj=new Deposit(); //
                        int damt;
                        Scanner scan1=new Scanner(System.in);//
                        String flush="";
                        
                        while(true)
                        {
                            try
                            {
                                System.out.print("Enter the Amount to deposit = ");
                                damt=scan1.nextInt();
                                if(damt<0){
                                    System.out.println("Value must be greater than 0");
                                    continue;
                                }
                                //System.out.println(k);
                                break;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Amount must be in integer only...Please try again");
                                flush=scan1.nextLine();
                                continue;
                            }
                        }
                        depobj.depositMoney(id,password,tempbal,damt); //
                        tempbal=Integer.parseInt(tempbal)+damt+"";
                        Balance balobj=new Balance(); //
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println(damt + "Rs. Deposited successfully ");
                        System.out.println("Current balance = "+balobj.checkBalance(tempbal));
                        System.out.println("-----------------------------------------------------------------");
                        s.close();
                        break;
                    }
                case 3:
                    {
                        WithDraw obj4=new WithDraw(); // 
                        int wamt;
                        String flush="";
                        Scanner scan1=new Scanner(System.in);
                        while(true)
                        {
                            
                            try
                            {
                                System.out.print("Enter the amount to withdraw = ");
                                wamt=scan1.nextInt();
                                //System.out.println(k);
                                if(wamt<0){
                                    System.out.println("Value must be greater than 0");
                                    continue;
                                }
                                break;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Amount must be in integer only...Please try again");
                                flush=scan1.nextLine();
                                continue;
                            }
                        }
                        boolean grant=obj4.withDrawMoney(id,password,tempbal,wamt);
                        if(grant)
                        {
                            tempbal=Integer.parseInt(tempbal)-wamt+"";
                            Balance balobj=new Balance(); //
                            System.out.println("-----------------------------------------------------------------");
                            System.out.println(wamt + "Rs. Withdrawan successfully ");
                            System.out.println("Current balance = "+balobj.checkBalance(tempbal));
                            System.out.println("-----------------------------------------------------------------");
                        }
                        s.close();
                        break;
                    }
                    case 4:
                        {
                            PasswordChange p1 = new PasswordChange();
                            p1.passChange(password,id);
                            break;
                        }
                    default: 

                    {
                        System.out.println("No such option available...");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e1) {
                            //kai nai
                        }
                        break;
                        }
                    }

        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }
}

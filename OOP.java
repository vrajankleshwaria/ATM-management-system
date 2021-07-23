import signup.SignUp;
import signin.SignIn;
import balance.Balance;
import deposit.Deposit;
import withdraw.WithDraw;
import changepass.PasswordChange;
import java.lang.Math.*;
import java.io.*;
import java.util.*;

public class OOP
{
    public static void main(String[] args)
    {
        int choice=1;
        while(choice!=0)
        {
            try
            {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

            Scanner scan=new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("               Hey there , Welcome to VK's Bank");   
            System.out.println("-----------------------------------------------------------------");
            System.out.println();
            System.out.println("0.Close ATM Machine");
            System.out.println("1.Sign_In");
            System.out.println("2.Sign_Up"); 
            try 
            {
                choice=scan.nextInt();
            } 
            catch (Exception e) {
                System.out.println("Invalid Input");
                try {
                    Thread.sleep(1000);
                } catch (Exception e1) {
                    //kai nai
                }
                continue;
            }
            switch(choice)
            {
                case 0:
                {
                    choice=0;
                    break;
                }
                case 1:
                {
                    SignIn obj1=new SignIn();
                    obj1.signIn();
                    break;
                }
                case 2:
                {
                    SignUp obj5=new SignUp();
                    obj5.signUp();
                    break;
                }
                default: {
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
    }
}

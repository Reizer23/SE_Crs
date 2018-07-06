package java_Basic;

import java.sql.SQLException;

//9-49
public class ExceptionsDemo
{

    public static void main(String[] args)
    {

        Account acc = new Account();
        try {
                System.out.println("1st line");
                //acc.withdraw(100);
                System.out.println("After trying the withdraw method");
            } catch (Exception e)//(SQLException e)
            {
                //e.printStackTrace();
                //System.out.println(e.getMessage());
                System.out.println("Try again at some other point");
            }
            finally
            {
                System.out.println("Allways execute");
            }

    }
}

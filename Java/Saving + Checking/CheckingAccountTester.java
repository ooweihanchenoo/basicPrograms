/**
 *
 * Created by WEI on 3/30/2016.
 */
public class CheckingAccountTester {
    public static void main(String[]args){
        CheckingAccount c = new CheckingAccount(30);
        SavingsAccount s = new SavingsAccount(100);
        c.linkAccount(s);
        
        c.deposit(10);
        c.withdraw(60);
        System.out.println(c);
        System.out.println(s);

        CheckingAccount c1 = new CheckingAccount(70);
        c1.deposit(10);
        System.out.println(c1);
    }
}

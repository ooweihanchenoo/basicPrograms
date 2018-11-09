/**
 * Created by WEI on 3/30/2016.
 */
public class SavingsAccountTester {
    public static void main(String[] args){
        SavingsAccount s = new SavingsAccount();
        s.deposit(10);
        s.withdraw(5);
        System.out.println(s);
    }
}

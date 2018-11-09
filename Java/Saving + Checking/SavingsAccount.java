/**
 * Created by WEI on 3/29/2016.
 */
public class SavingsAccount {
    private double balance;

    public SavingsAccount(){
        this.balance = 50.0;
    }
    public SavingsAccount(SavingsAccount s){
        balance = s.balance;
    }
    public SavingsAccount (double balance) {
        this.balance = balance;
    }
    public double deposit (double deposit){
        balance += deposit;
        return balance;
    }
    public double withdraw (double withdraw){
        balance -= withdraw;
        return balance;
    }
    public double getBalance(){
        return balance;
    }
    public SavingsAccount copy(){
        return new SavingsAccount(balance);
    }
    public String toString(){
        return "Total in saving account: "+balance;
    }
}

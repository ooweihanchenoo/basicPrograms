/**
 * Created by WEI on 3/30/2016.
 */
public class CheckingAccount {
  private double balance;
  private SavingsAccount linkedSavings;
  
  public CheckingAccount(){
    this.balance = 50.0;
  }
  public CheckingAccount(double deposit){
    balance = deposit;
  }
  public CheckingAccount(CheckingAccount c){
    balance = c.balance;
  }
  public CheckingAccount(double deposit, SavingsAccount linkedSavings){
    balance = deposit;
    this.linkedSavings = linkedSavings;
  }
  public void linkAccount (SavingsAccount linkedSavings){
    this.linkedSavings = linkedSavings;
  }
  public void unlinkAccount (){
    this.linkedSavings = null;
  }
  public SavingsAccount getLinkedSavings(){
    return linkedSavings.copy();
  }
  public double deposit (double deposit){
    balance += deposit;
    return balance;
  }
  public double withdraw (double withdraw){
    balance -= withdraw;
    if (balance < 0){
      balance = (balance*-1);
      if (linkedSavings.getBalance() >= balance){
        linkedSavings.withdraw(balance);
        balance = 0;
      } else {
        balance = balance * -1 + withdraw;
      }
    }
    return balance;
  }
  public double getBalance(){
    return balance;
  }
  public double setBalance(){
    return balance;
  }
  public CheckingAccount copy() {
    return new CheckingAccount(balance);
  }
  public String toString(){
    return "Total in checking account: "+balance;
  }
}

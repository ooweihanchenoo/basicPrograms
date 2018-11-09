import java.util.*;
public class GroceryBills
{
  public static void main (String[]args)
  {
    int time=0; // Declare valuable
    double totalspents =0.0; // Declare valuable
    double averagespents =0.0; // Declare valuable
    double highestspent =0.0; // Declare valuable
    double max = 0; // Declare valuable
    double maxweek= 0; // Declare valuable
    double min; // Declare valuable
    int option; // Declare valuable
    
    Scanner keyboard = new Scanner(System.in); //Create A Scanner
    
    System.out.println("Enter the number of weeks"); //Ask for input(weeks)
    time=keyboard.nextInt(); // time = the input(weeks)
    while(time<0){ //While Loop in case negative numbers is the input
      System.out.println("No negative numbers, try again");
      time=keyboard.nextInt();
    }
    
    double[][] bills = new double [time+1][1]; //Double Array, column depenends on the inputs(weeks). +1 because time start at 0
    
    for (int weeks = 1; weeks < bills.length; weeks++){ //for loop
      for (int spents = 0; spents < bills[weeks].length; spents++){ //for loop in for loop
        System.out.println("Please enter the amount spent on groceries for week "+weeks+ " : "); 
        bills[weeks][spents] = keyboard.nextDouble();
        while(bills[weeks][spents]<0){
          System.out.println("No negative numbers, try again");
          bills[weeks][spents] = keyboard.nextDouble(); //Input(Double Loop)
        }
      }
    }
    //for loop to find max
    for (int weeks = 1; weeks < bills.length; weeks++){
      for (int spents = 0; spents < bills[weeks].length; spents++){
        totalspents += bills[weeks][spents];
        averagespents =bills[weeks][spents]/ bills[weeks].length;
        if (max < bills[weeks][spents]){
          max = bills[weeks][spents];
          
        }  
      }     
    }
    
    min = max;
    //for loop to find min
    for (int weeks = 1; weeks < bills.length; weeks++){
      for (int spents = 0; spents < bills[weeks].length; spents++){
        
        if(bills[weeks][spents] < min){
          min = bills[weeks][spents];
        }
      }
    }
    
    //menu
    System.out.println("Please choose an option:" 
                         +"\n 1. List the amount spent each week"
                         +"\n 2. Total spent"
                         +"\n 3. Average spent"
                         +"\n 4. Highest spent in a week"
                         +"\n 5. Week number with the highest amount spent"
                         +"\n 6. Lowest spent in a week"
                         +"\n 7. Exit");
    System.out.println();
    option = keyboard.nextInt(); //input to choose options
    //switch staement to lead the user to their choices depends on the numbr they choose
    switch (option){
      case 1:
        System.out.println("List of amount spent per week: ");
        for (int weeks = 1; weeks < bills.length; weeks++){
          for (int spents = 0; spents < bills[weeks].length; spents++){
            System.out.println("Week " + weeks + " : $" +bills[weeks][spents] );
          }
        }
        break;
      case 2:
        System.out.println("Total Spent = $" + totalspents);
        break; 
      case 3:
        System.out.println("Average spent per week= $"+averagespents);
        break; 
      case 4:
        System.out.println("Most Spent In One week was = $" + max);
        break; 
      case 5:
        System.out.println("Week with the highest spent is week " + maxweek);
        break;
      case 6:
        System.out.println("Least Spent In One week was = $" + min);   
        break;
      case 7:
        break; 
    }
  }
}


// This is a program that allows user's monthly grocery shopping
import java.util.Scanner;
public class MonthlyGroceryBills {
  public static void main (String[] args) {
    Scanner input = new Scanner (System.in);
    
    int months = 0;
    int weeks  = 0;
    int options    = 0;
    
    // input months
    System.out.print("Enter the amount of months for your grocery bills.");
    months = input.nextInt ();
    if (months < 0){
      do {
        System.out.print("Not A Positive Number!!!!!");
        months = input.nextInt ();
      } while (months < 0);
    }
    
    double[][] array = new double[months][4];
     
    // input bills for each month ( 4 weeks in a month )
    for (int i = 0; i < months; i++){
      for (int j = 0; j < 4; j++){
        System.out.print ("Enter the grocery bill for week " + (j + 1) + " in month " + (i + 1) + " : ");
        array[i][j] = input.nextInt();
      }
    }
    System.out.println();
    
    // Options menu (choices)
    do {
      System.out.println ("Please choose an option:");
      System.out.println ("------------------------------------------------------------");
      System.out.println ("1. List the amount spent each week month by month as a table");
      System.out.println ("2. Grand total spent over all months");
      System.out.println ("3. Total spent each month");
      System.out.println ("4. Average spent each month");
      System.out.println ("5. Average spent each week");
      System.out.println ("6. Highest spent in a month");
      System.out.println ("7. Highest spent in a week");
      System.out.println ("8. Month number with the highest amount spent");
      System.out.println ("9. Lowest spent in a month");
      System.out.println ("10. Lowest spent in a week");
      System.out.println ("11. Exit");
      options = input.nextInt ();
      System.out.println ();
      
      switch (options) {
        case 1: monthly (array, months);
                break;
        case 2: grandtotal (array, months);
                break;
        case 3: totalmonth (array, months);
                break;
        case 4: avgmonth (array, months);
                break;
        case 5: avgweek (array, months);
                break;
        case 6: maxmonth (array, months);
                break;
        case 7: maxweek (array, months);
                break;
        case 8: maxmonthspent (array, months);
                break;
        case 9: lowmonth (array, months);
                break;
        case 10: lowweek (array, months);
                 break;
        case 11: ;
                 break;
        default: System.out.print ("Invalid options");
                 break;
      }
    } while (options != 11);
  }
  
  public static void monthly (double[][] array, int months) {
    System.out.println ("Spent each week, month by month: ");
    System.out.println ();
    
    for (int i = 0; i < months; i++){
      System.out.print ("Month " + (i + 1) + " : ");
      for (int j = 0; j < 4; j++){
        System.out.print (array[i][j] + " ");
      }
      System.out.println ();
    }
    System.out.println ();
    System.out.println ();
  }
  
  public static void grandtotal (double[][] array, int months) {
    int total = 0;
    
    for (int i = 0; i < months; i++){
      for (int j = 0; j < 4; j++){
        total += array[i][j];
      }
    }
    
    System.out.println ("Grand total spent over all months: " + total);
    System.out.println ();
    System.out.println ();
  }
  
  public static void totalmonth (double[][] array, int months) {
    int total = 0;
    
    System.out.println ("Total spent per month: ");
    System.out.println ();
    
    for (int i = 0; i < months; i++){
      for (int j = 0; j < 4; j++){
        total += array[i][j];
      }
      System.out.print("Month " + (i + 1) + " : " + total);
      System.out.println();
      total = 0;
    }
    
    System.out.println ();
    System.out.println ();
  }
  
  public static void avgmonth (double[][] array, int months) {
    double total = 0.0;
    
    System.out.println ("Average spent per month: ");
    System.out.println ();
    
    for (int i = 0; i < months; i++){
      for (int j = 0; j < 4; j++){
        total += array[i][j];
      }
      System.out.print("Month " + (i + 1) + " : " + (total / 4.0));
      System.out.println();
      total = 0.0;
    }
    
    System.out.println ();
    System.out.println ();
  }
  
  public static void avgweek (double[][] array, int months) {
    double total = 0.0;
    
    for (int i = 0; i < months; i++){
      for (int j = 0; j < 4; j++){
        total += array[i][j];
      }
    }
    
    System.out.println ("Average spent per week: " + (total / (4.0 * months)));
    System.out.println ();
    System.out.println ();
  }
  
  public static void maxmonth (double[][] array, int months) {
    double highest  = array[0][0];
    int    total    = 0;
    
    for (int i = 0; i < months; i++) {
      for (int j = 0; j < 4; j++) {
        total += array[i][j];
        }
      if (highest < total){
          highest = total;
      }
      total = 0;
    }
    
    System.out.println ("Highest spent in a month: " + highest);
    System.out.println ();
    System.out.println ();
  }
  
  public static void maxweek (double[][] array, int months) {
    double highest  = array[0][0];
    int    monthNum = 1;
    
    for (int i = 0; i < months; i++) {
      for (int j = 0; j < 4; j++) {
        if (highest < array[i][j]){
          highest = array[i][j];
        }
      }
    }
    
    System.out.println ("Highest spent in a week: " + highest);
    System.out.println ();
    System.out.println ();
  }
  
  public static void maxmonthspent (double[][] array, int months) {
    double highest  = array[0][0];
    int    monthNum = 1;
    int    total    = 0;
    
    for (int i = 0; i < months; i++) {
      for (int j = 0; j < 4; j++) {
        total += array[i][j];
        }
      if (highest < total){
          highest = total;
          monthNum = (i + 1);
      }
      total = 0;
    }
    
    System.out.println ("Month number with the highest amount spent: " + monthNum);
    System.out.println ();
    System.out.println ();
  }
  
  public static void lowmonth (double[][] array, int months) {
    double lowest   = array[0][0];
    int    total    = 0;
    
    for (int i = (months - 1); i > 0; i--) {
      for (int j = 3; j >= 0; j--) {
        total += array[i][j];
        }
      if (lowest > total){
          lowest = total;
      }
      total = 0;
    }
    
    System.out.println ("Lowest spent in a month: " + lowest);
    System.out.println ();
    System.out.println ();
  }
  
  public static void lowweek (double[][] array, int months) {
    double lowest  = array[0][0];
    
    for (int i = (months - 1); i > 0; i--) {
      for (int j = 3; j >= 0; j--) {
        if (lowest > array[i][j]){
            lowest = array[i][j];
        }
      }
    }
    
    System.out.println ("Lowest spent in a week: " + lowest);
    System.out.println ();
    System.out.println ();
  }
}
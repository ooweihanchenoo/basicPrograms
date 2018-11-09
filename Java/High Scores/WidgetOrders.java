public class WidgetOrders{
  private int[] widget;
  private int highest;
  private int average;
  private int total;
  
  
  public WidgetOrders(int[] widget){
    this.orders = orders;
  }
  
  
  public int highest(){
    int highest = widgets[0];
    for (int i =1; i<widget.length;i++){
      if (order[i]>highest){
        highest=orders[i];
      }
    }
  

  public WidgetOrders(int Highest, int Average, int Total){
    highest = Highest;
    average = Average;
    total = Total;
  }
  
  public int getHighest(){
    return this.highest;
  }
  
  public int getAverage(){
    return this.average;
  }
  
  public int getTotal(){
    return this.total;
  }
 
  public String toString()
   {
      String str = "\nHighest: " + highest +
                   "\nAverage: " + average + 
                   "\nTotal: " + total;
      return str;
   }
}
/* This is a tester test the constructor of the calculate a ball's 
 * circumgerence, diameter, radius, surface area and volume
 */
public class BallTester{
  public static void main (String[] args){
    Ball ball = new Ball();
    
    // ball.setColor("yellow"); 
    // remove the comment lines in the code above to change the color
    
    // ball.setDiameter(20);
    // remove the comment lines in the code above to change the diameter 
    
    System.out.println(ball);
    System.out.println("Radius: "+ball.getRadius()+"\nCircumference: "+ball.getCircumference()
                      +"\nSurface Area: "+ball.getSurfaceArea()+"\nVolume: "+ball.getVolume());  
  }  
}
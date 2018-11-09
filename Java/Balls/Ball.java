/* This is a program design to calculate a ball's 
 * circumgerence, diameter, radius, surface area and volume
 */
public class Ball{
  private String color; //set color to private String
  private int diameter; //set diameter to private integer
  private int radius; //set radius to private inteter 
  private double circumference; //set circumference to private double
  private double surfacearea; //set surface area to private double
  private double volume; //set volume to private double
  private final double pi = Math.PI; //set pi to final double using the valuable java provide(pi)
  
  //Constructor with default color of red and diameter of 10
  public Ball(){
    this.color = "red";
    this.diameter = 10;
  }
  
  /*Accessor for color
   * @param color
   * the color to set
   */
  public void setColor(String cl){
    this.color = cl;
  }
  /*Accessor for diameter
   * @param diameter
   * the diameter to set
   */
  public void setDiameter(int d){
    this.diameter = d;
  }
  
  /*Mutator for color
   * @return color
   */
  public String getColor(){
    return color;
  }
  /*Mutator for diameter
   * @return diameter
   */
  public int getDiameter(){
    return diameter;
  }  
  /*Mutator for radius
   * @return radius
   */
  public int getRadius(){
    radius = diameter/2; //Formula for radius is half of diameter
    return radius;
  }  
  /*Mutator for circumference
   * @return circumference
   */
  public double getCircumference(){
    circumference = 2*pi*radius; //Formula for circumference is (2)(pi)(radius)
    return circumference;
  }  
  /*Mutator for surfacearea
   * @return surfacearea
   */
  public double getSurfaceArea(){
    surfacearea = 4*pi*radius*radius; //Formula for surface area is (4)(pi)(radius^2)
    return surfacearea;
  }
  /*Mutator for volume
   * @return volume
   */
  public double getVolume(){
    volume = (4*pi*radius*radius*radius)/3; //Formula for volume is ((4)(pi)(radius^3))/3
    return volume;
  }
  
  //A toString method to print out default color and diameter
  public String toString()
  {
    String str = "Color: " + color +
      "\nDiameter: " + diameter;
    return str;
  }
}
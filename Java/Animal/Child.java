package Animal;

/**
 * Created by Wei Han Chen on 4/13/2016.
 */
public class Child extends Animal{
  private Dogs dog = new Dogs();
  String name;
  
  public String getName(){
    return name;
  }
  
  public Dogs getDog(Dogs dog){
    this.dog = dog;
    return new Dogs();
  }
  
  public String toString(){
      return "Child's name is"+name+"Child"+dog;
    
  }
  
}
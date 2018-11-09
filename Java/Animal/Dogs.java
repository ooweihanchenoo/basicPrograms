package Animal;

/**
 * Created by Wei Han Chen on 4/13/2016.
 */
public class Dogs extends Animal{
  private Boolean hasBone;
  private String names;
  public void animal(){
  }
  
    public String getnames(){
      return names;
    }
    
    public Boolean pickUpBone(){
      hasBone = true;
      System.out.print("pick up the bone.");
      return hasBone;
    }
    public Boolean dropBone(){
      hasBone = false;
      System.out.print("drop the bone.");
      return hasBone;
    }
    
    public String toString(){
      return "Dog's name is"+names+"Dogs"+hasBone;
    
  }
}

package HW5Inheritance;

public class Person {
  protected String name;
  protected int age;

  public Person(String name, int age) {
   this.name = name;
   this.age = age;
  }
  
  public Person(String name) {
   this.name = name;
  }
  
  public Person() {
   name = " ";
   age = -1;
  }
  
  public String toString() {
   return "Name: " + name + " | Age: " + age;
  }
  
  public void setName(String name) { this.name = name; }
  public void setAge(int age) { this.age = age; }
  public String getName() { return name; }
  public int getAge() { return age; }
}

package HW5Inheritance;

public class Tester {

 public static void main(String[] args) {
  // test Person class
  System.out.println("Test Person Class");
  System.out.println("-------------------");
  
  Person p = new Person("Jon Snow", 20);
  System.out.println(p);
  System.out.println("");
  System.out.println("Test name and age methods:");
  p.setName("Tyrion Lannister");
  p.setAge(38);
  System.out.println(p);
  System.out.println("Name: " + p.getName());
  System.out.println("Age: " + p.getAge());
  
  // test Student class
  System.out.println("");
  System.out.println("Test Student Class");
  System.out.println("--------------------");
  
  Student s = new Student("Cersei Lannister", 25, 5969);
  System.out.println(s);
  System.out.println("");
  System.out.println("Test name, age, and id methods:");
  s.setName("Daenerys Targaryen");
  s.setAge(23);
  s.setId(703857);
  System.out.println(s);
  System.out.println("Name: " + s.getName());
  System.out.println("Age: " + s.getAge());
  System.out.println("Id: " + s.getId());
  
  // test GradStudent class
  System.out.println("");
  System.out.println("Test GradStudent Class");
  System.out.println("--------------------");
  
  GradStudent g = new GradStudent("Sansa Stark", 18, 684039, new Person("Arya", 16));
  System.out.println(g);
  System.out.println("");
  System.out.println("Test name, age,id, and advisor methods:");
  g.setName("Jorah Mormont");
  g.setAge(40);
  g.setId(6546721);
  g.setAdvisor(new Person("Jaime Lannister", 28));
  System.out.println(g);
  System.out.println("Name: " + g.getName());
  System.out.println("Age: " + g.getAge());
  System.out.println("Id: " + g.getId());
  System.out.println("Advisor: " + g.getAdvisor());
 }

}

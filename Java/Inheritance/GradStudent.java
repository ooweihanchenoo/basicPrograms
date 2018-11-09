package HW5Inheritance;

public class GradStudent extends Student {
 protected Person advisor;
 
 public GradStudent(String name, int age, int id, Person advisor) {
  this.name = name;
  this.age = age;
  this.id = id;
  this.advisor = advisor;
 }
 
 public GradStudent(String name, int age, int id) {
  this.name = name;
  this.age = age;
  this.id = id;
 }
 
 public GradStudent(String name, int age) {
  this.name = name;
  this.age = age;
 }
 
 public GradStudent(String name) {
  this.name = name;
 }
 
 public GradStudent() {
  name = " ";
  age = -1;
  id = -1;
  advisor = new Person();
 }
 
 public String toString() {
  return "Name: " + name + " | Age: " + age + " | Id: " + id + " | Advisor Details ~ " + advisor;
 }
 
 public void setAdvisor(Person advisor) { this.advisor = advisor; }
 public Person getAdvisor() { return advisor; }
   
}

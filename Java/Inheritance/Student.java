package HW5Inheritance;

public class Student extends Person {
 protected int id;
 
 public Student(String name, int age, int id) {
  this.name = name;
  this.age = age;
  this.id = id;
 }
 
 public Student(String name, int age) {
  this.name = name;
  this.age = age;
 }
 
 public Student(String name) {
  this.name = name;
 }
 
 public Student() {
  name = " ";
  age = -1;
  id = -1;
 }
 
 public String toString() {
  return "Name: " + name + " | Age: " + age + " | Id: " + id;
 }
 
 public void setId(int id) { this.id = id; }
 public int getId() { return id; }
}

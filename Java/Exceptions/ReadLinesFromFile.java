import java.io.*;
import java.util.*;

public class ReadLinesFromFile {
  public static void main(String[] args){
    
    System.out.println("What is the name of the text file?((DO NOT INCLUDE .TXT))");
    Scanner scanner = new Scanner(System.in);
    String filename = scanner.nextLine();
    scanner.close(); 
    
    BufferedReader reader = null;
    String strLine=null;
    
    try {
      reader = new BufferedReader(new FileReader(filename+".txt"));
      
      while( (strLine=reader.readLine()) !=null){
        System.out.println(strLine);
      }
      } catch (FileNotFoundException e) {
        System.err.println("Unable to find the file: "+filename+".txt");
      } catch (IOException e) {
        System.err.println("Unable to read the file: "+filename+".txt");
      }      
      
// ----------------------------------------------------------------------------------------------------   
//      try{
//      BufferedWriter writer = new BufferedWriter(new FileWriter(filename+"_noVowels.txt"));
//      writer.write(strLine);
//      writer.close(); 
//      } catch (FileNotFoundException e) {
//        System.err.println("Unable to find the file: "+filename+".txt");
//      }catch(IOException e){
//        System.err.println("Unable to write the file: "+filename+".txt");
//      }
//-----------------------------------------------------------------------------------------------------
//CAN CREATE A FILE BUT CANNOT COPY OVER
//SPOKE TO PROF., HE SAID STORE THE READ INTO AN ARRAYLIST / ARRAY THEN WRITE THE ARRAYLIST / ARRAY OUT
      
    }
  }

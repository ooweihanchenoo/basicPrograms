import java.util.*;
import java.io.*;

public class ReadFile {
  public static void main(String[] args) {
    File input;
    // String[] words = {};
    
    System.out.println("What is the name of the text file?");
    Scanner scanner = new Scanner(System.in);
    String filename = scanner.nextLine();
    scanner.close();
    
Scanner sc = null;
    try {
      input = new File(filename);
      sc = new Scanner(input);
/*      int length = sc.nextLine();
      
      words = new String[length];
  a    int i = 0;
      while (sc.hasNextLine() && i < length) {
        words[i] = sc.nextLine();
        i++;
      }
      sc.close();
    Scanner scanner1=null;
*/
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
    while (sc.hasNextLine()){
      sc = new Scanner(sc.nextLine());
      while(sc.hasNext()){
        String s = sc.next();
        System.out.println(s);
      }
      /*       Arrays.sort(words);
       for(int a:words)sum+=a;
       float avg=sum/words.length;
       File output;
       
       
       
       try{
       output= new File(filename+"_noVowels.txt");
       FileWriter fr=new FileWriter(output);
       
       fr.write("Maximum: "+max+"\n");
       fr.write("Minimum: "+min+"\n");
       fr.write("Total: "+sum+"\n");
       fr.write("Average: "+avg);
       fr.close();
       }catch(IOException e){System.out.println(e);}
       */
    }
  }
}
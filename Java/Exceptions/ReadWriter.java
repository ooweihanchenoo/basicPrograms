import java.io.*; //Import java io 
import java.util.*; //Import java utilities

public class ReadWriter {
  public static void main(String[] args){
 
//DECLARE VARIABLES
//---------------------------------------------------------------------------------------------------------------------    
    BufferedReader reader = null;
    String strLine=null;
    List<String> storage = new ArrayList<String>();
//---------------------------------------------------------------------------------------------------------------------
//GETTING THE FILE NAME FROM USER    
//---------------------------------------------------------------------------------------------------------------------    
    System.out.println("What is the name of the text file?((DO NOT INCLUDE .TXT))");
    Scanner scanner = new Scanner(System.in);
    String filename = scanner.nextLine();
    scanner.close(); 
//---------------------------------------------------------------------------------------------------------------------
//IOEXCEPTION
//---------------------------------------------------------------------------------------------------------------------
    try {
      //OPEN AND READ SELECTED FILS.TXT
      reader = new BufferedReader(new FileReader(filename+".txt"));
      
      //CREATE A NEW FILE_NOVOWELS
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename+"_noVowels.txt"));
      
      //READ EACH LINES IN TXT FILE AND STORE IT INTO STORAGE(ARRAYLIST)
      while( (strLine=reader.readLine()) !=null){
        storage.add(strLine);
      }
//---------------------------------------------------------------------------------------------------------------------      
//USING FOR LOOP TO REMOVED EVERY VOWELS IN EACH LINES    
//---------------------------------------------------------------------------------------------------------------------
      for (String s : storage){ 
        s = s.replace("a",""); 
        s = s.replace("e","");
        s = s.replace("i","");
        s = s.replace("o","");
        s = s.replace("u","");        
        writer.write(s+"\r\n");
      }
//---------------------------------------------------------------------------------------------------------------------            
//CLOSE WRITER AND READER
//---------------------------------------------------------------------------------------------------------------------      
      writer.close();
      reader.close();
//---------------------------------------------------------------------------------------------------------------------
//IF NO SUCH FILE NAME EXIST IN THE SAME DIRECTORY, THE ERROR MESSAGE WILL APPEARS
//---------------------------------------------------------------------------------------------------------------------      
    } catch (FileNotFoundException e) {
      System.err.println("Unable to find the file: "+filename+".txt");
    } catch (IOException e) {
      System.err.println("Unable to find the file: "+filename+".txt");
    }           
  }
}

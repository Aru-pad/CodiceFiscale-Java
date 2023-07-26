import java.io.BufferedReader;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Vector;

public class file {
 public List<String> list = new ArrayList<String>();
 Vector<String> v = new Vector<String>();
 
    
    public <T> Object[] convertVectorToArray() 
    { 
        // Converting Vector to Array 
        Object[] Array = v.toArray(); 
        
        return Array; 
    } 

	public file(){
        StringBuilder sb = new StringBuilder();
        String stringLine = "";
        try {
             BufferedReader br = new BufferedReader(new FileReader("Codici.txt"));
              while (stringLine != null)
               {
            	  stringLine = br.readLine();
                sb.append(stringLine);
                sb.append(System.lineSeparator());
                stringLine = br.readLine();
                if (stringLine==null)
                   break;
                list.add(stringLine);
            }
              for (int i = 0; i < this.list.size(); i++) {
            	  String c=list.get(i);
            	  v.add(c);
              }
             br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato");
        } catch (IOException e) {
            System.err.println("Impossibile leggere il file.");
        }
     }
}

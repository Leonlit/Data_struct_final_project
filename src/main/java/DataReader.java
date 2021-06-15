import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataReader {
    
    final static public String getRecords () {
        String result = readFileContent();
        return result;
    }
    
    final static private String readFileContent () {
        String data = "";
        try {
            File directory = new File(".");
            String fileName = directory.getCanonicalPath().concat(File.separator + "assets") 
                                + File.separator + "books.json";
            System.out.println(fileName);
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              data += myReader.nextLine();
            }
            myReader.close();
            System.out.println("Getting Dummy book data");
            
        }catch (IOException ex) {
            System.out.println("Error when getting data from file");
            ex.printStackTrace();
        }
        return data;
    }
}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
            Menu.printMessage("trying to get dummy book data");
            
        }catch (IOException ex) {
            Menu.printMessage("Error when getting data from file");
            ex.printStackTrace();
        }
        
        Menu.printMessage("Finished Reading Data from file");
        return data;
    }
}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;

public class DataReader {
    final static Book[] BOOKS_AVAILABLE = getRecords();
    
    final static public Book[] getRecords () {
        String result = readFileContent();
        System.out.println(result);
        Book books[] = new Book[1];
        try {
            
            JSONArray data = new JSONArray(result);
            books = new Book[data.length()];
            for (int x = 0; x< data.length();x++) {
                    int id = data.getJSONObject(x).getInt("id");
                    String name = data.getJSONObject(x).getString("name");
                    String writer = data.getJSONObject(x).getString("writer");
                    String date = data.getJSONObject(x).getString("date");
                    String categories[] = getJsonArrayValue(data.getJSONObject(x).getJSONArray("categories"));
                    String waitingList[] = getJsonArrayValue(data.getJSONObject(x).getJSONArray("waiting-list"));
                    String history[] = getJsonArrayValue(data.getJSONObject(x).getJSONArray("previously-borrowed"));
                    Book temp = new Book(id, name, writer, date, categories, waitingList, history);
                    books[x] = temp;
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
            ex.printStackTrace();
        }
        return books;
    }
    
    final static private String[] getJsonArrayValue (JSONArray arr) {
        String results[] = new String[arr.length()];
        try {
            for (int idx = 0;idx < arr.length();idx++) {
                results[idx] = arr.getString(idx);
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
        }
        return results;
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

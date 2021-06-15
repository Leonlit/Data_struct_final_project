
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

//generate data from the json data (random everytime)
public class DataGenerator {
    
    final static public Book[] generateBooks () {
        Book[] books = new Book[20]; 
        try {
            JSONObject data = new JSONObject(DataReader.getRecords());
            int bookID[] = getJsonArrayIntValue(data.getJSONArray("writers"));
            String bookName[] = getJsonArrayStringValue(data.getJSONArray("bookName"));
            String writers[] = getJsonArrayStringValue(data.getJSONArray("writers"));
            String dates[] = getJsonArrayStringValue(data.getJSONArray("dates"));
            String categories[] = getJsonArrayStringValue(data.getJSONArray("categories"));
            String bookCategories[] = getJsonArrayStringValue(data.getJSONArray("bookCategories"));
            String students[] = getJsonArrayStringValue(data.getJSONArray("students"));
            String waitingList[][] = getBookWaitingList(data.getJSONArray("waitingList"));
            for (int idx=0;idx < bookID.length;) {
                String currBookCategories = generateCategories(categories, bookCategories[idx]);
                
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
            ex.printStackTrace();
        }
        
        
        return books;
    }
    
    final static private String[][] getBookWaitingList (JSONArray arr) {
        String results[][] = new String[20][7];
        try {
            for (int idx = 0;idx < arr.length();idx++) {
                results[idx] = getJsonArrayStringValue(arr.getJSONArray(idx));
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
        }
        return results;
    }
    
    final static private String[] getJsonArrayStringValue (JSONArray arr) {
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
    
    final static private int[] getJsonArrayIntValue (JSONArray arr) {
        int results[] = new int[arr.length()];
        try {
            for (int idx = 0;idx < arr.length();idx++) {
                results[idx] = arr.getInt(idx);
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
        }
        return results;
    }
    
}

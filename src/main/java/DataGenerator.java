
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//generate data from the json data (random everytime)
public class DataGenerator {
    final static public Book[] generateBooks () {
        Book[] books = new Book[20]; 
        try {
            JSONObject data = new JSONObject(DataReader.getRecords());
            int bookID[] = getJsonArrayIntValue(data.getJSONArray("bookID"));
            String bookName[] = getJsonArrayStringValue(data.getJSONArray("bookName"));
            String writers[] = getJsonArrayStringValue(data.getJSONArray("writers"));
            String dates[] = getJsonArrayStringValue(data.getJSONArray("dates"));
            String categories[] = getJsonArrayStringValue(data.getJSONArray("categories"));
            int waitingList[][] = getJsonArrayofArrayValue(data.getJSONArray("waitingList"));
            String students[] = getJsonArrayStringValue(data.getJSONArray("students"));
            
            for (int idx=0;idx < bookID.length;idx++) {
                String currBookCategories[] = generateCategories(shuffleStringArray(categories), genRandomNumber(2, 4));
                String history[][] = generateHistory(dates, students);
                String waiting[] = generateWaitingList(waitingList[idx], students);
                books[idx] = new Book(bookID[idx], bookName[idx], writers[idx],
                                  dates[idx], currBookCategories, waiting, history);
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
            ex.printStackTrace();
        }
        return books;
    }
    
    final static private String[][] generateHistory (String[] dates, String[] student) {
        int rand = genRandomNumber(3, 10);
        String results[][] = new String[rand][2];
        String newDates[] = shuffleStringArray(dates);
        String newStudents[] = shuffleStringArray(student);
        for (int idx = 0; idx< rand; idx++) {
            results[idx] = new String[]{newDates[idx], newStudents[idx]};
        }
        return results;
    }
    
    final static private int genRandomNumber (int min, int max) {
        int rand = (int)(Math.random() * (max - min + 1) + min);
        return rand;
    }
    
    final static private String[] shuffleStringArray (String[] arr) {

        List<String> stringList = Arrays.asList(arr);
        Collections.shuffle(stringList);
        return stringList.toArray(arr);
    }
    
    final static private String[] generateWaitingList (int[] list, String[] students) {
        String result[] = new String[list.length];
        for (int idx = 0;idx < list.length;idx++) {
            result[idx] = students[list[idx]];
        }
        return result;
    }
    
    final static private String[] generateCategories (String labels[], int max) {
        String categories[] = new String[max];
        for (int idx = 0; idx < max; idx++) {
            categories[idx] = labels[idx];
        }
        return categories;
    }
    
    final static private int[][] getJsonArrayofArrayValue (JSONArray arr) {
        int results[][] = new int[20][7];
        try {
            for (int idx = 0;idx < arr.length();idx++) {
                results[idx] = getJsonArrayIntValue(arr.getJSONArray(idx));
            }
        }catch (JSONException ex) {
            System.out.println("JSON file is not valid!!!");
            ex.printStackTrace();
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.GregorianCalendar;
import java.util.Random;

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
            String peoples[] = getJsonArrayStringValue(data.getJSONArray("students"));
            
            for (int idx=0;idx < bookID.length;idx++) {
                String currBookCategories[] = generateCategories(shuffleStringArray(categories), genRandomNumber(1, 3));
                String history[][] = generateHistory(peoples);
                String waiting[] = generateWaitingList(peoples);
                Random random = new Random();
                books[idx] = new Book(bookID[idx], bookName[idx], writers[idx],
                                  dates[idx], currBookCategories, waiting, history, random.nextBoolean());
            }
        }catch (JSONException ex) {
            Menu.printMessage("JSON file is not valid!!!");
        }
        return books;
    }
    
    private static String[][] generateHistory (String[] people) {
        int rand = genRandomNumber(3, 10);
        String results[][] = new String[rand][2];
        String newDates[] = new String[rand];
        for (int idx = 0;idx < rand;idx++) {
            newDates[idx] = generateDateBetweenAYear();
        }
        String sortedDates[] = sortDate(newDates);
        String newPeoples[] = shuffleStringArray(people);
        for (int idx = 0; idx< rand; idx++) {
            results[idx] = new String[]{sortedDates[idx], newPeoples[idx]};
        }
        return results;
    }
    
    private static String[] sortDate (String[] dates) {
        int timeStamp[] = new int[dates.length];
        for (int idx = 0; idx < dates.length;idx++) {
            timeStamp[idx] = getTimeStamp(dates[idx]);
        }
        for (int idx = 0;idx < dates.length;idx++) {
            for (int counter = 1;counter < dates.length - idx;counter++) {
                if (timeStamp[counter] < timeStamp[counter - 1]) {
                    String temp = dates[counter];
                    dates[counter] = dates[counter - 1];
                    dates[counter - 1] = temp;
                    int tempTime = timeStamp[counter];
                    timeStamp[counter] = timeStamp[counter - 1];
                    timeStamp[counter - 1] = tempTime;
                }
            }
        }
        return dates;
    }
    
    private static int getTimeStamp (String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date converted = formatter.parse(date);
            return (int)(converted.getTime() / 1000);
        } catch (ParseException ex) {
            Menu.printMessage("Error in converting date to timestamp");
        }
        return -1;
    }
    
    private static int genRandomNumber (int min, int max) {
        int rand = (int)(Math.random() * (max - min + 1) + min);
        return rand;
    }
    
    private static String[] shuffleStringArray (String[] arr) {

        List<String> stringList = Arrays.asList(arr);
        Collections.shuffle(stringList);
        return stringList.toArray(arr);
    }
    
    private static String[] generateWaitingList (String[] peoples) {
        String shuffledArr[] = shuffleStringArray(peoples);
        int rand = genRandomNumber (3, 5);
        String result[] = new String[rand];
        for (int idx = 0;idx < rand;idx++) {
            result[idx] = shuffledArr[idx];
        }
        return result;
    }
    
    private static String[] generateCategories (String labels[], int max) {
        String categories[] = new String[max];
        System.arraycopy(labels, 0, categories, 0, max);
        return categories;
    }
    
//    private static int[][] getJsonArrayofArrayValue (JSONArray arr) {
//        int results[][] = new int[20][7];
//        try {
//            for (int idx = 0;idx < arr.length();idx++) {
//                results[idx] = getJsonArrayIntValue(arr.getJSONArray(idx));
//            }
//        }catch (JSONException ex) {
//            Menu.printMessage("JSON file is not valid!!!");
//        }
//        return results;
//    }
    
    private static String[] getJsonArrayStringValue (JSONArray arr) {
        String results[] = new String[arr.length()];
        try {
            for (int idx = 0;idx < arr.length();idx++) {
                results[idx] = arr.getString(idx);
            }
        }catch (JSONException ex) {
            Menu.printMessage("JSON file is not valid!!!");
        }
        return results;
    }
    
    private static int[] getJsonArrayIntValue (JSONArray arr) {
        int results[] = new int[arr.length()];
        try {
            for (int idx = 0;idx < arr.length();idx++) {
                results[idx] = arr.getInt(idx);
            }
        }catch (JSONException ex) {
            Menu.printMessage("JSON file is not valid!!!");
        }
        return results;
    }
    
    final static public String generateDateBetweenAYear () {
        GregorianCalendar gc = new GregorianCalendar();
        int currYear = Year.now().getValue();
        int year = randBetween(currYear - 1, currYear);
        gc.set(GregorianCalendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
        String date = gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) 
                        + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
    }
    
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    
    public static String generateName () {
        String nameList[] = new String[]{"Thaddaios Muraro", "Rebekka Beck", "Pedram Christoffersen",
                                    "Luisinho Haggard", "Maria Kemény", "Nazar Martinsen", "Hyacinthe Abt",
                                    "Janek Ek","Madhavi Förstner", "Turin Deforest"};
        return nameList[(int)(Math.random() * nameList.length)];
    }
    
    public static String getCurrentDate () {
        String currDate = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(date);
        return currDate;
    }
    
}

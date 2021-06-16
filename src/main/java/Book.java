
import java.util.Arrays;

public class Book {
    private int id;
    private String name, date, writer;
    private String categories[];
    private WaitingList waitingList;
    //private BookNetwork previousBorrower;

    public Book (int id, String name, String writer, String date, String[] categories,
            String[] waitingList, String[][] history) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.writer = writer;
        this.categories = categories;
        this.waitingList = new WaitingList(waitingList);
        
        //System.out.println(name + ", " + date + ", " + writer);
    }
    
    public int getID() {
        return this.id;
    }

    public String getTitle() {
        return this.name;
    }

    public String getWriter () {
        return this.writer;
    }

    public String getDate() {
        return this.date;
    }
    
    public WaitingList getWaitingList(){
        return this.waitingList;
    }

    public void DisplayWaitingList () {
        waitingList.displayQueue();
    }
    
    public String getCategories() {
        String categories = Arrays.toString(this.categories);
        categories = categories.replaceAll("\\[|\\]", "");
        return categories;
    }
}

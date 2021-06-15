
import java.util.ArrayList;

public class Book {
    private int id;
    private String name, date, writer;
    private String categories[];
    //private BookQueue waitingList;
    //private BookNetwork previousBorrower;

    public Book (int id, String name, String writer, String date, String[] categories,
            String[] waitingList, String[][] history) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.writer = writer;
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

    public String[] getCategories () {
        return this.categories;
    }
}

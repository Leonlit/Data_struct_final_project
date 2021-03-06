import java.util.Arrays;

public class Book {
    private int id;
    private String name, date, writer;
    private String categories[];
    private HistoryList historyList;
    private WaitingList waitingList;
    private boolean borrowed;
    private boolean isInCart;
    private boolean inWaitingList = false;

    public Book (int id, String name, String writer, String date, String[] categories,
            String[] waitingList, String[][] history, boolean borrowed) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.writer = writer;
        this.categories = categories;
        this.waitingList = new WaitingList(waitingList);
        this.historyList = new HistoryList();
        for (String[] temp : history) {
            this.historyList.pushNode(temp);
        }
        this.borrowed = borrowed;
        isInCart = false;
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
    
    public boolean isInCart () {
        return this.isInCart;
    }
    
    public boolean isBorrowed () {
        return this.borrowed;
    }
    
    public boolean isInWaitingList () {
        return inWaitingList;
    }
    
    public void setInWaitingList() {
        this.inWaitingList = true;
    }
    
    public void setBorrowed(String[] data) {
        this.historyList.pushNode(data);
        this.borrowed = true;
    }
    
    public void setReturned() {
        if (!isBorrowed()) {
            Menu.printMessage("The Book " + getTitle() + " is not borrowed by anyone at the moment");
            return;
        }
        Menu.printMessage("Book returned By " + getCurrentBorrower()[1]);
        this.borrowed = false;
    }
    
    public void setInCart () {
        this.isInCart = true;
    }
    
    public void setNotInCart () {
        this.isInCart = false;
    }
    
    public String[] getCurrentBorrower () {
        if (!isBorrowed()) {
            return null;
        }
        return this.historyList.getLast().getValue();
    }
    
    public WaitingList getWaitingList(){
        return this.waitingList;
    }

    public void DisplayWaitingList () {
        waitingList.displayQueue();
    }
    
    public String getCategoriesToString() {
        String categories = Arrays.toString(this.categories);
        categories = categories.replaceAll("\\[|\\]", "");
        return categories;
    }
    
    public String[] getCategories() {
        return this.categories;
    }
    
    public HistoryList getHistoryList () {
        return this.historyList;
    }
}

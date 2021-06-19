
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookViewer {
    private Book viewedBook;
    private int option;

    public BookViewer (Book viewedBook) {
        this.viewedBook = viewedBook;
    }
    
    public int startView () {
        this.option = 0;
        do {
            showMenu();
            this.option = InputUtil.getInteger(false);
            getView(this.option);
        }while (this.option > 0);
        return this.option;
    }

    public void getView (int option) {
        switch (option) {
            case -1:
                Menu.printReturnedPreviousMenu();
                break;
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                this.showInfo();
                break;
            case 2:
                this.historyInfo();
                break;
            case 3:
                int choosen = 1;
                do {
                    waitingListMenu();
                    choosen = InputUtil.getInteger(false);
                    waitingListExecuter(choosen);
                }while (choosen >0);
                if (choosen == 0) 
                    this.option = 0;
                break;
            default:
                Menu.invalidOptionMessage();
                break;
        }
    }

    public void showMenu () {
        Menu.printNewLine();
        Menu.printTitle("Book Viewer Menu for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printOrderedOption("1" ,"Show book info");
        Menu.printOrderedOption("2" ,"Show book history info");
        Menu.printOrderedOption("3" ,"Show waiting list menu");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printRequestOption();
        Menu.printHorizontalBorder(true);
    }

    public void showInfo() {
        Menu.printNewLine();
        Menu.printTitle("Viewing Info for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printCategory("Name", viewedBook.getTitle());
        Menu.printCategory("Writer", viewedBook.getWriter());
        Menu.printCategory("Date", viewedBook.getDate());
        Menu.printCategory("ID", String.valueOf(viewedBook.getID()));
        Menu.printCategory("Categories", viewedBook.getCategories());
        String[] borrower = viewedBook.getCurrentBorrower();
        String status = "";
        if (borrower != null) {
            status = borrower[1] + ", " + borrower[0];
        }else {
            status = "None";
        }
        Menu.printCategory("Borrowed By", status);
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void historyInfo() {
        String history[][] = viewedBook.getHistoryList().getAll();
        Menu.printNewLine();
        Menu.printTitle("Borrower history list for " + viewedBook.getTitle());
        Menu.printEmptyRow();
        for (int idx = 0; idx < history.length;idx++) {
            String msg = history[idx][0] + "    " + history[idx][1];
            if (idx == history.length - 1  && viewedBook.isBorrowed()) {
                msg += " ( Currently borrowing )";
            }
            Menu.printOrderedOption(Integer.toString(idx + 1), msg);
        }
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void waitingListInfo() {
        Menu.printNewLine();
        Menu.printEmptyRow();
        Menu.printTitle("Viewing Waiting List for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        viewedBook.DisplayWaitingList();
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
      
    private void waitingListMenu() {
        Menu.printNewLine();
        Menu.printTitle("Book Waiting List Menu for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printOrderedOption("1" ,"Show book waiting list");
        Menu.printOrderedOption("2" ,"Add new borrower to waiting list");
        Menu.printOrderedOption("3" ,"Dequeue the waiting list");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printRequestOption();
        Menu.printHorizontalBorder(true);
    }
    
    private void waitingListExecuter(int option) {
        boolean done = false;
        switch(option) {
            case -1:
                Menu.printReturnedPreviousMenu();
                break;
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                waitingListInfo();
                break;
            case 2:
                while (!done) {
                    try{
                        Menu.printTitle("Please enter the name to be added into the waiting list:");
                        String name = InputUtil.getString(false);
                        viewedBook.getWaitingList().enQueue(name);
                        Menu.printMessage("Added " + name + " into the waiting list");
                    }catch (Exception ex) {
                    }
                    done = true;
                }
                break;
            case 3:
                if (viewedBook.isBorrowed()) {
                    Menu.printMessage("Can't dequeue waiting list. The book is currently borrowed by " + viewedBook.getCurrentBorrower());
                }else {
                    while (!done) {
                        try{
                            String nextBorrower = viewedBook.getWaitingList().deQueue();
                            String message = "Removed " + nextBorrower + " from the waiting list for borrowing " + viewedBook.getTitle();
                            Menu.printMessage(message);
                            String currDate = getCurrentDate();
                            viewedBook.getHistoryList().pushNode(new String[]{currDate, nextBorrower});
                            viewedBook.setBorrowed();
                        }catch (Exception ex) {
                        }
                        done = true;
                    }
                }
                break;
            default:
                Menu.printMessage("Invalid option!!! Please choose again");
        }
    }
    
    private String getCurrentDate () {
        String currDate = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(date);
        return currDate;
    }
    
    private String getNextBorrower () {
        return viewedBook.getWaitingList().deQueue();
    }
}

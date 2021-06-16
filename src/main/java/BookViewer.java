import java.util.Arrays;
import java.util.Scanner;

public class BookViewer {
    private Book viewedBook;

    public BookViewer (Book viewedBook) {
        this.viewedBook = viewedBook;
        int option = 0;
        do {
            showMenu();
            option = InputUtil.getInteger(false);
            getView(option);
        }while (option > 0);
    }

    public void getView (int option) {
        switch (option) {
            case -1:
                Menu.printReturnedPreviousMenu("Returning to Search Book Details Menu");
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
                this.waitingListInfo();
                break;
            case 4:
                int choosen = 1;
                Scanner input = new Scanner(System.in);
                do {
                    waitingListExecuter(choosen);
                    choosen = input.nextInt();
                    this.waitingListMenu();
                }while ()
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
        Menu.printOrderedOption("3" ,"Show book waiting list");
        Menu.printOrderedOption("4" ,"Show waiting list menu");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void showInfo() {
        Menu.printNewLine();
        Menu.printEmptyRow();
        Menu.printTitle("Viewing Info for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printCategory("Name", viewedBook.getTitle());
        Menu.printCategory("Writer", viewedBook.getWriter());
        Menu.printCategory("Date", viewedBook.getDate());
        Menu.printCategory("ID", String.valueOf(viewedBook.getID()));
        Menu.printCategory("Categories", viewedBook.getCategories());
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void historyInfo() {
        Menu.printNewLine();
        Menu.printEmptyRow();
        Menu.printTitle("Viewing History Info for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        //need implementation
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
    
    private waitingListExecuter() {
        
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
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
    
    public String getNextBorrower () {
        return viewedBook.getWaitingList().deQueue();
    }
}

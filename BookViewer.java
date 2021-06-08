import java.util.Arrays;

public class BookViewer {
    private Book viewedBook;

    public BookViewer (Book viewedBook) {
        this.viewedBook = viewedBook;
    }

    public void getView (int option) {
        switch (option) {
            case -1:
                
                break;
            case 0:
                
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
            default:
                Menu.invalidOptionMessage();
                break;
        }
    }

    public void showMenu () {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printTitle("Book Viewer Menu");
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printOrderedOption("1" ,"Show book info");
        Menu.printOrderedOption("2" ,"Show book history info");
        Menu.printOrderedOption("3" ,"Show book waiting list");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void showInfo() {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printTitle("Viewing Info for " + viewedBook.getTitle());
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printCategory("Name", viewedBook.getTitle());
        Menu.printCategory("Writer", viewedBook.getWriter());
        Menu.printCategory("Date", viewedBook.getDate());
        Menu.printCategory("ID", String.valueOf(viewedBook.getID()));
        Menu.printCategory("Categories", Arrays.toString(viewedBook.getCategories()));
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void historyInfo() {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printTitle("Viewing History Info for " + viewedBook.getTitle());
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        //need implementation
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void waitingListInfo() {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printTitle("Viewing Waiting List for " + viewedBook.getTitle());
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        //need implementation
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
}

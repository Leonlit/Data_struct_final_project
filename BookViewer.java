import java.util.Arrays;

public class BookViewer {
    private Book viewedBook;

    public BookViewer (Book viewedBook) {
        this.viewedBook = viewedBook;
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

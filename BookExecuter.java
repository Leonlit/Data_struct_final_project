public class BookExecuter {
    // optional
    final static void searchByCategoryMenu () {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printTitle("Search Book By Category");
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
        System.out.println("Please Enter the Book ID that you would like to search");
        int bookID = InputUtil.getInteger(true);
        //searching algorithm
    }

    // optional
    final static void searchByNameMenu () {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printTitle("Search Book By Name");
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
        System.out.println("Please Enter the Book ID that you would like to search");
        int bookID = InputUtil.getInteger(true);
        //searching algorithm
    }

    final static void searchByIDMenu () {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printTitle("Search Book By ID");
        Menu.printHorizontalBorder(false);
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
        System.out.println("Please Enter the Book ID that you would like to search");
        int bookID = InputUtil.getInteger(true);
        //searching algorithm
    }

    final static void bookViewerMenu () {
        Menu.printNewLine();
        Menu.printHorizontalBorder(false);
        Menu.printTitle("Please enter the ID for the book");
        Menu.printHorizontalBorder(false);
        Menu.printNewLine();
        int bookID = InputUtil.getInteger(true);
        Book currBook = getBook(bookID);
        int option = 0;
        BookViewer viewer = new BookViewer(currBook);
        do {
            viewer.getView(option);
            option = InputUtil.getInteger(false);
        }while (option > 0);
    }
}

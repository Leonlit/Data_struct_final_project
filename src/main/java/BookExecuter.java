public class BookExecuter {
    // optional
    final static void searchByCategoryMenu () {
        Menu.printNewLine();
        Menu.printTitle("Search Book By Category");
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
        System.out.println("Please Enter the Book ID that you would like to search");
        int bookID = InputUtil.getInteger(true);
        //searching algorithm
    }

    // optional
    final static void searchByNameMenu () {
        Menu.printNewLine();
        Menu.printTitle("Search Book By Name");
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
        System.out.println("Please Enter the Book ID that you would like to search");
        int bookID = InputUtil.getInteger(true);
        //searching algorithm
    }

    final static void searchByIDMenu () {
        Menu.printNewLine();
        Menu.printTitle("Search Book By ID");
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
        System.out.println("Please Enter the Book ID that you would like to search");
        int bookID = InputUtil.getInteger(true);
        //Book currBook = getBook(bookID);
        //searching algorithm
    }

    final static void bookViewerMenu () {
        Menu.printNewLine();
        Menu.printTitle("Please enter the ID for the book");
        Menu.printNewLine();
        int bookID = InputUtil.getInteger(true);
        //Book currBook = getBook(bookID);
        //BookViewer viewer = new BookViewer(currBook);
    }

    // need searching algorithm
    /* final static Book getBook (int id) {
        Book foundBook;
        return foundBook;
    } */
}

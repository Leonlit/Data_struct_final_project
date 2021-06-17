public class BookExecuter {
    // optional
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
    
//    final static void searchByCategoryMenu () {
//        Menu.printNewLine();
//        Menu.printTitle("Search Book By Category");
//        Menu.printEmptyRow();
//        Menu.printHorizontalBorder(true);
//        System.out.println("Please Enter the Book ID that you would like to search");
//        int bookID = InputUtil.getInteger(true);
//        //searching algorithm
//    }
//
//    // optional
//    final static void searchByNameMenu () {
//        Menu.printNewLine();
//        Menu.printTitle("Search Book By Name");
//        Menu.printEmptyRow();
//        Menu.printHorizontalBorder(true);
//        System.out.println("Please Enter the Book ID that you would like to search");
//        int bookID = InputUtil.getInteger(true);
//        //searching algorithm
//    }

    final static void displayBookList () {
        Book[] books = Library.books;
        Menu.printTitle("Displaying list of books available");
        for (int idx = 0;idx < books.length;idx++) {
            Menu.printOrderedOption(Integer.toString(idx), books[idx].getTitle());
        }
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    // need searching algorithm
    /* final static Book getBook (int id) {
        Book foundBook;
        return foundBook;
    } */
}

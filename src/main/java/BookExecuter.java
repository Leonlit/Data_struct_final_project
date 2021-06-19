public class BookExecuter {
    final static void searchByIDMenu () {
        Menu.printNewLine();
        Menu.printMultiTitle(new String[]{
            "Search Book By ID",
            "Please enter the Book Number to search for the book (length of 5)"
        });
        Menu.printNewLine();
    }

    final static void displayBookList () {
        SortBook sorter = new SortBook(Library.books);
        Book[] books = sorter.sortBooks();
        Menu.printTitle("Displaying list of books available");
        Menu.printEmptyRow();
        for (int idx = 0;idx < books.length;idx++) {
            Menu.printOrderedOption(Integer.toString(idx + 1),  books[idx].getTitle() + " (" + books[idx].getID() + ")");
        }
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
}

public class Executer {
    final static void executeOption(int option) {
        switch (option) {
            case 1:
                searchBook();
                break;
            case 2:
                //viewCart();
                break;
            case 3:
                //checkOutCart();
                break;
            default:
                break;
        }
    }

    final static void searchBook () {
        int choosen = -1;
        while (choosen != 0) {
            Menu.searchBookMenu();
            choosen = InputUtil.getInteger(false);
            executeBookCommand(choosen);
        }
        Menu.printReturnedMainMenu();
    }

    final static void executeBookCommand (int type) {
        switch (type) {
            case 1:
                BookExecuter.searchByIDMenu();
                //search book
                SearchBook bookSearcher = new SearchBook(Library.books);
                Menu.printMessage("Please enter the Book Number to search for the book (length of 5)");
                int input = InputUtil.getInteger(true);
                bookSearcher.find(input);
                //sort book
                //display book info menu
                break;
            case 2:
                BookExecuter.displayBookList();
                break;
            default:
                break;
        }
    }
}
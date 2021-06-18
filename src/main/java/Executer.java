public class Executer {
    private static boolean done = false;
    final static void executeOption(int option) {
        done = false;
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
        int choosen;
        while (!done) {
            Menu.searchBookMenu();
            choosen = InputUtil.getInteger(false);
            executeBookCommand(choosen);
            if (choosen == 0)
                done = true;
        }
    }

    final static void executeBookCommand (int type) {
        switch (type) {
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                BookExecuter.searchByIDMenu();
                int option = 0;
                //search book
                SearchBook bookSearcher = new SearchBook(Library.books);
                int input = InputUtil.getInteger(true);
                Book searched = bookSearcher.find(input);
                if (searched != null ) {
                    BookViewer viewer = new BookViewer(searched);
                    option = viewer.startView();
                    if ( option == 0) {
                        done = true;
                    }
                }
                break;
            case 2:
                BookExecuter.displayBookList();
                break;
            default:
                break;
        }
    }
}
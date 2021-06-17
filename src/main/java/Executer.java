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
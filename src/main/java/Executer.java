public class Executer {
    private static boolean done = false;
    final static void executeOption(int option) {
        done = false;
        switch (option) {
            case 1:
                searchBook();
                break;
            case 2:
                viewCart();
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
                SearchBook bookSearcher = new SearchBook(Library.books);
                BookExecuter.searchByIDMenu();
                int input = InputUtil.getInteger(true);
                if (input == -1) {
                    break;
                }
                Book searched = bookSearcher.find(input);
                if (searched != null ) {
                    int option = 0;
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
    
    final static void viewCart() {
        int choosen;
        while (!done) {
            Menu.cartMenu();
            choosen = InputUtil.getInteger(false);
            executeCartCommand(choosen);
            if (choosen == 0)
                done = true;
        }
    }
    
    final static void executeCartCommand (int type) {
        Cart temp = Library.cart;
        switch (type) {
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                temp.displayCart();
                break;
            case 2:
                temp.displayCart();
                if (temp.getCart().size() == 0) {
                    return;
                }
                int option = 0;
                getCartItemMenu();
                option = InputUtil.getInteger(false);
                Book selected = temp.getCartItem(option - 1);
                if (selected != null) {
                    BookViewer viewer = new BookViewer(selected);
                    option = viewer.startView();
                    if (option == 0) {
                        done = true;
                    }
                }
                break;
            case 3:
                temp.displayCart();
                if (temp.getCart().size() == 0) {
                    return;
                }
                int choosen = 0;
                temp.displayCart();
                Menu.printMessage("Enter a item number to remove it from the cart");
                choosen = InputUtil.getInteger(false);
                temp.removeBookfromCart(choosen - 1);
                break;
            default:
                break;
        }
    }
    
    final static void getCartItemMenu() {
        Menu.printNewLine();
        Menu.printMultiTitle(new String[]{
            "View Book detail",
            "Please enter the item number to view its detail"
        });
        Menu.printNewLine();
    }
}
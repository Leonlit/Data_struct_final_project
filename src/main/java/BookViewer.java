public class BookViewer {
    private Book viewedBook;

    public BookViewer (Book viewedBook) {
        this.viewedBook = viewedBook;
        int option = 0;
        do {
            showMenu();
            option = InputUtil.getInteger(false);
            getView(option);
        }while (option > 0);
    }

    public void getView (int option) {
        switch (option) {
            case -1:
                Menu.printReturnedPreviousMenu("Returning to Search Book Details Menu");
                break;
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                this.showInfo();
                break;
            case 2:
                this.historyInfo();
                break;
            case 3:
                int choosen = 1;
                do {
                    waitingListExecuter(choosen);
                    choosen = InputUtil.getInteger(false);
                    this.waitingListMenu();
                }while (choosen >0);
                break;
            default:
                Menu.invalidOptionMessage();
                break;
        }
    }

    public void showMenu () {
        Menu.printNewLine();
        Menu.printTitle("Book Viewer Menu for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printOrderedOption("1" ,"Show book info");
        Menu.printOrderedOption("2" ,"Show book history info");
        Menu.printOrderedOption("3" ,"Show waiting list menu");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void showInfo() {
        Menu.printNewLine();
        Menu.printEmptyRow();
        Menu.printTitle("Viewing Info for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printCategory("Name", viewedBook.getTitle());
        Menu.printCategory("Writer", viewedBook.getWriter());
        Menu.printCategory("Date", viewedBook.getDate());
        Menu.printCategory("ID", String.valueOf(viewedBook.getID()));
        Menu.printCategory("Categories", viewedBook.getCategories());
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void historyInfo() {
        Menu.printNewLine();
        Menu.printEmptyRow();
        Menu.printTitle("Viewing History Info for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        //need implementation
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void waitingListInfo() {
        Menu.printNewLine();
        Menu.printEmptyRow();
        Menu.printTitle("Viewing Waiting List for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        viewedBook.DisplayWaitingList();
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
    
    private void waitingListExecuter(int option) {
        boolean done = false;
        switch(option) {
            case -1:
                Menu.printReturnedPreviousMenu("Returning to Search Book Details Menu");
                break;
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                waitingListInfo();
                break;
            case 2:
                while (!done) {
                    try{
                        String name = InputUtil.getString(false);
                        viewedBook.getWaitingList().enQueue(name);
                        Menu.printMessage("Added " + name + " into the waiting list for borrowing" + viewedBook.getTitle());
                    }catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    done = true;
                }
                break;
            case 3:
                while (!done) {
                    try{
                        String nextBorrower = viewedBook.getWaitingList().deQueue();
                        String message = "Removed " + nextBorrower + " into the waiting list for borrowing" + viewedBook.getTitle();
                        Menu.printMessage(message);
                        // need graph
                        //viewedBook.
                    }catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    done = true;
                }
                break;
            default:
                Menu.printMessage("Invalid option!!! Please choose again");
        }
    }
    
    private void waitingListMenu() {
        Menu.printNewLine();
        Menu.printTitle("Book Waiting List Menu for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printOrderedOption("1" ,"Show book waiting list");
        Menu.printOrderedOption("2" ,"Add new borrower to waiting list");
        Menu.printOrderedOption("3" ,"Dequeue the waiting list");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }
    
    public String getNextBorrower () {
        return viewedBook.getWaitingList().deQueue();
    }
}

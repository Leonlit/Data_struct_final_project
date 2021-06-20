public class BookViewer {
    private Book viewedBook;
    private int option;

    public BookViewer (Book viewedBook) {
        this.viewedBook = viewedBook;
    }
    
    public int startView () {
        this.option = 0;
        do {
            showMenu();
            this.option = InputUtil.getInteger(false);
            getView(this.option);
        }while (this.option > 0);
        return this.option;
    }

    public void getView (int option) {
        switch (option) {
            case -1:
                Menu.printReturnedPreviousMenu();
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
                    waitingListMenu();
                    choosen = InputUtil.getInteger(false);
                    waitingListExecuter(choosen);
                }while (choosen >0);
                if (choosen == 0) 
                    this.option = 0;
                break;
            case 4:
                if (viewedBook.isBorrowed()) {
                    Menu.printMessage("Failed! The book is currently borrowed by " + viewedBook.getCurrentBorrower()[1]);
                    return;
                }else {
                    if (viewedBook.isInCart()) {
                        Menu.printMessage("The Book is already in your cart!");
                        return;
                    }else {
                        if (viewedBook.getWaitingList().isEmpty() || 
                                viewedBook.getWaitingList().getFront() == Library.username) {
                            Library.cart.addBookIntoCart(viewedBook);
                            viewedBook.setInCart();
                        }else {
                            Menu.printMessage("The Waiting List is not empty, you can't borrow"
                                    + " the Book before the others that are currently waiting before you!");
                        }
                    }
                }
                break;
            case 5:
                viewedBook.setReturned();
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
        Menu.printOrderedOption("4" ,"Add this book into cart");
        Menu.printOrderedOption("5" ,"Book returned by previous borrower");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printRequestOption();
        Menu.printHorizontalBorder(true);
    }

    public void showInfo() {
        Menu.printNewLine();
        Menu.printTitle("Viewing Info for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printCategory("Name", viewedBook.getTitle());
        Menu.printCategory("Writer", viewedBook.getWriter());
        Menu.printCategory("Date", viewedBook.getDate());
        Menu.printCategory("ID", String.valueOf(viewedBook.getID()));
        Menu.printCategory("Categories", viewedBook.getCategoriesToString());
        String[] borrower = viewedBook.getCurrentBorrower();
        String status = "";
        if (borrower != null) {
            status = borrower[1] + ", " + borrower[0];
        }else {
            status = "None";
        }
        Menu.printCategory("Borrowed By", status);
        Menu.printEmptyRow();
        Menu.printHorizontalBorder(true);
    }

    public void historyInfo() {
        String history[][] = viewedBook.getHistoryList().getAll();
        Menu.printNewLine();
        Menu.printTitle("Borrower history list for " + viewedBook.getTitle());
        Menu.printEmptyRow();
        for (int idx = 0; idx < history.length;idx++) {
            String msg = history[idx][0] + "    " + history[idx][1];
            if (idx == history.length - 1  && viewedBook.isBorrowed()) {
                msg += " ( Currently borrowing )";
            }
            Menu.printOrderedOption(Integer.toString(idx + 1), msg);
        }
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
      
    private void waitingListMenu() {
        Menu.printNewLine();
        Menu.printTitle("Book Waiting List Menu for : " + viewedBook.getTitle());
        Menu.printEmptyRow();
        Menu.printOrderedOption("1" ,"Show book waiting list");
        Menu.printOrderedOption("2" ,"Enter into the waiting list");
        Menu.printOrderedOption("3" ,"Dequeue the waiting list");
        Menu.printEmptyRow();
        Menu.printOrderedOption("-1" , "Back (Search Book detail's Menu)");
        Menu.printOrderedOption("0" , "Main menu");
        Menu.printEmptyRow();
        Menu.printRequestOption();
        Menu.printHorizontalBorder(true);
    }
    
    private void waitingListExecuter(int option) {
        switch(option) {
            case -1:
                Menu.printReturnedPreviousMenu();
                break;
            case 0:
                Menu.printReturnedMainMenu();
                break;
            case 1:
                waitingListInfo();
                break;
            case 2:
                if (viewedBook.isInWaitingList()) {
                    Menu.printMessage("You're already in the waiting list");
                    return;
                }
                viewedBook.getWaitingList().enQueue(Library.username);
                viewedBook.setInWaitingList();
                Menu.printMessage("Added " + Library.username + "(you) into the waiting list");
                break;
            case 3:
                dequeueBookWaitingList();
                break;
            default:
                Menu.printMessage("Invalid option!!! Please choose again");
        }
    }
        
    private void dequeueBookWaitingList() {
        if (viewedBook.isBorrowed()) {
            Menu.printMessage("Can't dequeue waiting list. The book is currently borrowed by " + viewedBook.getCurrentBorrower()[1]);
        }else {
            WaitingList temp = viewedBook.getWaitingList();
            if (temp.isEmpty()) {
                Menu.printMessage("The waiting list is empty");
                return;
            }
            String nextBorrower = viewedBook.getWaitingList().deQueue();
            String message = "Removed " + nextBorrower + " from the waiting list for borrowing " + viewedBook.getTitle();
            Menu.printMessage(message);
            String data[] = new String[]{DataGenerator.getCurrentDate(), nextBorrower};
            viewedBook.setBorrowed(data);
        }
    }
}

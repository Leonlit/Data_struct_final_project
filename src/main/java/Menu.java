
/**
 * Menu class
 *      used to print different type of menu for the program and most functions can be reused
 * @author Tung Lit Onn a.k.a Leonlit
 * @MatricNumber 056200
 */


public class Menu {
    //changable parameters
    final static String BOREDR_SYMBOL = "#";                                // Symbol for the borders
    final static String OPTION_ORDERED_SYMBOL = ". ";                       // Symbol for the ordered options
    final static String OPTION_UNORDERED_SYMBOL = "o ";                     // Symbol for the unordered options
    final static String OPTION_OPTION_SEPARATOR = " : ";                    // category separator
    final static int SPACE_BETWEEN = 2;                                     // Space between title's border
    final static int OPTIONS_TAB = 3;                                       // How many space for the options
    final static int MENU_LENGTH = 100 - (BOREDR_SYMBOL.length() * 2);      // length of our menu (exluding border length)
                                                                            // because they will be printed later

    final static public void showMenu(int type) {
        switch (type) {
            case -1:
                exitMenu();
                break;
            case 0:
                mainMenu();
                break;
            case 1:
                searchBookMenu();
                break;
            case 2:
                cartMenu();
                break;
            case 3:
                checkOutMenu();
                break;
            default:
                break;
        }
    }
    
    // main menu
    final static public void mainMenu() {
        printNewLine();
        printTitle("Main Menu");
        printEmptyRow();
        printOrderedOption("1" ,"Search Book");
        printOrderedOption("2" ,"View cart");
        printOrderedOption("3" ,"Checkout cart");
        printEmptyRow();
        printOrderedOption("-1" ,"Exit");
        printEmptyRow();
        printHorizontalBorder(true);
    }

    // search book's menu
    final static public void searchBookMenu() {
        printNewLine();
        printTitle("Search Book details");
        printEmptyRow();
        printOrderedOption("1" ,"Search by categories");
        printOrderedOption("2" ,"Search by name");
        printOrderedOption("3" ,"Search by ID");
        printOrderedOption("4" ,"View book info (by ID)");
        printEmptyRow();
        printOrderedOption("0" , "Main menu");
        printEmptyRow();
        printEmptyRow();
        printHorizontalBorder(true);
    }

    // book's menu
    final static public void BookMenu(String title) {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Viewing Book Details");
        printTitle(title);
        printHorizontalBorder(true);
    }

    // cart's menu
    final static public void cartMenu() {
        printNewLine();
        printTitle("Viewing cart items");
        printNewLine();
    }

    // checkout's  menu
    final static public void checkOutMenu() {
        printNewLine();
        printTitle("Continuing with checking out the books");
        printNewLine();
    }

    // Exit menu
    final static public void exitMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Thanks for using the program");
        printTitle("Exiting the program");
        printHorizontalBorder(false);
        printNewLine();
    }

    final static public void invalidOptionMessage () {
        printMessage("Invalid Option!!! Please try again!!!");
    }
    
    final static public void printReturnedMainMenu () {
        String msg = "Returning to Main menu";
        printMessage(msg);
    }

    final static public void printReturnedPreviousMenu (String prevMenu) {
        String msg = "Returning to " + prevMenu;
        printMessage(msg);
    }
    
    final static public void printMessage(String msg) {
        printNewLine();
        printTitle(msg);
        printNewLine();
    }

    final static public void printTitle (String title) {
        int half = (MENU_LENGTH - title.length() - (SPACE_BETWEEN * 2)) / 2;
        int times = 1;
        printHorizontalBorder(false);
        printSingleSymbol(false);
        if (half < 0) {
            if ()
        }
        for (int idx = 0;idx<times;idx++) {
            printContinous(" ", half + SPACE_BETWEEN, false);
            System.out.print(title);
            //print continously the remaining spaces and the border after the initial half and the title is printed
            printContinous(" ", half + SPACE_BETWEEN + (MENU_LENGTH % (half + half + title.length())), false);
            printSingleSymbol(true);
        }
        
        printHorizontalBorder(false);
    }

    final static public void printOrderedOption (String idx, String str) {
        printSingleSymbol(false);
        printContinous(" ", OPTIONS_TAB, false);
        System.out.print(idx + OPTION_ORDERED_SYMBOL);
        System.out.print(str);
        // need to minus with the str, idx option's and it's symbol, and the option's tab length
        int remains = MENU_LENGTH - str.length() - OPTIONS_TAB - OPTION_ORDERED_SYMBOL.length() - idx.length();
        printContinous(" ", remains, false);
        printSingleSymbol(true);
    }

    final static public void printUnorderedOption (String str) {
        printSingleSymbol(false);
        printContinous(" ", OPTIONS_TAB, false);
        System.out.print(OPTION_UNORDERED_SYMBOL + str);
        // need to minus with the str, idx option's and it's symbol, and the option's tab length
        int remains = MENU_LENGTH - str.length() - OPTIONS_TAB - OPTION_UNORDERED_SYMBOL.length();
        printContinous(" ", remains, false);
        printSingleSymbol(true);
    }

    final static public void printCategory (String label, String value) {
        printSingleSymbol(false);
        printContinous(" ", OPTIONS_TAB, false);
        System.out.print(OPTION_UNORDERED_SYMBOL + label + OPTION_OPTION_SEPARATOR + value);
        // need to minus with the str, idx option's and it's symbol, and the option's tab length
        int remains = MENU_LENGTH - label.length() - value.length() - OPTIONS_TAB - 
                        OPTION_UNORDERED_SYMBOL.length() - OPTION_OPTION_SEPARATOR.length();
        printContinous(" ", remains, false);
        printSingleSymbol(true);
    }

    //printing a line of border based on the length of the menu and the symbol used
    final static public void printHorizontalBorder (boolean doubleNewline) {
        printSingleSymbol(false);
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(BOREDR_SYMBOL);
        }
        printSingleSymbol(true);
        if (doubleNewline) printNewLine();
    }

    final static public void printEmptyRow() {
        printSingleSymbol(false);
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(" ");
        }
        printSingleSymbol(true);
    }

    final static public void printContinous (String str, int size, boolean newline) {
        for (int idx = 0;idx < size;idx++) {
            System.out.print(str);
        }
        if (newline) printNewLine();
    }

    final static public void printSingleSymbol(boolean newline) {
        System.out.print(BOREDR_SYMBOL);
        if (newline) printNewLine();
    }

    public static void printNewLine () {
        System.out.println();
    }
}

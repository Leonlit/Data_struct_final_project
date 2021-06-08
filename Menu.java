
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
        printHorizontalBorder(false);
        printTitle("Main Menu");
        printHorizontalBorder(false);
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
        printHorizontalBorder(false);
        printTitle("Search Book details");
        printHorizontalBorder(false);
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
        printHorizontalBorder(false);
        printTitle("Viewing cart items");
        printHorizontalBorder(true);
    }

    // checkout's  menu
    final static public void checkOutMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Continuing with checking out the books");
        printHorizontalBorder(false);
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
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Invalid Option!!! Please try again!!!");
        printHorizontalBorder(false);
        printNewLine();
    }
    
    final static public void printReturnedMainMenu () {
        String msg = "Returning to Main menu";
        printTitle(msg);
    }

    final static public void printReturnedPreviousMenu () {
        String msg = "Returning to Main menu";
        printTitle(msg);
    }

    final static public void printTitle (String title) {
        printSingleSymbol(false);
        int half = (MENU_LENGTH - title.length()) / 2;
        printContinous(" ", half, false);
        System.out.print(title);
        //print continously the remaining spaces and the border after the initial half and the title is printed
        printContinous(" ", half + (MENU_LENGTH % (half + half + title.length())), false);
        printSingleSymbol(true);
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

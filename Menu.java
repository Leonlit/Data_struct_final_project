
/**
 * Menu class
 *      used to print different type of menu for the program and most functions can be reused
 * @author Tung Lit Onn a.k.a Leonlit
 * @MatricNumber 056200
 */


public class Menu {
    //changable parameters
    final static String BOREDR_SYMBOL = "#";                                // Symbol for the borders
    final static String OPTION_SYMBOL = ". ";                               // Symbol for the options
    final static int OPTIONS_TAB = 3;                                       // How many space for the options
    final static int MENU_LENGTH = 100 - (BOREDR_SYMBOL.length() * 2);      // length of our menu (exluding border length)
                                                                            // because they will be printed later

    public static void showMenu(int type) {
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
    public static void mainMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Main Menu");
        printHorizontalBorder(false);
        printEmptyRow();
        printOption("1" ,"Search Book");
        printOption("2" ,"Add Book");
        printOption("3" ,"Edit Book");
        printOption("4" ,"Delete Book");
        printEmptyRow();
        printOption("-1" ,"Exit");
        printEmptyRow();
        printHorizontalBorder(true);
    }

    // search book's menu
    public static void searchBookMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Search Book details");
        printHorizontalBorder(false);
        printEmptyRow();
        printOption("1" ,"Search by categories");
        printOption("2" ,"Search by name");
        printEmptyRow();
        printOption("0" , "Main menu");
        printEmptyRow();
        printEmptyRow();
        printHorizontalBorder(true);
    }

    // add book's menu
    public static void cartMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Viewing cart items");
        printHorizontalBorder(true);
    }

    // edit book's menu
    public static void checkOutMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Continuing with checking out the books");
        printHorizontalBorder(false);
        printNewLine();
    }

    // Exit menu
    public static void exitMenu() {
        printNewLine();
        printHorizontalBorder(false);
        printTitle("Thanks for using the program");
        printTitle("Exiting the program");
        printHorizontalBorder(false);
        printNewLine();
    }

    private static void printTitle (String title) {
        printSingleSymbol(false);
        int half = (MENU_LENGTH - title.length()) / 2;
        printContinous(" ", half, false);
        System.out.print(title);
        //print continously the remaining spaces and the border after the initial half and the title is printed
        printContinous(" ", half + (MENU_LENGTH % (half + half + title.length())), false);
        printSingleSymbol(true);
    }

    private static void printOption (String idx, String str) {
        printSingleSymbol(false);
        printContinous(" ", OPTIONS_TAB, false);
        System.out.print(idx + OPTION_SYMBOL);
        System.out.print(str);
        // need to minus with the str, idx option's and it's symbol, and the option's tab length
        int remains = MENU_LENGTH - str.length() - OPTIONS_TAB - OPTION_SYMBOL.length() - idx.length();
        printContinous(" ", remains, false);
        printSingleSymbol(true);
    }

    //printing a line of border based on the length of the menu and the symbol used
    private static void printHorizontalBorder (boolean doubleNewline) {
        printSingleSymbol(false);
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(BOREDR_SYMBOL);
        }
        printSingleSymbol(true);
        if (doubleNewline) printNewLine();
    }

    private static void printEmptyRow() {
        printSingleSymbol(false);
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(" ");
        }
        printSingleSymbol(true);
    }

    private static void printContinous (String str, int size, boolean newline) {
        for (int idx = 0;idx < size;idx++) {
            System.out.print(str);
        }
        if (newline) printNewLine();
    }

    private static void printSingleSymbol(boolean newline) {
        System.out.print(BOREDR_SYMBOL);
        if (newline) printNewLine();
    }

    private static void printNewLine () {
        System.out.println();
    }
}

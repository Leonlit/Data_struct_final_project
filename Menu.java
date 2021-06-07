
public class Menu {
    final static String DEFAULT_SYMBOL = "#";
    final static int BORDER_LENGHT = 2;
    final static int MENU_LENGTH = 100 - (DEFAULT_SYMBOL.length() * 2);
    public static void mainMenu() {
        printHorizontalBorder();
        printEmptyRow();
        printTitle("Main Menu");
        printEmptyRow();
        printEmptyRow();
    }

    private static void printTitle (String title) {
        // extras (When got more time)
        //GenerateAsciiArt asciiArts = new GenerateAsciiArt(title);
        //asciiArts.printArt(DEFAULT_SYMBOL);
        printSingleSymbol(false);
        int half = (MENU_LENGTH - title.length()) / 2;
        printContinous(" ", half, false);
        System.out.print(title);
        printContinous(" ", half + (MENU_LENGTH % (half + half + title.length())), false);
        printSingleSymbol(true);
    }

    private static void printOption (String str) {

    }

    private static void printHorizontalBorder () {
        printSingleSymbol(false);
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(DEFAULT_SYMBOL);
        }
        printSingleSymbol(true);
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
        if (newline) System.out.println();
    }

    private static void printSingleSymbol(boolean newline) {
        System.out.print(DEFAULT_SYMBOL);
        if (newline) System.out.println();
    }
}

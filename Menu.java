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
        GenerateAsciiArt asciiArts = new GenerateAsciiArt(title);
        asciiArts.printArt(DEFAULT_SYMBOL);
    }

    private static void printHorizontalBorder () {
        printSingleSymbol();
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(DEFAULT_SYMBOL);
        }
        printSingleSymbol();
        System.out.println();
    }

    private static void printEmptyRow() {
        printSingleSymbol();
        for (int idx = 0; idx < MENU_LENGTH; idx++) {
            System.out.print(" ");
        }
        printSingleSymbol();
        System.out.println();
    }

    private static void printSingleSymbol() {
        System.out.print(DEFAULT_SYMBOL);
    }
}

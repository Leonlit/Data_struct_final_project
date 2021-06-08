public class Library {
    public static void main(String[] args) {
        Menu.mainMenu();
        Menu.searchBookMenu();
        Menu.cartMenu();
        Menu.checkOutMenu();
        Menu.exitMenu();
        //startEventLoop();
    }

    static void startEventLoop () {
        int choosed = 0;
        while (choosed != -1) {
            Menu.showMenu(choosed);
            System.out.println("Please Choose an option :");
            choosed = InputUtil.getInteger(false);
            Executer.executeOption(choosed);
            choosed = 0;
        }

        Menu.exitMenu();
    }
}

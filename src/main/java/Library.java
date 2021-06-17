public class Library {
    static Book books[] = DataGenerator.generateBooks();
    public static void main(String[] args) {
        Menu.mainMenu();
        Menu.searchBookMenu();
        Menu.cartMenu();
        Menu.checkOutMenu();
        Menu.exitMenu();
        //startEventLoop();
        BookViewer viewer = new BookViewer(books[0]);
        viewer.showInfo();
        viewer.historyInfo();
        viewer.waitingListInfo();
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

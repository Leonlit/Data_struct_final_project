public class Library {
    static Book books[] = DataGenerator.generateBooks();
    public static void main(String[] args) {
        startEventLoop();
    }

    static void startEventLoop () {
        while (true) {
            int choosed = 0;
            Menu.mainMenu();
            choosed = InputUtil.getInteger(false);
            Executer.executeOption(choosed);
            if (choosed == -1) 
                break;
        }
        Menu.exitMenu();
    }
}

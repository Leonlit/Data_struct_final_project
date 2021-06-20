public class Library {
    static Book books[] = DataGenerator.generateBooks();
    static Cart cart = new Cart();
    static String username = DataGenerator.generateName();
    public static void main(String[] args) {
        //startEventLoop();
//        String[] test = new String[]{"test", "test2", "test3", "test4"};
//        WaitingList temp = new WaitingList(test);
//        System.out.println(temp.deQueue());
//        System.out.println(temp.deQueue());
//        System.out.println(temp.deQueue());
//        temp.displayQueue();
        RecommendBook test = new RecommendBook();
        //test.calculateCost(41774, 10568);
        System.out.println(test.calculateCost(41774, 10568));
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

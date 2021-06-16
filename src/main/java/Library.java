public class Library {
    public static void main(String[] args) {
        Menu.mainMenu();
        Menu.searchBookMenu();
        Menu.cartMenu();
        Menu.checkOutMenu();
        Menu.exitMenu();
        //startEventLoop();
        WaitingList waitingList = new WaitingList();
        waitingList.enQueue(111111);
        waitingList.enQueue(222222);
        waitingList.enQueue(333333);
        waitingList.enQueue(444444);
        waitingList.enQueue(555555);
        waitingList.enQueue(666666);
        waitingList.enQueue(777777);
        waitingList.enQueue(888888);
        waitingList.enQueue(9999999);
        waitingList.enQueue(1111111);
        System.out.println(waitingList.deQueue());
        System.out.println(waitingList.deQueue());
        System.out.println(waitingList.deQueue());
        waitingList.enQueue(444444);
        waitingList.enQueue(555555);
        waitingList.enQueue(666666);
        waitingList.display();
        Book books[] = DataGenerator.generateBooks();
        BookViewer viewer = new BookViewer(books[0]);
        //viewer.showInfo();
        //viewer.historyInfo();
        //viewer.waitingListInfo();
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

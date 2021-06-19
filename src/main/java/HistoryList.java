public class HistoryList {
    private Node head;
    private int size;
    Node temp;

    public Node getHead () {
        return this.head;
    }
    
    public Node getLast () {
        if (isHeadNull()) {
            warningNullParam();
            return null;
        }else {
            Node current = this.head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            return current;
        }
    }

    public boolean isHeadNull() {
        return this.head == null;
    }

    //adding a node to the last position of the list
    public void pushNode (String[] newNode) {
        if (newNode != null) {
            temp = new Node(newNode);
            if (isHeadNull()) {
                this.head = temp;
            }else {
                Node current = this.head;
                while (current.getNextNode() != null) {
                    current = current.getNextNode();
                }
                current.setNextNode(temp);
            }
            this.size++;
        }else {
            warningNullParam();
        }
    }

    //printing out the linkedlist in a customized way
    public void printList() {
        if (!isHeadNull()) {
            System.out.println(toString());
        }
    }

    public int getSize () {
        return this.size;
    }

    private void warningNullParam () {
        System.out.println("Warning, The value given into the method is null!");
    }

    //overriding the toString() method
    public String[][] getAll () {
        String list[][] = new String[size][2];
        int idx = 0;
        if (!isHeadNull()) {
            Node current = this.head;
            while (current != null) {
                String temp[] = current.getValue();
                list[idx] = temp;
                current = current.getNextNode();
                idx++;
            }
        }
        return list;
    }
}

class Node{
    private Node next;
    private String[] value;

    public Node (String[] value) {
        this.value = value;
    }

    public Node (Node next, String[] value) {
        this.next = next;
        this.value = value;
    }

    public Node getNextNode() {
        return this.next;
    }

    public String[] getValue() {
        return this.value;
    }

    public void setNextNode (Node newNode) {
        this.next = newNode;
    }

    public void updateValue (String[] newValue) {
        this.value = newValue;
    }
}
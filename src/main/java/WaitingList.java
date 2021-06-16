import java.util.*;

//cart using queue concept to act as a cart to store book ID
//that the user want to borrow.
public class WaitingList {
    private int maxSize = 10;
    private String[] list;
    private int rear = -1, front = -1;
    
    public WaitingList(String[] list) {
        this.list = new String[list.length];
        for (int idx = 0;idx < list.length;idx++) {
            this.enQueue(list[idx]);
        }
    }
    
    // check if the queue is full
    public boolean isFull(){
        return ((front == 0 && rear == maxSize - 1) ||
      (rear == (front - 1) % (maxSize - 1)));
    }
    
    // check if the queue is empty
    public boolean isEmpty(){
        return front == -1  ;
    }
    
    // Adding an element (no return)
    public void enQueue ( String element){
        if (isFull()){
            System.out.println("Waiting List is full ");
        //if the queue is empty we need to initialize the front and rear back
        }else if (isEmpty()) {
            front = 0;
            rear = 0;
        //if the rear previously is the last index, change
        //it to the first index (0)
        }else if (rear == maxSize - 1 && front != 0) {
            rear = 0;
        //else increase rear as usual
        }else {
            rear = rear + 1;
        }
        list[rear] = element;
    }
    
     //Removing element
    public void deQueue(){
        String element;
        if (isEmpty()){
            Menu.printTextContent( "Waiting List is empty" );
        }
        
        element = list[front];
        
        //after taking the element, if front and rear same index
        //reinitialize everything
        if(front == rear){
            front = -1;
            rear = -1;
        //while if the front is still not the same index as the
        //rear and it's at the end of the end of array, we set the
        //front to the first index for next dequeue
        } else if(front == maxSize - 1){
            front = 0;
        //else increase front index normally for next dequeue
        }else{
            front = front + 1;
        }
        Menu.printMessage("Dequeued " + element + " from the waiting list");
    }
    
     // display the circular queue
    void displayQueue() {
        if (isEmpty()) {
            Menu.printTextContent("Waiting List is empty");
        } else {
            if (rear >= front) {
                //if the index has not become a loop print them normally
                for (int idx = front;idx <= rear;idx++) {
                    Menu.printOrderedOption(Integer.toString(idx + 1), list[idx]);
                }
            }else {
                for (int idx = front;idx < maxSize;idx++) {
                    Menu.printOrderedOption(Integer.toString(idx + 1), list[idx]);
                }
                
                for (int idx = 0;idx <= rear;idx++) {
                    Menu.printOrderedOption(Integer.toString(idx + 1), list[idx]);
                }
            }
        }
    }
}
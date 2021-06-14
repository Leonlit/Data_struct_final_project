import java.util.*;

//cart using queue concept to act as a cart to store book ID
//that the user want to borrow.
public class WaitingList {
    private int maxSize = 10;
    private int[] list;
    private int rear = -1, front = -1;
    
    WaitingList() {
        list = new int[maxSize];
    }
    
    // check if the queue is full
    boolean isFull(){
        return ((front == 0 && rear == maxSize - 1) ||
      (rear == (front - 1) % (maxSize - 1)));
    }
    
    // check if the queue is empty
    boolean isEmpty(){
        return front == -1  ;
    }
    
    // Adding an element (no return)
    void enQueue ( int element){
        if (isFull()){
            System.out.println(" Queue is full ");
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
    int deQueue(){
        int element;
        if (isEmpty()){
            System.out.println( "Queue is empty" );
            return -1;
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
        return element;
    }
    
     // display the circular queue
    void display() {
        if (isEmpty()) {
            Menu.printTitle("list is empty");
        } else {
            Menu.printTitle("The element on the Queue are:- ");
            Menu.printMessage(Arrays.toString(list));
        }
    }
}
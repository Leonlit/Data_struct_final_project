/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author leonlit
 */

//cart using queue concept
public class Cart {
    private int maxSize;
    private int rear = -1;
    private int front = -1;
    private int borrower[];
    
    Cart(int maxSize) {
        this.maxSize = maxSize;
        this.borrower = new int[maxSize];
    }
    
    // check if the queue is full
    boolean isFull(){
        if (front == 0 && rear == maxSize - 1){
            return true;
        }
        if (front == rear +1 ){
            return true;
        }
        return false;
    }
    
    // check if the queue is empty
    boolean isEmpty(){
        if (front == -1)
            return true;
        else
            return false;
    }
    
    // Adding an element (no return)
    void enQueue ( int element){
        if ( isFull()){
            System.out.println(" Queue is full ");
        } 
        else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % maxSize ;
            borrower[rear] = element;
            System.out.println(   element);
        }
    }
    
     //Removing element
    int deQueue(){
        int element;
        if (isEmpty()){
            System.out.println( "Queue is empty" );
            return (-1);
        } else {
            element = borrower[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % maxSize;
            }
            return (element);
        }
    }
    
    
     // display the circular queue
    void display() {
       
        if (isEmpty()) {
            System.out.println( "Queue is empty" );
            } else {
            
        
            System.out.println("The element on the Queue are:- ");
        for(int i=0; i<maxSize ; i++)
        {
            if(front != rear)
            {
                System.out.println(borrower[front]);
                front = (front + 1) % maxSize;
            }
            else
            {
                System.out.println(borrower[rear]);
                break;
            }
        }
        }
    }
}
    
//    public static void main(String[] args) {
//         // get user input  
//    Scanner input = new Scanner(System.in);
//    System.out.print("Enter total no of elements to be in the queue:- ");
//    int maxSize = input.nextInt();
//    
//    CircularQueue3 queue = new CircularQueue3(maxSize);
//    int select;
//    int term = 0;
//    while (term == 0)
//    {
//        System.out.print("\nOption:\tTo Do:\n1\tTo insert StudentID.\n2\tTo delete StudentID.\n3\tTo Display the Waiting List.\n4\tTo Exit.\nEnter your option:- ");
//                select = input.nextInt(); 
//        switch(select)
//        {
//            case 1:
//            {
//                System.out.print("Enter ID to insert in the Queue:- ");
//                int ele = input.nextInt();
//                queue.enQueue(ele); 
//                break;
//            }
//            case 2:
//            {
//                queue.deQueue();
//                break;
//            }
//            case 3:
//            {
//                queue.display();
//                break;
//            }
//            case 4:
//            {
//                term = 1;
//                System.out.println("Thank you!");
//                break;
//            }
//            default:
//                System.out.println("Enter a valid options");
//        }
//    }
//       
//    }
//    
//}

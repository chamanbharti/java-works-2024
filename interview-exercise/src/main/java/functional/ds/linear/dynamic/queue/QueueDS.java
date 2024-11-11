package functional.ds.linear.dynamic.queue;

import java.util.NoSuchElementException;

public class QueueDS {
    private Node front;
    private Node rear;
    private int length;
    public QueueDS(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public void enqueue(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            front = temp;
        }else{
            rear.next = temp;
        }
        rear = temp;
        length++;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty!");
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }
    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty!");
        }
        return front.data;
    }
    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty!");
        }
        return rear.data;
    }
    public void display(){
        if(isEmpty()){
            return;
        }
        Node current = front;
        while (current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        QueueDS queue = new QueueDS();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        System.out.println("before dequeue");
        queue.display();
        System.out.println("first data:"+queue.first());
        System.out.println("last data:"+queue.last());
        queue.dequeue();
        queue.dequeue();

        System.out.println("after dequeue");
        queue.display();
    }
}

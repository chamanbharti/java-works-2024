package functional.ds.linear.dynamic.linkedlist.doubly;

import java.util.NoSuchElementException;

public class DoubleLinkedList {
    private Node head;
    private int data;
    private Node tail;
    private int length;
    private class Node{
        private Node previous;
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return length == 0;// head == null
    }
    public int length(){
        return length;
    }
    public void displayForward(){
        if (head == null){
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward(){
        if (tail == null){
            return;
        }
        Node temp = tail;
        while (temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertAtFirst(int data){
        Node node = new Node(data);
        if(isEmpty()){
            tail = node;
        }else {
            head.previous = node;
        }
        node.next = head;
        head = node;
        length++;
    }
    public void insertAtLast(int data){
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
        }else {
            tail.next = node;
        }
        node.previous = tail;
        tail = node;
        length++;
    }
    public Node deleteFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("list is empty");
        }
        Node temp = head;
        if(head == tail){
            tail = null;
        }else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
    public Node deleteLast(){
        if (isEmpty()){
            throw new NoSuchElementException("list is empty");
        }
        Node temp = tail;
        if(head == tail){
            head = null;
        }else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        return temp;
    }
}

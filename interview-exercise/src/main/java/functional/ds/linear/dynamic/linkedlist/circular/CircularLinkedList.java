package functional.ds.linear.dynamic.linkedlist.circular;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private Node last;
    private int length;
    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
    }
    public CircularLinkedList(){
        last = null;
        length = 0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }

    public void createCircularLinkedList(){
        Node first = new Node(1);
        Node second = new Node(5);
        Node third = new Node(10);
        Node fourth = new Node(15);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
    }
    public void display(){
        if(last == null){
            return;
        }
        Node first = last.next;
        while (first != last){
            System.out.print(first.data+" ");
            first = first.next;
        }
        System.out.println(first.data+" ");
    }
    public void insertAtFirst(int data){
        Node temp = new Node(data);
        if(last == null){
            last = temp;
        }else{
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }
    public void insertAtLast(int data){
        Node temp = new Node(data);
        if(last == null){
            last = temp;
            last.next = last;
        }else{
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }
    public int removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        }
        Node temp = last.next;
        int result = temp.data;
        if(last.next == last){
            last = null;
        }else{
            last.next = temp.next;
        }
        //temp.next = null;
        length--;
        return result;
    }


    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        //list.createCircularLinkedList();
        list.insertAtFirst(10);
        list.insertAtFirst(15);
        list.insertAtFirst(25);
        list.insertAtLast(1);
        list.insertAtLast(8);
        list.insertAtLast(10);
        list.display();
        list.removeFirst();
        list.display();
    }
}

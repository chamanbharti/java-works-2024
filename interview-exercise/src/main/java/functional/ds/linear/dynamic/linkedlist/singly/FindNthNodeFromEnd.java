package functional.ds.linear.dynamic.linkedlist.singly;

public class FindNthNodeFromEnd {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(15);
        list.insertAtBeginning(11);
        list.insertAtBeginning(1);
        list.insertAtBeginning(8);
        list.insertAtBeginning(10);

        list.display1();
       // Node nthNode = list.getNthNodeFromEnd(2);
        SinglyLinkedList.Node nthNode = list.getNthNodeFromBeginning(1);
        list.display(nthNode);
        System.out.println("Nth node from end is :"+nthNode.data);
    }
}

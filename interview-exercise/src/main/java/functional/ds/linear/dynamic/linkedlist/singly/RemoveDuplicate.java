package functional.ds.linear.dynamic.linkedlist.singly;

public class RemoveDuplicate {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(3);
        list.insertAtBeginning(3);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);
        list.insertAtBeginning(1);

        System.out.println("before removing duplicate sorted list");
        list.display1();
        System.out.println("after removing duplicate sorted list");
        list.removeDuplicates();
        list.display1();
    }
}

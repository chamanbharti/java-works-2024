package functional.ds.linear.dynamic.linkedlist.singly;

public class AddTwoListsSecondInReverseOrder {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(7);
        list.insertAtEnd(4);
        list.insertAtEnd(9);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(5);
        list2.insertAtEnd(6);

        list.display1();
        list2.display1();

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = SinglyLinkedList.addTwoNumberOfList(list.head,list2.head);
        result.display1();

    }
}

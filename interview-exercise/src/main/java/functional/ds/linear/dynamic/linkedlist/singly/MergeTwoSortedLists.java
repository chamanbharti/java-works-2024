package functional.ds.linear.dynamic.linkedlist.singly;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(4);
        list.insertAtEnd(8);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(3);
        list2.insertAtEnd(5);
        list2.insertAtEnd(8);
        list2.insertAtEnd(9);
        list2.insertAtEnd(14);
        list2.insertAtEnd(18);

        list.display1();
        list2.display1();

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = SinglyLinkedList.merge(list.head,list2.head);
        result.display1();

    }
}

package functional.ds.linear.dynamic.linkedlist.singly;

public class SortSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList();
        sList.insertAtEnd(9);
        sList.insertAtEnd(7);
        sList.insertAtEnd(2);
        sList.insertAtEnd(5);
        sList.insertAtEnd(4);

        System.out.println("Original list: ");
        sList.display1();

        sList.sortListByAscending();
        System.out.println("Sorted list in ascending order: ");
        sList.display1();

        sList.sortListByDescending();
        System.out.println("Sorted list in descending order: ");
        sList.display1();

    }
}

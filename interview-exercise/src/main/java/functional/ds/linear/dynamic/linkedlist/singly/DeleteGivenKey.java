package functional.ds.linear.dynamic.linkedlist.singly;

public class DeleteGivenKey {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(16);
        list.insertAtBeginning(10);
        list.insertAtBeginning(8);
        list.insertAtBeginning(12);
        list.display1();
        list.sortListByAscending();
        list.insertInSortedList(11);
        list.display1();
        list.deleteNode(11);
        list.display1();


    }
}

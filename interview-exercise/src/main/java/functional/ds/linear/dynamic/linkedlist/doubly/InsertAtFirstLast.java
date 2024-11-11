package functional.ds.linear.dynamic.linkedlist.doubly;

public class InsertAtFirstLast {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertAtFirst(0);
        dll.insertAtFirst(2);
        dll.insertAtLast(1);
        dll.insertAtLast(10);
        dll.insertAtLast(15);
        dll.insertAtLast(25);
        dll.displayForward();
        dll.displayBackward();
    }
}

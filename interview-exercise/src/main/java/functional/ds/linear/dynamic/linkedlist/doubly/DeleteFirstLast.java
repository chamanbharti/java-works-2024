package functional.ds.linear.dynamic.linkedlist.doubly;

public class DeleteFirstLast {
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

        System.out.println("after deleting first node");
        dll.deleteFirst();
        dll.deleteLast();
        dll.displayForward();


        dll = new DoubleLinkedList();
        dll.insertAtLast(1);
        dll.insertAtLast(10);
        dll.insertAtLast(15);
        System.out.println("before deleteLast");
        dll.displayForward();
        dll.deleteLast();
        System.out.println("after deleteLast");
        dll.displayForward();

    }
}

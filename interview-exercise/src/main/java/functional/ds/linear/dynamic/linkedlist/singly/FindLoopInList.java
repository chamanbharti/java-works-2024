package functional.ds.linear.dynamic.linkedlist.singly;

public class FindLoopInList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.createALoopLinkedList();
        System.out.println(list.containsLoop());
        System.out.println(list.startNodeInLoop().data);
        list.removeLoop();
        list.display1();
        System.out.println(list.containsLoop());
    }
}

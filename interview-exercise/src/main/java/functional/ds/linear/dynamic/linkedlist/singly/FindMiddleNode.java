package functional.ds.linear.dynamic.linkedlist.singly;

public class FindMiddleNode {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtBeginning(15);
        linkedList.insertAtBeginning(18);
        linkedList.insertAtBeginning(11);
        linkedList.insertAtBeginning(1);
        linkedList.insertAtBeginning(8);
        linkedList.insertAtBeginning(10);
        linkedList.display1();
        SinglyLinkedList.Node middleNode = linkedList.findMiddleNode();
        System.out.println("Middle node is - "+middleNode.data);
        linkedList.display(middleNode);
    }
}

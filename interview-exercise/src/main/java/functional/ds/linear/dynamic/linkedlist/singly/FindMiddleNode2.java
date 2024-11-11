package functional.ds.linear.dynamic.linkedlist.singly;

public class FindMiddleNode2 {
    Node head;
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void display(Node head){
        if (head == null){
            System.out.println("list is empty");
        }else{
            Node current = head;
            while (current != null){
                System.out.print(current.data+"-->");
                current = current.next;

            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        FindMiddleNode2 list = new FindMiddleNode2();
        FindMiddleNode2.Node node = new Node(1);
        FindMiddleNode2.Node node2 = new Node(2);
        FindMiddleNode2.Node node3 = new Node(3);

        System.out.println(node);
        list.display(node);
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtBeginning(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtBeginning(4);
        linkedList.insertAtBeginning(5);

    }

}

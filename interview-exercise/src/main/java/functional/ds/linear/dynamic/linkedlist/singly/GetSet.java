package functional.ds.linear.dynamic.linkedlist.singly;

public class GetSet {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(1,3);// 3 --> null
        sll.insert(2,5);// 3 --> 5 --> null
        sll.insert(1,2);// 2 --> 3 --> 5 --> null
        sll.insert(2,4);// 2 --> 4 --> 3 --> 5 --> null
        sll.insert(5,7);// 2 --> 4 --> 3 --> 5 --> 7 --> null
        sll.display1();
        SinglyLinkedList.Node node = sll.getNodeFromGivenIndex(1);
        sll.display(node);
        node = sll.get(1);
        sll.display(node);
        System.out.println(sll.getDataByIndex(1));

        System.out.println(sll.set(4,6));
        sll.display1();
    }
}

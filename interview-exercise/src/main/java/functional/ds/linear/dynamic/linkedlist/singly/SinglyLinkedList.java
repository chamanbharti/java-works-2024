package functional.ds.linear.dynamic.linkedlist.singly;

public class SinglyLinkedList {
   Node head;

    // Integer Type
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    /*
// Generic Type
    private static class Node<T> {
    private T data;
    private Node<T> next;
    public Node(T data){
            this.data = data;
            this.next = null;
        }
   }
   */

    public  void display1(){
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public  void display(Node head){
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                '}';
    }

    public int length(){
        int count = 0;
        Node current = head;
        if(head == null){
            return count;
        }
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public Node deleteAtBeginning(){
        if(head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public Node deleteAtEnd(){
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;//break the chain
        return current;
    }
    public void insert(int position,int data){
        Node newNode = new Node(data);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        }else{
            Node previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }
    public void delete(int position){
        if(position == 1){
            head = head.next;
        }else{
            Node previous = head;
            int count = 1;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = current.next;
        }
    }

    public boolean search1(int data){
        Node current = head;
        if(current == null){
            System.out.println("list is empty");
        }else{
            while (current != null){
                if(current.data == data){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public int search(int data){
        Node current = head;
        int index = 0;
        if(current == null){
            System.out.println("list is empty");
        }else{
            while (current != null){
                if(current.data == data){
                    return index;
                }
                current = current.next;
                index +=1;
            }
        }
        return -1;
    }
    public Node reverse(){
        Node current = head;
        Node previous = null;
        Node next;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public Node findMiddleNode(){
        if(head == null){
            return null;
        }
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr !=null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public boolean containsLoop(){
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr !=null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
    public Node startNodeInLoop(){
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr !=null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    private Node getStartingNode(Node slowPtr){
        Node temp = head;
        while (temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;//starting node of the loop
    }

    public void removeLoop(){
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr !=null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }
    private void removeLoop(Node slowPtr) {
        Node temp = head;
        while (temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public void createALoopLinkedList(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public Node get(int index){// like get(0) as arraylist.get(0)
        if(index < 0 || index >= this.length()) return null;
        Node current = this.head;
        int counter = 0;
        /*
        while (current != null){
            data = current.data;
            if(counter == index){
                break;
            }
            current = current.next;
            counter++;
        }
         */
        while (counter != index){
            current = current.next;
            counter++;
        }
        return current;
    }
    public Node getNodeFromGivenIndex(int index){// like get(0) as arraylist.get(0)
        if(index < 0 || index >= this.length()) return null;
        Node current = this.head;
        int counter = 0;
        while (counter != index){
            current = current.next;
            counter++;
        }
        return current;
    }

    public int getDataByIndex(int index){ // like get(0) as arraylist.get(0)
        if(index < 0 || index >= this.length()) return -1;
        int data = -1;
        int counter = 0;
        Node current = this.head;
        while (counter != index){
            data = current.data;
            current = current.next;
            counter++;
        }
        return data;
    }

    public boolean set(int index, int data){
        Node node = getNodeFromGivenIndex(index);
        if(node != null){
            node.data = data;
            return true;
        }
        return false;
    }

    public Node getNthNodeFromEnd(int n){
        if (head == null){
            return null;
        }
        if (n <= 0){
            throw new IllegalArgumentException("Invalid value: n="+n);
        }
        Node mainPtr = head;
        Node refPtr = head;
        int count = 0;
        while (count < n){
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public Node getNthNodeFromBeginning(int n){
        if (head == null){
            return null;
        }
        if (n <= 0){
            throw new IllegalArgumentException("Invalid value: n="+n);
        }
        Node mainPtr = head;
        Node refPtr = head;
        int count = 0;
        while (count < n){
            mainPtr = mainPtr.next;
            count++;
        }
        while (refPtr != null){
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr;
    }
    // https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/
    public void sortListByAscending(){
        Node current = head;
        Node index;
        int temp;
        if(head == null){
            return;
        }
        while (current != null){
            index = current.next;
           while (index != null){
               if(current.data > index.data){
                   temp = current.data;
                   current.data = index.data;
                   index.data = temp;
               }
               index = index.next;
           }
            current = current.next;
        }
    }

    public void sortListByDescending(){
        Node current = head;
        Node index;
        int temp;
        if(head == null){
            return;
        }
        while (current != null){
            index = current.next;
            while (index != null){
                if(current.data < index.data){
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
    public void removeDuplicates(){
        if (head == null){
            return;
        }
        Node current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }
    public void deleteNode(int key){
        Node current = head;
        Node temp = null;
        if(head == null){
            return;
        }
        while (current!=null && current.data != key){
            temp = current;
            current = current.next;
        }
        temp.next = current.next;
    }

    public Node insertInSortedList(int data){
        Node newNode = new Node(data);
        if(head == null){
            return newNode;
        }
        Node current = head;
        Node temp = null;
        while (current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public Node insertInSortedList2(int data){
        Node newNode = new Node(data);
        if(head == null){
            return newNode;
        }
        Node current = head;
        Node temp = null;
        while (current!=null && current.data< newNode.data){
            temp = current;
            current = current.next;
        }
        if(temp !=null){
            newNode.next = current;
            temp.next = newNode;
        }
        return head;
    }

    public static Node merge(Node a,Node b){
        // a --> 1 --> 3 --> 5 --> null
        // b --> 2 --> 4 --> 6 --> null
        // result 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a !=null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        // a --> 1 --> 3 --> null
        // b --> 2 --> 4 --> 6 --> 7 --> 9 --> 10 null
        // result 1 --> 2 --> 4 --> 6 --> 7 --> 9 --> 10 null
        if(a == null){
            tail.next = b;
        }else {
            tail.next = a;
        }
        return dummy.next;
    }
    public static Node addTwoNumberOfList(Node a,Node b){
        // a --> 1 --> 3 --> 5 --> null
        // b --> 2 --> 4 --> 6 --> null
        // result 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;
        while (a !=null || b != null){
            int x = (a != null)?a.data:0;
            int y = (b != null)?b.data:0;
            int sum = carry+x+y;
            carry = sum/10;
            tail.next=new Node(sum % 10);
            tail = tail.next;

            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        if(carry > 0){
            tail.next = new Node(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        // head is instance variable
        sll.head = new Node(10);
        Node second = new Node(1);
        Node third = new Node(8);
        Node fourth = new Node(11);
        // now we will connect them together to from a chain
        sll.head.next = second;// 10 --> 1
        second.next = third; // 10 --> 1 --> 8
        third.next = fourth; // 10 --> 1 --> 8 --> 11

        System.out.println("printing the list data");
        sll.display(sll.head);
    }
}

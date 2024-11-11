package functional.ds.linear.dynamic.queue;

import functional.ds.linear.dynamic.stack.ArrayStack;
import functional.ds.linear.dynamic.stack.Employee;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        queue = new Employee[capacity];
    }
    public void add(Employee employee){
        if (back == queue.length){
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue,0,newArray,0,queue.length);
            queue = newArray;
        }
        queue[back] = employee;
        back++;
    }
    public Employee remove(){
       if(size() == 0){
           throw new NoSuchElementException();
       }
       Employee employee = queue[front];
       queue[front] = null;
       front++;
       if (size() == 0){
           front = 0;
           back = 0;
       }
       return employee;
    }
    public int size(){
        return back - front;
    }
    public Employee peek(){
        if(size() == 0){
            throw new NoSuchElementException();
        }
        return queue[front];
    }
    public void printQueue(){
        for (int i=front;i<back;i++){
            System.out.println(queue[i]);
        }
    }
    public static boolean checkForPalindrome(String string){
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = string.toLowerCase();
        for(int i=0;i<lowerCase.length();i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.add(new Employee("Rahi","Akela",123));
        queue.add(new Employee("Saima","Rahi",1234));
        queue.add(new Employee("Chaman","Bharti",125));
        queue.add(new Employee("Roshan","Parveen",126));
        queue.add(new Employee("Sahil","Bharti",127));
        System.out.println("peek:"+queue.peek());
       // queue.printQueue();
        queue.remove();
        queue.printQueue();

        System.out.println("check for palindrome");
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, di I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }
}

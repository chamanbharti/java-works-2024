package functional.ds.linear.dynamic.stack;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Employee> stack;
    public LinkedStack(){
        stack = new LinkedList<>();
    }
    public void push(Employee employee){
        stack.push(employee);
    }
    public Employee pop(){
        return stack.pop();
    }
    public Employee peek(){
        return stack.peek();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void printStack(){
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(new Employee("Rahi","Akela",123));
        stack.push(new Employee("Saima","Rahi",1234));
        stack.push(new Employee("Chaman","Bharti",125));
        stack.push(new Employee("Roshan","Parveen",126));
        stack.push(new Employee("Sahil","Bharti",127));
        //stack.printStack();
        System.out.println(stack.peek());
        System.out.println("Popped:"+stack.pop());
        stack.printStack();
    }
}

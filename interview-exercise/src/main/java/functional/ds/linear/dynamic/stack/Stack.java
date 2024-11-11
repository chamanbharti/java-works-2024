package functional.ds.linear.dynamic.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack {
    private Node top;
    private int length;
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public Stack(){
        top = null;
        length = 0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public void push(int data){
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public String reverseString(String str){
        java.util.Stack<Character> stack = new java.util.Stack<>();
        char[] chars = str.toCharArray();
        for(char c:chars){
         stack.push(c);
        }
        for(int i=0;i<str.length();i++){
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
    public int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for(int i= arr.length-1;i>=0;i--){
            if(!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    public static boolean checkForPalindrome(String string){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNotPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();
        for(int i=0;i<lowerCase.length();i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                stringNotPunctuation.append(c);
                stack.push(c);
            }
        }
        StringBuilder reverseString = new StringBuilder(stack.size());
        while (!stack.isEmpty()){
            reverseString.append(stack.pop());
        }
        return reverseString.toString().equals(stringNotPunctuation.toString());
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.reverseString("Chaman"));
        int[] a = stack.nextGreaterElement(new int[]{4,7,3,4,8,1});
        System.out.println(Arrays.toString(a));

        System.out.println("check for palindrome");
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, di I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }
}

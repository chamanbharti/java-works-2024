package functional.ds.nonlinear.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private int data;
        private TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(40);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        root = first; // root --> first
        first.left = second;
        first.right = third;// second<---first--->third
        second.left = fourth;
        second.right = fifth;// fourth <---second--->fifth
        third.left = sixth;
        third.right = seventh;
    }
    public void preOrder(TreeNode root){
        if(root == null){ // base case
           return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrderImperativeWay(){
        if(root == null){ // base case
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }
    public void inOrder(TreeNode root){
        if(root == null){ // base case
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public void inOrderImperativeWay(){
        if(root == null){ // base case
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }
    public void postOrder(TreeNode root){
        if(root == null){ // base case
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public void postOrderImperativeWay(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else {
                    current = temp;
                }

            }
        }
    }
    public void levelOrderTraversal(){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }
    public int findMax(){
        return findMax(root);
    }
    public int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result){
            result = left;
        }
        if(right > result){
            result = right;
        }
        return result;
    }
    public void insert1(int value){
        if(value == root.data){
            return;
        }
        if(value < root.data){
            if(root.left == null){
                root.left = new TreeNode(value);
            }else{
                insert1(value);
            }
        }
    }
    public void insert(int value){
        root = insert(root,value);
    }
    public TreeNode insert(TreeNode root,int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insert(root.left,value);
        }else{
            root.right = insert(root.right,value);
        }
        return root;
    }
    public TreeNode search(TreeNode root,int key){
        if(root == null || root.data == key){
            return root;
        }
        if(key < root.data){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }

    public boolean isValid(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValid(root.left,min,root.data);
        if(left){
            boolean right = isValid(root.right,root.data,max);
            return right;
        }
        return false;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.println("\nPre Order traversal");
        bt.preOrder(bt.root);
        System.out.println("\nPre Order traversal Imperative Way");
        bt.preOrderImperativeWay();

        System.out.println("\nIn Order traversal");
        bt.inOrder(bt.root);
        System.out.println("\nIn Order traversal Imperative Way");
        bt.inOrderImperativeWay();

        System.out.println("\nPost Order traversal");
        bt.postOrder(bt.root);
        System.out.println("\nPost Order traversal Imperative Way");
        bt.postOrderImperativeWay();

        System.out.println("\nLevel Order traversal");
        bt.levelOrderTraversal();

        System.out.println("\nfind max value:"+bt.findMax());

        System.out.println("insert binary tree");
        bt.root = null;
        bt.insert(5);
        bt.insert(3);
        bt.insert(7);
        bt.insert(1);
        System.out.println("\nfind max value:"+bt.findMax());

    }

}

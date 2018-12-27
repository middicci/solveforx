import java.util.*;

public class Tree {
    
    static class Node {
        int data;
        Node left, right;
        Node(int v){
            data = v;
            left = right = null;
        }
    }
    
    void inorder(Node root){
        if(root==null)
            return;
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(curr!= null || s.size()>0){
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.pop();
            System.out.println(curr.data + " ");
            curr = curr.right;
        }
    }
    public static void main(String args[]) {
        Tree t  = new Tree();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.right = new Node(50);
        t.inorder(root);
    }
}

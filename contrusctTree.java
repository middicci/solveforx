
class Node {
        char data;
        Node left, right;
        Node(char item){
            data = item;
            left = right = null;
        }
    }
    
public class BinaryTree {
    
    Node root;
    int preIndex = 0;
    
    Node buildTree(char in[], char pre[], int inStart, int inEnd){
        if (inStart > inEnd) {
            return null;
        }
        
        Node tNode = new Node(pre[preIndex++]);
        
        if(inStart == inEnd)
            return tNode;
            
        int inIndex = search(in, inStart, inEnd, tNode.data);
        
        tNode.left = buildTree(in, pre, inStart, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        
        return tNode;
    }
    
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
        
    } 
    
    int search(char arr[], int inStart, int inEnd, int val){
        
        int i;
        
        for( i=inStart; i<inEnd; i++){
            if(arr[i] == val){
                return i;
            }
        }
        
        return i;
    }
    
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(); 
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
        int len = in.length; 
        Node root = tree.buildTree(in, pre, 0, len - 1); 

        System.out.println("Inorder traversal of constructed tree is : "); 
        tree.printInorder(root);
    }
}

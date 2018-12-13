
 class Node {
        int data;
        Node left, right;
        
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    
 public class Tree {
     
    Node root;
   
    void printLevelOrder(){
        
        int h = height(root);
        
        for( int i=1; i<=h; i++){
            printGivenLevelOrder(root, i);
        }
        
    }
    
    void printGivenLevelOrder(Node root, int l){
        if (root == null)
            return;
        if( l == 1 )
            System.out.println(root.data);
        
        else if(l > 1) {
            printGivenLevelOrder(root.left, l-1);
            printGivenLevelOrder(root.right, l-1);
        }
            
    }
    
    int  height(Node root) {
        if(root == null)
            return 0;
        else {
            int lh = height(root.left);
            int rh = height(root.right);
            if(lh > rh)
                return lh+1;
            else
                return rh+1;
        }
    }
    
    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("print level order");
        tree.printLevelOrder();
    }
}

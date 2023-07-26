import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class PostorderTraversalRecursive {

    static void postOrderTrav(Node root,ArrayList<Integer> postOrder){
        if(root==null){
            return;
        }
        postOrderTrav(root.left,postOrder);
        postOrderTrav(root.right,postOrder);
        postOrder.add(root.data);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrderTrav(root,postOrder);

        System.out.println("Postorder traversal is: ");
        for(int i=0;i<postOrder.size();i++){
           System.out.print(postOrder.get(i)+" "); 
        }

    }
}

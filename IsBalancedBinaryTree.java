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

public class IsBalancedBinaryTree {

    public static int check(Node root){
        if(root == null) return 0;
        int lh = check(root.left);
        if(lh == -1) return -1;
        int rh = check(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh-rh)>1) return -1;

        return Math.max(lh,rh)+1;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(7);
        root.right = new Node(8);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        // root.right.left.left = new Node(3);
        // root.right.left.right = new Node(5);

        if(check(root)==-1){
            System.out.println(false);
        } 
        else{
            System.out.println(true);
        }
    }
}

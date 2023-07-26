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

public class DiameterOfBinaryTree {
    public static int findDiameter(Node root, int diameter[]){
        if(root==null) return 0;
        int lh = findDiameter(root.left, diameter);
        int rh = findDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
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
        int diameter[] = new int[1];
        System.out.println(findDiameter(root,diameter)); 

       
    }
}

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

public class ConstructBinaryTreeUsingPreorderInorder {
    public static Node buildTree(int[] preorder,int[] inorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    public static Node buildTree(int preorder[],int preStart,int preEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);
        int inRoot = map.get(root.data); 
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        root.right = buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
    }
    public static void main(String args[]) {

        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        Node root = buildTree(preorder, inorder);
        // System.out.println(root);
      }
}

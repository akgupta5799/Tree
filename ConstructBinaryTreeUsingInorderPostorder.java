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
public class ConstructBinaryTreeUsingInorderPostorder {
    public static Node buildTree(int[] inorder,int[] postorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }

    public static Node buildTree(int inorder[],int inStart,int inEnd,int postorder[],int postStart,int postEnd,HashMap<Integer,Integer> map){
        if(postStart > postEnd || inStart > inEnd) return null;

        Node root = new Node(postorder[postEnd]);
        int inRoot = map.get(root.data); 
        int numsLeft = inRoot - inStart;
        root.left = buildTree(inorder,inStart,inRoot-1,postorder,postStart,postStart+numsLeft-1,map);
        root.right = buildTree(inorder,inRoot+1,inEnd,postorder,postStart+numsLeft,postEnd-1,map);
        return root;
    }
    public static void main(String args[]) {

        int postorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        Node root = buildTree(inorder,postorder);
        // System.out.println(root);
      }
}

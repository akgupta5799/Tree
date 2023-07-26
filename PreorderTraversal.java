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


public class PreorderTraversal {

    public static ArrayList<Integer> preOrderTrav(Node root){
         ArrayList<Integer> preOrder = new ArrayList<>();
         if(root==null){
            return preOrder;
         }

         Stack<Node> st = new Stack<>();
         st.push(root);

         while(!st.isEmpty()){
            root = st.pop();
            preOrder.add(root.data);
           
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
         }
         return preOrder;

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

        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrder = preOrderTrav(root);

        System.out.println("Preorder traversal is: ");
        for(int i=0;i<preOrder.size();i++){
            System.out.print(preOrder.get(i)+" ");
        }
    }
   

}

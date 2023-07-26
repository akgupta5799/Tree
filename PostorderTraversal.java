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
public class PostorderTraversal {

    static ArrayList<Integer> postOrderTrav(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        if(root==null){
            return postOrder;
        }
        st1.push(root);

        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left!= null){
                st1.push(root.left);
            }
            if(root.right!= null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            postOrder.add(st2.pop().data);
        }

        return postOrder;
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
        postOrder = postOrderTrav(root);
       
        System.out.println("Postorder Traversal is: ");
        for(int i=0;i<postOrder.size();i++){
            System.out.print(postOrder.get(i)+" ");
        }
    }
}

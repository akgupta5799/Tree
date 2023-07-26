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

public class InorderTraversal {

    static ArrayList<Integer> inOrderTrav(Node root){
        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while(true){
            if(root!=null){
                st.push(root);
                root = root.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                root = st.peek();
                inOrder.add(root.data);
                st.pop();
                root = root.right;
            }
        }
        return inOrder;
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

        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder = inOrderTrav(root);
        
        System.out.println("Inorder traversal is: ");
        for(int i=0;i<inOrder.size();i++){
            System.out.print(inOrder.get(i)+" ");
        }

    }
}

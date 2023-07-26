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
class Pair{
    Node node;
    int num;
    public Pair(Node node, int num){
        this.node = node;
        this.num = num;
    }
}
public class AllTraversal {
    public static void  preInPost(Node root, ArrayList<Integer> preOrder,ArrayList<Integer> inOrder,ArrayList<Integer> postOrder){
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root,1));

    if(root==null){
        return;
    }

    while(!st.isEmpty()){
        Pair it = st.pop();

        if(it.num==1){
            preOrder.add(it.node.data);
            it.num++;
            st.push(it);

            if(it.node.left!=null){
                st.push(new Pair(it.node.left,1));
            }
        }
        else if(it.num==2){
            inOrder.add(it.node.data);
            it.num++;
            st.push(it);

            if(it.node.right!=null){
                st.push(new Pair(it.node.right,1));
            }
        }
        else{
            postOrder.add(it.node.data);
        }
    }
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
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        preInPost(root,preOrder,inOrder,postOrder);

        System.out.println("Preorder traversal is: ");
        for(int i:preOrder){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("Inorder traversal is: ");
        for(int i:inOrder){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("Postorder traversal is: ");
        for(int i:postOrder){
            System.out.print(i+" ");
        }
        System.out.println();

    }
    
}

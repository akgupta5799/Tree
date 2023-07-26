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
public class LevelOrderTraversal {

    static ArrayList<Integer> levelOrderTrav(Node root){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> levelOrder = new ArrayList<>(); // For storing level order traversal as in answer.
        
        if(root==null){
            return levelOrder;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            if(queue.peek().left!=null){
                queue.offer(queue.peek().left);
            }
            if(queue.peek().right!=null){
                queue.offer(queue.peek().right);
            }

            levelOrder.add(queue.poll().data);
        }
        return levelOrder;   
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

        ArrayList<Integer> levelOrder = new ArrayList<>();
        levelOrder = levelOrderTrav(root);

        System.out.println("Level order traversal: ");
        for(int i=0;i<levelOrder.size();i++){
            System.out.print(levelOrder.get(i)+" ");
        }
    }
}

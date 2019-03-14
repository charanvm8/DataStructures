package BinaryTree;

public class BinaryTree {

    Node root;

    BinaryTree(){
        this.root = null;
    }

    BinaryTree(int key){
        this.root = new Node(key);
    }


    public static void printPreOrder(Node root){

        if(root == null){
            return;
        }
        printPreOrder(root.left);
        System.out.println(root.x);
        printPreOrder(root.right);
    }

    public static void printPostOrder(Node root){

        if(root == null){
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.x);
    }

    public static void printInOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.x);
        printInOrder(root.left);
        printInOrder(root.right);

    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(10);
        bt.root.right = new Node(30);
        bt.root.left = new Node(20);
        bt.root.left.left = new Node(40);
        bt.root.left.right = new Node(60);

        printPreOrder(bt.root);
        printPostOrder(bt.root);
        printInOrder(bt.root);
    }
}

package BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;

    BinaryTree(){
        this.root = null;
    }

    BinaryTree(int key){
        this.root = new Node(key);
    }


    // Time complexity O(n)
    // Space Complexity O(height of tree)


    public static void printInOrder(Node root){

        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.println(root.x);
        printInOrder(root.right);
    }

    public static void printPostOrder(Node root){

        if(root == null){
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.x);
    }

    public static void printPreOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.x);
        printPreOrder(root.left);
        printPreOrder(root.right);

    }

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftSubTreeHeight = heightOfTree(root.left);
        int rightSubTreeHeight = heightOfTree(root.right);
        return 1+Math.max(leftSubTreeHeight,rightSubTreeHeight);
    }

    public static void printNodesAtK(Node root,int k){
        if(root==null){
            return;
        }

        if(0 == k){
            System.out.println(root.x);
            return;
        }
        else{
            printNodesAtK(root.left,k-1);
            printNodesAtK(root.right,k-1);
        }
    }

    public static void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> nodes = new ArrayDeque();
        nodes.add(root);
        while (nodes.size()>0){
            Node curr = nodes.poll();
            System.out.println(curr.x);
            if(curr.left!=null){
                nodes.add(curr.left);
            }
            if(curr.right!=null){
                nodes.add(curr.right);
            }
        }
    }

    public static void printAfterEachLevel(Node root){
        if(root==null){
            return;
        }
        Queue<Node> nodes = new LinkedList();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            while (size>0){
                Node n = nodes.poll();
                if(n.left!=null){
                    nodes.add(n.left);
                }
                if(n.right!=null){
                    nodes.add(n.right);
                }
                System.out.print(n.x+" ");
                size--;
            }
            System.out.println();
        }
    }

    public static int sizeOfTree(Node root){
        if(root == null){
            return 0;
        }
        return 1+sizeOfTree(root.left)+sizeOfTree(root.right);
    }


    public static int maxInTree(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.x,Math.max(maxInTree(root.left),maxInTree(root.right)));
    }

    //int

    public static void printLeftView(Node root,boolean isLeft){

    }

    public static boolean isChildrenSumTree(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        int total = 0;
        if(root.left!=null){
            total+=root.left.x;
        }
        if(root.right!=null){
            total+=root.right.x;
        }
        if(total!=root.x){
            return false;
        }
        return isChildrenSumTree(root.left) && isChildrenSumTree(root.right);
    }

    public static boolean isBalancedTree(Node root){
        if(root==null){
            return true;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        if(Math.abs(rightHeight-leftHeight)>1){
            return false;
        }
        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    public static int isBalancedTree1(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = isBalancedTree1(root.left);
        int rightHeight = isBalancedTree1(root.right);
        if(leftHeight==-1 || rightHeight==-1){
            return -1;
        }
        if(Math.abs(rightHeight-leftHeight)>1){
            return -1;
        }
        return Math.abs(rightHeight-leftHeight)+1;
    }

    public static int maxWidthOfBinary(Node root){
        if(root==null){
            return 0;
        }
        Queue<Node> nodes = new LinkedList();
        nodes.add(root);
        int res = 0;
        while (!nodes.isEmpty()){
            int size = nodes.size();
            res = Math.max(res,size);
            for(int i=0;i<size;i++){
                Node curr = nodes.poll();
                if(curr.left!=null){
                    nodes.add(curr.left);
                }
                if(curr.right!=null){
                    nodes.add(curr.right);
                }
            }
        }
        return res;
    }

    public static void printTreeInSpiral(Node root){
        if(root==null){
            return;
        }
        Queue<Node> nodes = new LinkedList();
        Stack<Node> nodes1 = new Stack();
        nodes.add(root);
        while (!nodes.isEmpty() || !nodes1.isEmpty()){
            if(!nodes.isEmpty()){
                int size = nodes.size();
                for(int i=0;i<size;i++){
                    Node curr = nodes.poll();
                    if(curr.left!=null){
                        nodes1.push(curr.left);
                    }
                    if(curr.right!=null){
                        nodes1.push(curr.right);
                    }
                    System.out.println(curr.x);
                }
            }
            if(!nodes1.isEmpty()){
                int size = nodes1.size();
                for(int i=0;i<size;i++){
                    Node curr = nodes1.pop();
                    if(curr.left!=null){
                        nodes.add(curr.left);
                    }
                    if(curr.right!=null){
                        nodes.add(curr.right);
                    }
                    System.out.println(curr.x);
                }
            }
        }
    }

    public static int diameterOfTree(Node root){
        if(root==null){
            return 0;
        }
        int currDiameter = 1+heightOfTree(root.left)+heightOfTree(root.right);
        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        return Math.max(currDiameter,Math.max(leftDiameter,rightDiameter));
    }

//    public static int diameterOfTree1(Node root){
//        if(root==null){
//            return 0;
//        }
//
//    }

    public static Node leastCommonAncestor(Node root,int first,int second){
        Stack<Node> firstPath = new Stack();
        findPath(root,first,firstPath);
        while (!firstPath.isEmpty()){
            System.out.println(firstPath.pop().x);
        }
        return root;
    }

    public static Node findPath(Node root,int any,Stack<Node> ref){
        if(root==null){
            return null;
        }
        if(root.x==any){
            ref.push(root);
            return root;
        }
        Node left = findPath(root.left,any,ref);
        if(left!=null){
            ref.push(root);
            return root;
        }
        Node right = findPath(root.right,any,ref);
        if(right!=null){
            ref.push(root);
            return root;
        }
        return null;
    }




    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(10);
        bt.root.right = new Node(30);
        bt.root.left = new Node(20);
        bt.root.left.left = new Node(40);
        bt.root.left.left.right = new Node(120);
        bt.root.left.left.left = new Node(70);
        bt.root.left.right = new Node(60);
        bt.root.left.right.left = new Node(150);
//
////        printPreOrder(bt.root);
////        printPostOrder(bt.root);
////        printInOrder(bt.root);
////        System.out.println(heightOfTree(bt.root));
////        printAfterEachLevel(bt.root);
////        System.out.println(maxInTree(bt.root));
////        printLeftView(bt.root,true);
////        System.out.println(maxWidthOfBinary(bt.root));
////        printTreeInSpiral(bt.root);
//        System.out.println(diameterOfTree(bt.root));

        Node res = leastCommonAncestor(bt.root,150,30);
    }

}

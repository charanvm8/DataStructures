package geeksForGeeks.dataStructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    // Tree traversal are of two types 1) Depth first Search 2) Breadth first Search
    // Depth first Search is of 3 types
    // 1) Inorder
    // 2) PostOrder
    // 3) PreOrder

    // DFS
    public static void preOrder(Node n){
        if(n == null){
            return;
        }

        System.out.print(n.value+" ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void postOrder(Node n){
        if(n == null){
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.value+" ");
    }

    public static void inOrder(Node n){
        if(n == null){
            return;
        }
        inOrder(n.left);
        System.out.print(n.value+" ");
        inOrder(n.right);
    }

    // BFS

    public static void levelOrder(Node n){
        if(n==null){
            return;
        }
        Queue<Node> items = new LinkedList<Node>();
        items.add(n);
        while(!items.isEmpty()){
            Node pres = items.poll();
            System.out.print(pres.value+" ");
            if(pres.left!=null){
                items.add(pres.left);
            }
            if(pres.right!=null){
                items.add(pres.right);
            }
        }
    }
}

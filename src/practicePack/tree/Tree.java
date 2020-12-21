package practicePack.tree;

import java.util.*;

public class Tree {

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }

    public static void printAt(Node root,int levelAt){
        if(root==null){
            return;
        }
        if(levelAt == 0){
            System.out.println(root.val);
        }
        else{
            printAt(root.left,levelAt-1);
            printAt(root.right,levelAt-1);
        }
    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> currQueue = new LinkedList<>();
        currQueue.add(root);
        while (!currQueue.isEmpty()){
            Node n = currQueue.poll();
            System.out.println(n.val);
            if(n.left!=null){
                currQueue.add(n.left);
            }
            if(n.right!=null){
                currQueue.add(n.right);
            }
        }
    }

    public static int sizeOfBinary(Node root){
        if(root == null){
            return 0;
        }
        return 1+sizeOfBinary(root.left)+sizeOfBinary(root.right);
    }

    public static int maxInBinary(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val,Math.max(maxInBinary(root.left),maxInBinary(root.right)));
    }

    public static void printLeftView(Node root,boolean isLeft){
        if(root == null){
            return;
        }
        if(isLeft){
            System.out.println(root.val);
        }
        printLeftView(root.left,true);
        printLeftView(root.right,false);
    }

    static int level = 0;
    public static void printLeftView1(Node root,int currLevel){
        if(root == null){
            return;
        }
        if(level<currLevel){
            System.out.println(root.val);
            level++;
        }
        printLeftView1(root.left,currLevel+1);
        printLeftView1(root.right,currLevel+1);
    }

    public static boolean childrenSum(Node root){
        if(root==null){
            return true;
        }
        if(root.left ==null && root.right==null){
            return true;
        }
        int childrenSum = 0;
        if(root.left!=null){
            childrenSum+=root.left.val;
        }
        if(root.right!=null){
            childrenSum+=root.right.val;
        }
        return root.val==childrenSum && childrenSum(root.left) && childrenSum(root.right);
    }

    public static boolean checkForBalancedTree(Node root){
        if(root==null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(rightHeight-leftHeight)<=1 && checkForBalancedTree(root.left) && checkForBalancedTree(root.right);
    }

//    public static boolean checkForBalanced(Node root){
//
//    }

    public static int maxWidth(Node root){
        if(root==null){
            return 0;
        }
        int max_width = 1;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int currLevelSize = nodes.size();
            max_width = Math.max(max_width,currLevelSize);
            for(int i=0;i<currLevelSize;i++){
                Node currNode = nodes.poll();
                if(currNode.left!=null){
                    nodes.add(currNode.left);
                }
                if(currNode.right!=null){
                    nodes.add(currNode.right);
                }
            }
        }
        return max_width;
    }

    static Node prev = null;
    public static Node dll(Node root){
        if(root==null){
            return root;
        }
        Node leftNode = dll(root.left);
        if(prev==null){
            leftNode = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        dll(root.right);
        return leftNode;
    }

    public static void treeTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        Stack<Node> reverseNodes = new Stack<>();
        nodes.add(root);
        boolean isReverse = true;
        while (!nodes.isEmpty() || !reverseNodes.isEmpty()){
            if(isReverse){
                for(int i=0;i<nodes.size();){
                    Node currNode = nodes.poll();
                    System.out.println(currNode.val);
                    if(currNode.left!=null){
                        reverseNodes.push(currNode.left);
                    }
                    if(currNode.right!=null){
                        reverseNodes.push(currNode.right);
                    }
                }
                isReverse = false;
            }
            else{
                for(int i=0;i<reverseNodes.size();){
                    Node currNode = reverseNodes.pop();
                    System.out.println(currNode.val);
                    if(currNode.left!=null){
                        nodes.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        nodes.add(currNode.right);
                    }
                }
                isReverse = true;
            }
        }
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diameter = 1+leftHeight+rightHeight;
        return Math.max(diameter,Math.max(diameter(root.left),diameter(root.right)));
    }

    static Map<Node,Integer> nodes = new HashMap<>();
    public static int diameter1(Node root){
        if(root == null ){
            return 0;
        }
        int leftheight = diameter(root.left);
        int rightHeight = diameter(root.right);
        nodes.put(root,leftheight+rightHeight+1);
        return 1+Math.max(leftheight,rightHeight);
    }

    static int diameter = Integer.MIN_VALUE;
    public static int diameter3(Node root){
        if(root == null ) {
            return 0;
        }
        int leftHeight = diameter3(root.left);
        int rightHeight = diameter3(root.right);
        diameter = Math.max(diameter,1+leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }

    static Node temp = null;
    public static Node LCA(Node root,int leaf1, int leaf2){
        if(root == null){
            return null;
        }
        Node left = LCA(root.left,leaf1,leaf2);
        Node right = LCA(root.right,leaf1,leaf2);
        if(root.val == leaf1 || root.val == leaf2){
            return root;
        }
        if(left!=null && right!=null){
            temp = root;
            return root;
        }
        else if(left!=null){
            return left;
        }
        else if(right!=null){
            return right;
        }
        else{
            return temp;
        }
    }

    static int time = -1;
    public static int burnTree(Node n,int burnFrom){
        if(n==null){
            return -1;
        }
        int left = burnTree(n.left,burnFrom);
        if(n.val==burnFrom){
            return 0;
        }
        int right = burnTree(n.right,burnFrom);
        time = Math.max(time,1+Math.max(left,right));
        return 1+Math.max(left,right);
    }

    static int pre =0;
    public static Node createBT(int[] inOrder,int[] preOrder,int start,int end){
        if(start>end){
            return null;
        }
        Node root = new Node(preOrder[pre++]);
        int currIndex = -1;
        for(int i=start;i<end;i++){
            if(inOrder[i]==root.val){
                currIndex = i;
                break;
            }
        }
        root.left = createBT(inOrder,preOrder,start,currIndex-1);
        root.right = createBT(inOrder,preOrder,currIndex+1,start);
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(40);
//        Node resultRoot = dll(root);
//        System.out.println(resultRoot.right.right.val);
//        treeTraversal(root);
//        System.out.println(diameter3(root));
        Node temp = LCA(root,50,20);
        System.out.println(temp.val);

        int[] arr = new int[10];

    }
}

package practicePack.bst;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class BinarySearch {

    // Complete these functions
    public static Node search(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        else if(root.left!=null){
            return search(root.left,val);
        }
        else{
            return search(root.right,val);
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(val>root.val){
            root.right = insert(root.right,val);
        }
        else if(val<root.val){
            root.left = insert(root.left,val);
        }
        return root;
    }

    public static Node delete(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.val>val){
            root.left = delete(root.left,val);
        }
        else if(root.val<val){
            root.right = delete(root.right,val);
        }
        else{
            Node nextLargest =  getLastLeft(root.right);
            if(nextLargest == null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                nextLargest.left = root.left.right;
                return root.left;
            }
        }
        return root;
    }

    static Node getLastLeft(Node root){
        Node prev = null;
        while (root!=null){
            prev = root;
            root = root.left;
        }
        return prev;
    }


    public static Node floor(Node root, int val){
        Node res = null;
        if(root == null){
            return res;
        }
        res = root;
        while (root!=null){
            if(root.val == val){
                return root;
            }
            else if(root.val>val){
                return root.left;
            }
            else{
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    public static Node ceil(Node root, int val){
        Node res = null;
        while (root!=null){
            if(root.val == val){
                return root;
            }
            else if(root.val>val){
                res = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }

    public static void ceilingOnLeftSide(int[] arr){
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            treeSet.add(arr[i]);
            System.out.println(treeSet.higher(arr[i])+" ");
        }
    }


    public static boolean checkForPair(Node root,int[] pair){
        int total = pair[0]+pair[1];
        checkForPair1(root,pair,total);
        return total==0;
    }

    public static void checkForPair1(Node root,int[] pair,int total){
        if(root == null){
            return;
        }
        if(total == 0){
            return;
        }
        if(root.val == pair[0] || root.val == pair[1]){
            total -= root.val;
        }
        checkForPair1(root.left,pair,total);
        checkForPair1(root.right,pair,total);
    }

    public static boolean checkForBST(Node root,int leftRange,int rightRange){
        if(root == null){
            return true;
        }
        return root.val>leftRange &&
                root.val<rightRange &&
                checkForBST(root.left,leftRange,root.val) &&
                checkForBST(root.right,root.val,rightRange);
    }

    static int prev = Integer.MIN_VALUE;
    public static boolean checkForBST1(Node root){
        if(root==null){
            return true;
        }
        if(checkForBST1(root.left)==false)return false;
        if(root.val<=prev){
            return false;
        }
        prev = root.val;
        return checkForBST1(root.right);
    }

//    public static Node swapTwoNodes(Node root){
//        Node swapNode1 = null;
//        Node swapNode2 = null;
//        int prev = Integer.MIN_VALUE;
//        swapNodes(root,swapNode1,swapNode2,prev);
//        int temp = swapNode1.val;
//        swapNode1.val = swapNode2.val;
//        swapNode2.val = temp;
//        return root;
//    }
//
//    public static void swapNodes(Node root,Node swapNode1,Node swapNode2,int prev){
//        if(root==null){
//            return;
//        }
//        swapNodes(root.left,swapNode1,swapNode2,prev);
//        if(root.val<=prev){
//            if(swapNode1==null){
//                swapNode1 = root;
//            }
//            else{
//                swapNode2 = root;
//                return;
//            }
//        }
//        prev = root.val;
//        swapNodes(root.left,swapNode1,swapNode2,prev);
//    }

    public static boolean pair(Node root,int[] pair){
        Set<Integer> vals = new HashSet<>();
        int target = pair[0]+pair[1];
        return checkForPairs(root,vals,target);
    }

    public static boolean checkForPairs(Node root,Set<Integer> vals,int target){
        if(root == null){
            return false;
        }
        checkForPairs(root.left,vals,target);
        if(vals.contains(target-root.val)){
            return true;
        }
        vals.add(root.val);
        return checkForPairs(root.right,vals,target);
    }

    public static void verticalSum(Node root){
        TreeMap<Integer,Integer> values = new TreeMap<>();
        verticalSumAssign(root,0,values);
        for(Map.Entry<Integer,Integer> entry:values.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void verticalSumAssign(Node root,int currIndex,TreeMap<Integer,Integer> values){
        if(root==null){
            return;
        }
        verticalSumAssign(root.left,currIndex-1,values);
        if(values.containsKey(currIndex)){
            values.put(currIndex,values.get(currIndex)+root.val);
        }
        else{
            values.put(currIndex,root.val);
        }

        verticalSumAssign(root.right,currIndex+1,values);
    }

    public static void verticalTraversal(Node root){
        TreeMap<Integer,ArrayList<Node>> values = new TreeMap<>();
        verticalTraversalAssign(root,0,values);
        for(Map.Entry<Integer,ArrayList<Node>> entry:values.entrySet()){
            ArrayList<Node> nodes = entry.getValue();
            nodes.forEach(node-> System.out.print(node.val+" "));
            System.out.println();
        }
    }

    public static void verticalTraversalAssign(Node root,int currIndex,TreeMap<Integer,ArrayList<Node>> values){
        if(root==null){
            return;
        }
        if(!values.containsKey(currIndex)){
            values.put(currIndex,new ArrayList<>());

        }
        values.get(currIndex).add(root);
        verticalTraversalAssign(root.left,currIndex-1,values);
        verticalTraversalAssign(root.right,currIndex+1,values);
    }


    public static void main(String[] args) {

//        TreeSet<Integer> tree = new TreeSet<>();
//        tree.add(2);
//        tree.add(5);
//        tree.add(10);
//        tree.add(15);
//        System.out.println(tree.contains(5));
//        System.out.println(tree.higher(5));

//        int[] arr = {30,20,10};
//        ceilingOnLeftSide(arr);

        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
//        root.right.left = new Node(11);
//        root.right.right = new Node(30);
//        root.right.right.right = new Node(25);
        verticalTraversal(root);

    }
}

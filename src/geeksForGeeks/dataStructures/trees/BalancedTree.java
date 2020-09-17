package geeksForGeeks.dataStructures.trees;

public class BalancedTree {

    // Time complexity O(N^2)
    public static boolean checkForBalancedTreeRec(Node n){
        if(n==null){
            return true;
        }
        int leftHeight = SizeHeightAndKDistance.height(n.left);
        int rightHeight = SizeHeightAndKDistance.height(n.right);
        return Math.abs(leftHeight-rightHeight)<=1 && checkForBalancedTreeRec(n.left) && checkForBalancedTreeRec(n.right);
    }

    // Time complexity O(N)
    public static int checkForBalancedTree(Node n){
        if(n==null){
            return 0;
        }
        int leftHeight = checkForBalancedTree(n.left);
        if(leftHeight==-1){
            return -1;
        }
        int rightHeight = checkForBalancedTree(n.right);
        if(rightHeight==-1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}

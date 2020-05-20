package geeksForGeeks.dataStructures.trees;

public class ChildrenSum {

    public static boolean checkIfChildrenSum(Node n){
        if(n==null){
            return true;
        }

        if(n.left==null && n.right==null){
            return true;
        }
        int leftSum = 0;
        int rightSum = 0;
        if(n.left!=null){
            leftSum = n.left.value;
        }
        if(n.right!=null){
            rightSum = n.right.value;
        }
        if(n.value!=(leftSum+rightSum)){
            return false;
        }
        else{
            return checkIfChildrenSum(n.left) && checkIfChildrenSum(n.right);
        }
    }
}

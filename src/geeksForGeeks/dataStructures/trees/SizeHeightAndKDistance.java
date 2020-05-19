package geeksForGeeks.dataStructures.trees;

public class SizeHeightAndKDistance {

    public static int size(Node n){
        if(n==null){
            return 0;
        }
        return 1+size(n.left)+size(n.right);
    }

    public static int max(Node n){
        if(n==null){
            return 0;
        }
        return Math.max(n.value,Math.max(max(n.left),max(n.right)));
    }

    public static int height(Node n){
        if(n==null){
            return 0;
        }
        return 1+Math.max(height(n.left),height(n.right));
    }

    public static void printAtLevel(Node n,int level){
        if(n==null){
            return;
        }
        if(level == 0){
            System.out.print(n.value);
        }
        printAtLevel(n.left,level-1);
        printAtLevel(n.right,level-1);
    }
}

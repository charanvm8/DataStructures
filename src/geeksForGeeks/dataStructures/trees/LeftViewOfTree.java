package geeksForGeeks.dataStructures.trees;

public class LeftViewOfTree {

    int topLevel = 0;
    public void printLeftView(Node n){
        getLeftView(n,1);
    }

    public void getLeftView(Node n,int currentLevel){
        if(n==null){
            return;
        }
        if(currentLevel>topLevel){
            System.out.print(n.value+" ");
            this.topLevel+=1;
        }
        getLeftView(n.left,currentLevel+1);
        getLeftView(n.right,currentLevel+1);
    }
}

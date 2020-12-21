package BST;

public class BSTClass {

    Node root;

    BSTClass(){
        this.root = null;
    }

    public void insert(int n){
        if(this.root == null){
            this.root = new Node(n);
            return;
        }
        Node temp = this.root;
        while (temp.left!=null && temp.right!=null){
            if(n<temp.x && temp.left == null){
                temp.left = new Node(n);
                return;
            }
            else if(n>temp.x && temp.right == null){
                temp.right = new Node(n);
                return;
            }
            else if(n<temp.x){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
    }

    public void insertRec(int n){
        if(this.root == null){
            this.root = new Node(n);
            return;
        }

    }

    public static boolean search(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.x==val){
            return true;
        }
        if(val>root.x){
            return search(root.right,val);
        }
        else{
            return search(root.left,val);
        }
    }



    public static boolean search1(Node root,int val){
        Node temp = root;
        while (temp!=null){
            if(temp.x==val){
                return true;
            }
            else if(temp.x<val){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }


}

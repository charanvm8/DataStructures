package geeksForGeeks.dataStructures.trees;

public class TreeImplementation {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
//        TreeTraversal.inOrder(root);
//        System.out.println();
//        TreeTraversal.preOrder(root);
//        System.out.println();
//        TreeTraversal.postOrder(root);
//        System.out.println();
//
//        System.out.println("Size "+SizeHeightAndKDistance.size(root));
//        System.out.println("Height "+SizeHeightAndKDistance.max(root));
//
//        TreeTraversal.levelOrder(root);
//        System.out.println();
//        System.out.println("Left View");
//        LeftViewOfTree ll = new LeftViewOfTree();
//        ll.printLeftView(root);
//        System.out.println();
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(20);
        BinaryTreeDLL  ll = new BinaryTreeDLL();
        Node q = ll.flattenBinaryTree(root);
        System.out.println(q.left.right.value +" "+q.right.left.value);

    }
}

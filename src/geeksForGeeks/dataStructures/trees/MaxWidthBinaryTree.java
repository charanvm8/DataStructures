package geeksForGeeks.dataStructures.trees;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {

    //O(N)
    public static int maxWidthOfBinaryTree(Node n){
        if(n==null){
            return 0;
        }
        int maxWidth = 1;
        Queue<Node> items = new LinkedList<>();
        items.add(n);
        while(!items.isEmpty()){
            int size = items.size();
            maxWidth = Math.max(maxWidth,size);
            for(int i=0;i<items.size();i++){
                Node val = items.poll();
                if(val.left!=null){
                    items.add(val.left);
                }
                if(val.right!=null){
                    items.add(val.right);
                }
            }
        }
        return maxWidth;
    }
}

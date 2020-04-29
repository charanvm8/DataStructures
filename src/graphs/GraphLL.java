package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphLL {

    static int size;
    static LinkedList<Integer>[] vertices;

    GraphLL(int v){
        this.size = v;
        vertices = new LinkedList[v];
        for(int i=0;i<v;i++){
            vertices[i] = new LinkedList<>();
        }
    }

    static void addEdge(int i,int j){
        vertices[i].add(j);
        vertices[j].add(i);
    }

    static void BFS(LinkedList<Integer>[] vertices){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] indexes = new boolean[size];
        queue.add(0);
        while(queue.size()>0){
            int val = queue.poll();
            LinkedList ll = vertices[val];
            System.out.println(val);
            indexes[val] = true;
            Iterator il = ll.listIterator();
            while (il.hasNext()){
                int val1 = (Integer) il.next();
                if(!indexes[val1]){
                    queue.add(val1);
                }
            }
        }//
    }



    public static void main(String[] args) {
        GraphLL graphLL = new GraphLL(5);

    }
}

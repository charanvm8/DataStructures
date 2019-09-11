package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphLL {

    static LinkedList<Integer>[] vertices;

    GraphLL(int v){
        vertices = new LinkedList[v];
        for(int i=0;i<v;i++){
            vertices[i] = new LinkedList<>();
        }
    }

    static void addEdge(int i,int j){
        vertices[i].add(j);
        vertices[j].add(i);
    }

    public static void main(String[] args) {
        GraphLL graphLL = new GraphLL(5);

    }
}

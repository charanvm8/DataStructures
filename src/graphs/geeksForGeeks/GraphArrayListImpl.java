package graphs.geeksForGeeks;

import java.util.*;

public class GraphArrayListImpl {

    public static void addEdge(ArrayList<ArrayList<Integer>> values,int currVertex,int targetVertex){
        values.get(currVertex).add(targetVertex);
        values.get(targetVertex).add(currVertex);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print("Vertex "+i+" has these values ");
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print(arr.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void BFS1(ArrayList<ArrayList<Integer>> graph,int root,int size,boolean[] visited){
        Queue<Integer> vertices = new LinkedList<>();
        vertices.add(root);
        visited[0] = true;
        while (!vertices.isEmpty()){
            Integer curr = vertices.poll();
            System.out.println(curr);
            ArrayList<Integer> arr = graph.get(curr);
            for(int z:arr){
                if(!visited[z]){
                    vertices.add(z);
                    visited[z] = true;
                }
            }
        }
    }

    public static int DFS(ArrayList<ArrayList<Integer>> graph,int size){
        boolean[] visited = new boolean[size];
        int counter = 0;
        for(int i=0;i<size;i++){
            if(!visited[i]){
                DFS1(graph,i,visited);
                counter++;
            }
        }
        return counter;
    }

    public static void DFS1(ArrayList<ArrayList<Integer>> graph,int root,boolean[] visited){
        //System.out.println(root);
        visited[root] = true;
        for(Integer i:graph.get(root)){
            if(!visited[i]){
                DFS1(graph,i,visited);
            }
        }
    }




    public static void BFS(ArrayList<ArrayList<Integer>> graph,int root,int size){
        if(size<1){
            return;
        }
        boolean[] visited = new boolean[size];
        BFS1(graph,root,size,visited);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        //addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,2,3);
        //addEdge(graph,2,4);
        //addEdge(graph,3,4);
        addEdge(graph,4,5);
        addEdge(graph,4,6);
        addEdge(graph,5,6);
        printGraph(graph);
        //BFS(graph,0,graph.size());
        System.out.println(DFS(graph,graph.size()));
        Stack<Integer> s =new Stack<>();
        
    }
}


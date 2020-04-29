package graphs.geeksForGeeks;

import java.util.ArrayList;

public class GraphArrayListImpl {

    Node head;

    GraphArrayListImpl(int data,int size){
        head = new Node(data,size);
    }

    private class Node {
        int data;
        ArrayList<Node> nodes;

        Node(int data,int size){
            this.data = data;
            nodes = new ArrayList<>(size);
        }
    }

    public static void main(String[] args) {

    }
}


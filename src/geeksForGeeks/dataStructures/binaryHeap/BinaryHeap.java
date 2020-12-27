package geeksForGeeks.dataStructures.binaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class BinaryHeap {
    int[] elements;
    int size;
    int capacity;

    BinaryHeap(int capacity){
        this.elements = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    int getLeft(int pos){
        return 2*pos+1;
    }

    int getRight(int pos){
        return 2*pos+2;
    }

    int getParent(int pos){
        return (pos-1)/2;
    }

    void insert(int data){
        if(capacity==size){
            return;
        }
        if(size==0){
            elements[size++] = data;
            return;
        }
        elements[this.size++] = data;
        heap(data,this.size-1);
    }

    void heap(int val,int pos){
        int parent = getParent(pos);
        for(int i=pos;this.elements[parent]>val && i>0;){
            this.elements[i] = this.elements[parent];
            this.elements[parent] = val;
            i = parent;
            parent = getParent(parent);
        }
    }

//    void heapify(int )

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(20);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(20);
        queue.add(10);
        System.out.println(queue.peek());
    }

}

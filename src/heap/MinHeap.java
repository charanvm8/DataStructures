package heap;

public class MinHeap {

    int[] arr;
    int size;
    int capacity;

    MinHeap(int capacity){
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    void insert(int val){
        arr[size++] = val;
        int currSize = size-1;
        int parent = this.parent(currSize);
        while (arr[parent]>val){
            int temp = arr[parent];
            arr[parent] = val;
            arr[currSize]=temp;
            currSize = parent;
            parent = this.parent(currSize);
        }
    }

    void delete(int val){

    }



    void printHeap(){
        for(int i:this.arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    boolean search(int val){
        return false;
    }

    int left(int i){
        return (2*1)+1;
    }

    int right(int i){
        return (2*i)+2;
    }

    int parent(int i){
        return (int)Math.floor((i-1)/2);
    }



}

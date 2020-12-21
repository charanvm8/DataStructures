package heap;

public class HeapMain {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(40);
        heap.insert(50);
        heap.insert(100);
        heap.insert(25);
        heap.insert(45);
        heap.insert(12);

        heap.printHeap();
    }
}

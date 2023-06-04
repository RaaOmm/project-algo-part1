/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part I
 */
package GraphFramework;
import java.util.Arrays;
/*
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
 /*
 *class MinHeap
 * each heap has capacity , size 
 * and is composed of nodes
 */
public class MinHeap {

   private int capacity;
    private int size; //The current size
    private Node[] heap;

   
     // Default Constructor for the MinHeap class.
    
    public MinHeap(int capacity) {
        this.capacity=capacity;
        heap =new Node[capacity];
        size=0;
    }

// ---------------- Getter and Setter Methods ------------------

    public int getSize() {
        return size;
    }

    public Node[] getHeap() {
        return heap;
    }

    public void setHeap(Node[] heap) {
        this.heap = heap;
    }

// ---------------- All MinHeap Methods ------------------

   
     //Returns the minimum element in the heap.
     
     // @throws IllegalStateException if the heap is empty.
         public Node peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    
     // Removes and returns the minimum element in the heap.
     
     // @throws IllegalStateException if the heap is empty.
     
    public Node extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        Node item = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heap = Arrays.copyOf(heap, size);
        heapifyDown();
        return item;
    }

    // Returns the index of a given node in the heap.
     
    public int getIndex(Node node) {
        for (int i = 0; i < size; i++) {
            if (node == heap[i]) {
                return i;
            }
        }
        return -1;
    }

    
     // Adds a node to the heap.
     
    public void add(Node node) {
        heap[size] = node;
        size++;
        heapifyUp();
    }

    
    //Restores the heap property by moving a node up the heap.
     
    public void heapifyUp() {
        int index = size - 1;
        heapifyUp(index);
    }

    // Restores the heap property by moving a node up the heap starting from a given index.
    
    public void heapifyUp(int index) {
        while (hasParent(index) && heap[index].getKey() < heap[parent(index)].getKey()) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

     // Restores the heap property by moving a node down the heap.
     
    public void heapifyDown() {
        int index = 0;
        heapifyDown(index);
    }

    
     // Restores the heap property by moving a node down the heap starting from a given index.
    
    public void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChild(index);
            if (hasRightChild(index) && heap[rightChild(index)].getKey() < heap[leftChild(index)].getKey()) {
                smallerChildIndex = rightChild(index);
            }
            if (heap[index].getKey() < heap[smallerChildIndex].getKey()) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

   
     // Returns whether a given index has a parent node.
    
    private boolean hasParent(int i) {
        return parent(i) >= 0;
    }

  
     //* Returns the index of the parent node of a given index.
   
    private int parent(int i) {
        return (i - 1) / 2;
    }

   
     // Returns the index of the left child node of a given index.
    
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    
     // Returns the index of the right child node of a given index.
    
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    
     // Returns whether a given index has a left child node.
    
    private boolean hasLeftChild(int i) {
        return leftChild(i) < size;
    }

    
     //* Returns whether a given index has a right child node.
    
    private boolean hasRightChild(int i) {
        return rightChild(i) < size;
    }

    
     //* Swaps two nodes in the heap.
     
    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}

/**
 * This class represents a node in the MST algorithm, which contains a vertex, its parent vertex, and its key value.
 */
class Node{
    private Vertex vertex;
    private Vertex parent;
    private int key;

    
     // Constructor for the Node class.
    
    Node(Vertex vertex,Vertex parent, int key){
        this.vertex=vertex;
        this.parent=parent;
        this.key=key;
    }


// ---------------- Getter and Setter Methods ------------------

    public Vertex getVertex() {
        return vertex;
    }
    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
    public Vertex getParent() {
        return parent;
    }
    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    
}

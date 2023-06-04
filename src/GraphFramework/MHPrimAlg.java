/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part I
 */
package GraphFramework;

import java.util.LinkedList;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */

/**
 * This class implements Prim algorithm to find the minimum spanning tree (MST) of a graph using a min-heap.
 */
public class MHPrimAlg extends MSTAlgorithm {

    // list of all edges in the graph
    private LinkedList<Edge> allEdges;

    
     // Constructor for the MHPrimAlg class.
    
     
    public MHPrimAlg(Graph graph) {
        super(graph); // call parent constructor
        allEdges = (LinkedList<Edge>) graph.getAllEdges().clone(); // make a copy of all edges in the graph
    }

    /**
     * This method displays the resulting MST obtained by running Prim's algorithm using a min-heap.
     */
    @Override
    public void displayResultingMST() {
        //  start time 
        double startTime = System.currentTimeMillis(); //Milli second

        // Clear the result list of the MST
        super.MSTresultList.clear();

        // Create a ِArray of all nodes in the graph, initialize their keys to infinity and parent vertices to null
        Node[] allNodes = new Node[graph.verticesNo];
        for (int i = 0; i < graph.verticesNo; i++) {
            allNodes[i] = new Node(graph.getVertices().get(i), null, Integer.MAX_VALUE);
        }
        allNodes[0].setKey(0);


        // Create a min-heap containing all nodes in the graph except the first one. The first node is selected arbitrarily and its key is set to 0.
        MinHeap minHeap=new MinHeap(allNodes.length);
        for(Node node:allNodes){
                minHeap.add(node);
        }


        // Iterate until the min-heap is empty
        while (minHeap.getSize()!=0) {
            // Extract the node with the smallest key value from the min-heap
            Node extractedNode=minHeap.extractMin();

            // Find all adjacent nodes of the extracted node that are still in the min-heap
            LinkedList<Node> adjacentNodes = findAdjacentNodes(extractedNode, allNodes);

            // For each adjacent node, check if the edge connecting it to the extracted node has a smaller weight
            // If so, update the adjacent node's key value and parent vertex
            Edge selectedEdge;
            for (Node node : adjacentNodes) {
                selectedEdge = findAdjEdge(extractedNode, node);
                if (node.getKey() > selectedEdge.getWeight()) {
                    node.setKey( selectedEdge.getWeight());
                    node.setParent(selectedEdge.getSource());
                    minHeap.heapifyUp(minHeap.getIndex(node));
                }
            }

            // Find the minimum-weight edge that connects a node in the min-heap to a node outside the min-heap
            Edge mstEdge = findMinEdge(minHeap.getHeap(), allNodes);

            // If such an edge exists, add it to the result list of the MST
            if (mstEdge != null) {
                super.MSTresultList.add(mstEdge);
            }
        }

        //  finish time 
        double ftime = System.currentTimeMillis();

        // Print the resulting MST
        printInfoOfGraph(MSTresultList, "MinHeap Prime's");

        // Print the total time consumed by the algorithm
        System.out.println("Total runtime of Prim's Algorithm (Using Min Heap): " + (ftime - startTime) + " ms.");

    }

    
     // This method finds all adjacent nodes of a given node that are still in a list of nodes.
     
    
    private LinkedList<Node> findAdjacentNodes (Node node,Node[] nodes){
            LinkedList<Node> adjacentNodes = new LinkedList<>();

            // Find all edges of the given node that connect it 
            for (Edge edge : node.getVertex().getAdglist()) {
                // Find the adjacent node of the given node that is still in the list of nodes
                Node tempNode = findNode(edge.getTarget(), nodes);
                if (tempNode != null) {
                    adjacentNodes.add(tempNode);
                }
            }
            return adjacentNodes;
        }

   
     // This method finds the node in a list of nodes that corresponds to a given vertex.
     
     
    private Node findNode (Vertex vertex, Node[] nodes){
        for (Node selectedNode : nodes) {
            if (vertex == selectedNode.getVertex()) {
                return selectedNode;
            }
        }
        return null;
    }

  
     // This method finds the edge that connects two given nodes.
     
    private Edge findAdjEdge (Node source, Node target){
        for (Edge edge : source.getVertex().getAdglist()) {
            if (edge.getTarget() == target.getVertex()) {
                return edge;
            }
        }
        return null;
    }

    
     // This method finds the minimum-weight edge that connects a node in a min-heap to anode outside the min-heap.
     
     
    private Edge findMinEdge (Node[] mh, Node[] allNodes){

            int smallestKey = Integer.MAX_VALUE; // Initialize the smallest key value to infinity
            Edge selectedEdge = null;

            // Iterate over all nodes in the min-heap
            for (Node node : mh) {
                // If the key value of the node is smaller than the current smallest, update the smallest key value and the selected edge
                if (node.getKey() < smallestKey) {
                    smallestKey = node.getKey();
                    selectedEdge = findAdjEdge(findNode(node.getParent(), allNodes), node);
                }
            }
            return selectedEdge;
        }
}

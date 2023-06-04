/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part I
 */
package GraphFramework;
import java.util.Collections;
import java.util.LinkedList;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
/**
 *
 * The KruskalAlg class extends the MSTAlgorithm class and implements algorithm for finding the minimum spanning tree of a graph.
 */
public class KruskalAlg extends MSTAlgorithm{

    // The list of edges in the graph, sorted by weight
    private LinkedList<Edge> sortedGraphEdges=new LinkedList<>();

    
     // Constructor for the KruskalAlg class.
     // @param graph is the graph was created in class blueprintgraph to find the minimum spannig tree for it
    public KruskalAlg(Graph graph){
        super(graph);
    }

    /**
     * This method displays the resulting minimum spanning tree of the graph using Kruskal's algorithm.
     */
    @Override
    public void displayResultingMST(){
        //  start time 
        double startTime = System.currentTimeMillis();//Milli second

        // Clear the list of edges in the minimum spanning tree to remove any garbisch element before add any element
        super.MSTresultList.clear();

        // Create a copy of the list of edges in the graph and sort it by weight
        // using clone() method that creation of an exact copy of an object edge
        sortedGraphEdges = (LinkedList<Edge>)graph.getAllEdges().clone();
        //sort the edge by weight
        Collections.sort(sortedGraphEdges);

        // vnum contain the number of the office in the graph
        int vnum = graph.getVerticesNo();
        int EdgeNo = 0;
        // while the counter EdgeNo less than v-1 or the list of sorted edges not empty continue
        while (EdgeNo < vnum - 1 || !sortedGraphEdges.isEmpty()){
            // Get the next edge from the list of sorted edges
            Edge edge = sortedGraphEdges.remove();

            // Find the parent vertices * of the source and target vertices of the edge
            Vertex parent_A = findParent(edge.getSource());
            Vertex parent_B = findParent(edge.getTarget());

            // If the parent vertices are not the same, or both are null, add the edge to the minimum spanning tree
            if(parent_A != parent_B || parent_A == null && parent_B == null){
                union(edge, parent_A, parent_B);
                super.MSTresultList.add(edge);
                EdgeNo++;
            }

        }

        //  finish time 
        double ftime = System.currentTimeMillis();

        // Print the resulting minimum spanning tree of the graph
        printInfoOfGraph(super.MSTresultList,"Kruskal");

        // Print the total time consumed by kruskal algorithm
        System.out.println("Total runtime of Kruskal's Algorithm: " + (ftime - startTime) + " ms.");

    }

    
    /*
     * This method updates the parent vertex of the given edge based on its source and target vertices.
     * @param edge The edge to update the parent vertex of.
     * @param parent_A The parent vertex of the source vertex of the edge.
     * @param parent_B The parent vertex of the target vertex of the edge.
     */

     
    private void union(Edge edge, Vertex parent_A,Vertex parent_B) {
        if(parent_A==null && parent_B==null){
            edge.setParent(edge.getSource());
        }
        if(parent_A!=null && parent_B==null){
            edge.setParent(parent_A);
        }
        if(parent_A==null && parent_B!=null){
            edge.setParent(parent_B);
        }
        if (parent_A!=null && parent_B!=null){
            edge.setParent(parent_A);
            for(Edge ed:super.MSTresultList ){
                if(ed.getParent() == parent_B){
                    ed.setParent(parent_A);
                }
            }
        }
    }

    
     
     /*
     * This method finds and returns the parent vertex of the given vertex in the minimum spanning tree.
     * @param vertex The vertex to find the parent of.
     * @return The parent vertex of the given vertex in the minimum spanning tree.
     */

     
    private Vertex findParent(Vertex vertex) {
        // for the first smallest ddge we cannot enter so we return null else we enter the for loop and return the parrent
        for (Edge ed: super.MSTresultList) {
            if(vertex==ed.getSource() || vertex==ed.getTarget()){
                return ed.getParent();
            }
        }
        return null;
    }
   
}

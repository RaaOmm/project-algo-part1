/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part I
 */
/**
 * The MSTAlgorithm class contains methods for generating a minimum spanning tree (MST)
 */
package GraphFramework;

import java.util.LinkedList;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public abstract class MSTAlgorithm {

    // The graph for which the MST needs to be generated 
    protected Graph graph;

    // The resulting edges of minimum spanning tree 
    protected LinkedList<Edge> MSTresultList = new LinkedList<>();

    
     // Constructor 
    public MSTAlgorithm(Graph graph){
        this.graph = graph;
    }

        /**
     * Displays the resulting MST generated by Prim/kruskal algorithm for the given graph.
     * The method also prints the total time consumed by the algorithm.
     */
    public abstract void displayResultingMST();

    /**
     * Prints the final resulting of minimum spanning tree and its total cost for the given algorithm.
     * @param edgeList The linked list of edges in the resulting MST
     * @param nameOfAlg The name of the algorithm used to generate the MST
     */
    protected void printInfoOfGraph(LinkedList<Edge> edgeList, String nameOfAlg) {
        System.out.println("The phone network (minimum spanning tree) generated by "+nameOfAlg +" algorithm is as follows:");
        int cost = 0;
        for (Edge line : edgeList){
            // call the displayInfo mithod that exists in class Line 
            line.displayInfo(); // the mithod for all line of the minimum spanning tree
            cost += line.getWeight();
        }
        // print the minimum cost of the minimum spanning tree
        System.out.println("The Cost of designed phone network : " + cost);
    }
            
    
}

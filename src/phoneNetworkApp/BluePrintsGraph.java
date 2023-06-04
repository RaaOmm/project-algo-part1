/*
 * The Group members:
 * Afnan Ali Abu Zaydan        # 2105537         B0B
 * Ebtesam kaid                #2106179          B8
 * Wafa hussain lardi          #1915259          B9A
 * Rafa Balkhdhar              #2106048          B9A
 * Group Project – Part I
 */
package phoneNetworkApp;
import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */
public class BluePrintsGraph  extends Graph{

    public BluePrintsGraph() {
    }

    public BluePrintsGraph(int verticesNo, int edgeNo ,boolean isDigraph ) {
        super(verticesNo, edgeNo , isDigraph );
    }
    
     /* override mithod to create object of office
     * @param label The label of  vertex.
     * @param isVisited .
     * @return A vertex object (office object )
    */
    
    @Override
    public  Vertex createVertex(String  label ,boolean isVisited){
        return new Office(label,false);
    }
    
    /* override mithod to create object of line
     * @param weight the weight of the edge line 
     * @param source The source vertex.
     * @param target The target vertex.
     * @return A edge object (line object )
    */
    
    @Override
    public  Edge createEdge(Vertex source, Vertex target, int weight ){
        return new Line(source,target ,weight );
    }  
    
    
}


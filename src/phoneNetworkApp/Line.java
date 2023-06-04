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
import GraphFramework.Vertex;
/**
 *
 * @author Afnan ,Wafa ,Ebtesam ,Rafa
 */


 // This class represents a phone line in a phone network.
public class Line extends Edge {
    
    protected int lLength ;
    // constructor
    public Line(Vertex start, Vertex end, int weight) {
        super(start, end, weight); // call parent constructor 
        this.lLength = 5*weight;// ilength = weight multiplied by 5
    }

    // getter
    public int getlLength() {
        return lLength;
    }
    // setter
    public void setlLength(int lLength) {
        this.lLength = lLength;
    }
    
     // getter
    
    @Override
    public Vertex getSource() {
        return source;
    }
    // setter
    @Override
    public void setSource(Vertex source) {
        this.source = source;
    }
// getter
    @Override
    public Vertex getTarget() {
        return target;
    }

    // setter
    @Override
    public void setTarget(Vertex target) {
        this.target = target;
    }

    // getter
    @Override
    public int getWeight() {
        return weight;
    }
// setter
    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }
//getter
    @Override
    public Vertex getParent() {
        return parent;
    }
//setter
    @Override
    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    /**
     * This method displays information about the edge, including its source vertex, target vertex, and weight.
     */
    public void displayInfo(){
        System.out.println("Office No."+source.getLabel()+
                " – Office No. "+target.getLabel()+
                ": line length: "+lLength);

    }

    @Override
    public int compareTo(Edge that) {
        return this.getWeight()-that.getWeight();
    }
}

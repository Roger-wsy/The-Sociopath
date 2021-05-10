/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialpath;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;


/**
 *
 * @author chunfang
 */
public class SocialPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DefaultDirectedWeightedGraph<String, DefaultEdge> a = new DefaultDirectedWeightedGraph<>(DefaultEdge.class);
        a.addVertex("v1");
        a.addVertex("v2");
        a.addVertex("v3");
        a.addEdge("v1", "v2");
        a.addEdge("v2", "v3");
    }
    
}

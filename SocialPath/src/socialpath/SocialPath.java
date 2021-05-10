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
        DefaultDirectedWeightedGraph<Person, DefaultEdge> a = new DefaultDirectedWeightedGraph<>(DefaultEdge.class);
        Person p1 = new Person("Person1",99,1200,20);
        Person p2 = new Person("Person2",98,1200,21);
        Person p3 = new Person("Person3",97,1200,22);
        Person p4 = new Person("Person4",96,1200,23);
        Person p5 = new Person("Person5",95,1200,24);
        Person p6 = new Person("Person6",94,1200,25);
        Person p7 = new Person("Person7",93,1200,26);
        Person p8 = new Person("Person8",92,1200,27);
        Person p9 = new Person("Person9",91,1200,28);
        Person p10 = new Person("Person10",90,1200,29);

        a.addVertex(p1);
        a.addVertex(p2);
        a.addVertex(p3);
        a.addVertex(p4);
        a.addVertex(p5);
        a.addVertex(p6);
        a.addVertex(p7);
        a.addVertex(p8);
        a.addVertex(p9);
        a.addVertex(p10);

        a.setEdgeWeight(a.addEdge(p1, p7), 4);
        a.setEdgeWeight(a.addEdge(p7, p1), 3);
        
        a.setEdgeWeight(a.addEdge(p2, p1), 8);
        a.setEdgeWeight(a.addEdge(p1, p2), 5);
        
        a.setEdgeWeight(a.addEdge(p2, p5), 6);
        a.setEdgeWeight(a.addEdge(p5, p2), 2);
        
        a.setEdgeWeight(a.addEdge(p2, p6), 9);
        a.setEdgeWeight(a.addEdge(p6, p2), 7);
        
        a.setEdgeWeight(a.addEdge(p2, p3), 5);
        a.setEdgeWeight(a.addEdge(p3, p2), 4);
        
        a.setEdgeWeight(a.addEdge(p4, p8), 7);
        a.setEdgeWeight(a.addEdge(p8, p4), 10);
        
        a.setEdgeWeight(a.addEdge(p4, p10), 7);
        a.setEdgeWeight(a.addEdge(p10, p4), 7);
        
        a.setEdgeWeight(a.addEdge(p9, p10), 5);
        a.setEdgeWeight(a.addEdge(p10, p9), 6);

        System.out.println("p1 : p7 "+a.getEdgeWeight(a.getEdge(p1,p7)));
        System.out.println("p7 : p1 "+a.getEdgeWeight(a.getEdge(p7,p1)));
        
        System.out.println("p2 : p1 "+a.getEdgeWeight(a.getEdge(p2,p1)));
        System.out.println("p1 : p2 "+a.getEdgeWeight(a.getEdge(p1,p2)));
        
        System.out.println("p2 : p6 "+a.getEdgeWeight(a.getEdge(p2,p6)));
        System.out.println("p6 : p2 "+a.getEdgeWeight(a.getEdge(p6,p2)));
        
        System.out.println("p2 : p3 "+a.getEdgeWeight(a.getEdge(p2,p3)));
        System.out.println("p3 : p2 "+a.getEdgeWeight(a.getEdge(p3,p2)));
        
        System.out.println("p2 : p5 "+a.getEdgeWeight(a.getEdge(p2,p5)));
        System.out.println("p5 : p2 "+a.getEdgeWeight(a.getEdge(p5,p2)));
        
        System.out.println("p4 : p8 "+a.getEdgeWeight(a.getEdge(p4,p8)));
        System.out.println("p8 : p4 "+a.getEdgeWeight(a.getEdge(p8,p4)));
        
        System.out.println("p4 : p10 "+a.getEdgeWeight(a.getEdge(p4,p10)));
        System.out.println("p10 : p4 "+a.getEdgeWeight(a.getEdge(p10,p4)));
        
        System.out.println("p9 : p10 "+a.getEdgeWeight(a.getEdge(p9,p10)));
        System.out.println("p10 : p9 "+a.getEdgeWeight(a.getEdge(p10,p9)));

    }
    
}

package Lab9;

import java.util.ArrayList;
public class Graph <T extends Comparable<T>, N extends Comparable <N>> {
    Vertex<T, N> head;
    int size;

    public Graph (){
        head= null;
        size = 0;}

    public int getSize() {return size;}

    public boolean hasVertex(T v){ //accept name of vertex
        if (head == null) return false ; //no vertex

        else {
            Vertex <T,N> temp = head;
            while (temp!= null){
                if (temp.vertexInfo.equals(v)) return true;
                temp = temp.nextVertex;}
        } return false;} //not found

    public int getInDeg(T v) {
        Vertex <T,N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.equals(v)) return temp.indeg;
            temp = temp.nextVertex;}
        return -1;} //do not have this vertex


    public int getOutDeg(T v) {
        Vertex <T,N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.equals(v))return temp.outdeg;
            temp = temp.nextVertex;}
        return -1;} //do not have this vertex

    public boolean addVertex(T v){
        if (hasVertex(v)) return false; //vertex ady present
        else {
            Vertex <T, N> temp = head;
            Vertex <T, N> newVertex = new Vertex(v, null); //info and next vertex (null)
            if (head == null) head = newVertex;
            else { //transverse to last vertex and add after it
                while (temp.nextVertex != null) { //next of last vertex is null for tail
                    temp = temp.nextVertex;}
                temp.nextVertex = newVertex;}
            size ++; } return true;}

    public int getIndex (T v) {
        Vertex <T,N> temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.vertexInfo.equals(v)) return pos;
            temp = temp.nextVertex;
            pos ++;}
        return -1;} //not found

    public ArrayList <T> GetAllVertex(){
        ArrayList <T> list = new ArrayList<>();
        Vertex <T,N> temp = head;
        while (temp != null){
            list.add(temp.vertexInfo); //add name
            temp = temp.nextVertex;}
        return list;}

    public T getVertex(int pos){
        if (pos < 0 || pos > size-1) return null; //max index is size -1
        Vertex <T,N> temp = head; //stop at that vertex node
        for (int i = 0; i< pos ; i++) temp = temp.nextVertex;
        return temp.vertexInfo;}

    public boolean hasEdge (T source, T destination){
        if (!hasVertex(source) || !hasVertex(destination) || head == null)
            return false; //vertex do not exist

        Vertex <T,N> sourceVertex = head;
        while (sourceVertex != null){ //transverse all vertical vertex
            if (sourceVertex.vertexInfo.equals(source)){ //found source vertex
                Edge <T,N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null){ //transverse all horizontal edge
                    if ((currentEdge.toVertex).vertexInfo.equals(destination))
                        return true;
                    currentEdge = currentEdge.nextEdge;}
            } //end if
            sourceVertex = sourceVertex.nextVertex;} //end while
        return false;} //not found

    public boolean addEdge(T source, T destination, N W){
        if (!hasVertex(source) || !hasVertex(destination) || head == null)
            return false;

        Vertex <T,N> sourceVertex = head;
        while (sourceVertex != null){
            if (sourceVertex.vertexInfo.equals(source)){
                Vertex <T,N> destinationVertex = head;
                while (destinationVertex != null){
                    if (destinationVertex.vertexInfo.equals(destination)){
                        Edge <T,N> currentEdge = sourceVertex.firstEdge; //intitial edge will be become second edge
                        Edge <T,N> newEdge = new Edge(destinationVertex, W, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg ++;
                        destinationVertex.indeg ++;
                        return true;} //if no, keep looping to find vertex
                    destinationVertex = destinationVertex.nextVertex;} //end second while
            } //end first if
            sourceVertex = sourceVertex.nextVertex;} //end first while
        return false;}

    public N getEdgeWeight(T source, T destination){
        if (!hasVertex(source) || !hasVertex(destination) || head == null)
            return null;
        Vertex <T,N> sourceVertex = head;
        while (sourceVertex != null){ //transverse all vertical vertex
            if (sourceVertex.vertexInfo.equals(source)){ //found source vertex
                Edge <T,N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null){ //transverse all horizontal edge
                    if ((currentEdge.toVertex).vertexInfo.equals(destination))
                        return currentEdge.weight;
                    currentEdge = currentEdge.nextEdge;}
            } //end if
            sourceVertex = sourceVertex.nextVertex;} return null;}

    public ArrayList <T> getNeighbours(T v){
        if (!hasVertex(v)|| head == null)  return null;
        ArrayList <T> list = new ArrayList <>();
        Vertex <T,N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.equals(v)){
                Edge <T,N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null){
                    list.add((currentEdge.toVertex).vertexInfo); //add name of each connected edge
                    currentEdge = currentEdge.nextEdge;}}
            sourceVertex = sourceVertex.nextVertex;} return list;}


    public void printEdges(){ //print all vertex and edges
        Vertex<T,N> temp=head;
        while (temp!=null) {
            System.out.print("# " + temp.vertexInfo + " : " );
            Edge<T,N> currentEdge = temp.firstEdge;
            while (currentEdge != null) { //source vertex (same) --> destination vertex (updated)
                System.out.print("[" + temp.vertexInfo + "," + currentEdge.toVertex.vertexInfo +"] " );
                currentEdge=currentEdge.nextEdge;} //go to next destination vertex
            System.out.println();
            temp=temp.nextVertex;} }//go to next source vertex

}
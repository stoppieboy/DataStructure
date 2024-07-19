import java.util.*;
public class Weighted_graph {
    int vertices;
    LinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    Weighted_graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight){
        
    }

    public static void main(String args[]){
        Weighted_graph wg = new Weighted_graph(5);
        wg.addEdge(0, 2, 10);
    }
}

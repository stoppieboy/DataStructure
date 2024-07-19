import java.util.*;
public class Dijkstra {

    class Pair{
        int dest,weight;
        public Pair(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }


    int vertices;
    LinkedList<Pair> adjacencyList[];

    @SuppressWarnings("unchecked")
    Dijkstra(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<Pair>();
        }
    }

    public void addEdge(int src, int dest, int w){

    }

    public static void main(String args[]){
        Dijkstra d = new Dijkstra(5);

    }
}

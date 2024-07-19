import java.util.*;
class Graph{
    int vertices;
    LinkedList<Integer> adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjacencyList[src].add(dest);
        this.adjacencyList[dest].add(src);
    }
    
    public List<List<Integer>> dfsOfGraph(int src){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        List<Integer> connectedGraph;
        for(int i = 0; i < vertices; i++){
            if(!visited[i]){
                connectedGraph = new ArrayList<>();
                dfs(i, visited, connectedGraph);
                res.add(connectedGraph);
            }
        }
        return res;
    }
    
    public void dfs(int v, boolean[] visited, List<Integer> res){
        res.add(v);
        visited[v] = true;
        for(int i: adjacencyList[v]) {
            if(!visited[i]){
                dfs(i, visited, res);
                visited[i] = true;
            }
        }
    }

    public static void main(String args[]){
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        // g.addEdge(2,3);
        // g.addEdge(4,5);
        // g.addEdge(0,2);
        g.addEdge(3, 4);
        // g.addEdge(0,4);

        List<List<Integer>> res = g.dfsOfGraph(0);
        System.out.println("Number of connected components: "+res.size());
        System.out.println(res);
    }
}
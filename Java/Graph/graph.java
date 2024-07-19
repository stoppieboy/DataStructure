import java.util.*;
class graph{

    int[] RList;
    int v;

    public graph(int v){
        RList = new int[v];
        this.v = v;
        for(int i = 0; i < v; i++) RList[i] = i+1;
    }

    @SuppressWarnings("unchecked")
    public static void adjacency_list(int[][] list, int v){
        ArrayList<Integer>[] al = new ArrayList[v];
        for(int i = 0; i < v; i++){
            al[i] = new ArrayList<>();
            // al[i].add(i+1);
        }
        for(int i = 0; i < list.length; i++){
            al[list[i][0]-1].add(list[i][1]);
        }
        for(int i = 0; i < al.length; i++){
            System.out.print(i+1+" -> ");
            System.out.println(al[i]);
        }
    }

    // public static void DFS(ArrayList<Integer>[] adjacencyList, int v) {
    //     for(ArrayList<Integer> i: adjacencyList){

    //     }
    // }


    public int find(int i) {
        return RList[i];
    }

    public static void main(String args[]) {
        int[][] edge_list = {{1,2},{2,3},{2,4},{1,4},{3,4},{4,5},{5,6},{5,7},{6,7}};
        int v = 7;
        adjacency_list(edge_list, v);
    }
}
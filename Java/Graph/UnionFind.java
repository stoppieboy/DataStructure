import java.util.Arrays;

class DisjointSets{
    int[] par;
    int[] rank;
    int nodes;
    DisjointSets(int n){
        nodes = n;
        rank = new int[n];
        Arrays.fill(rank, 1);

        par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
    }

    private int union(int node1, int node2){
        int p1 = find(node1);
        int p2 = find(node2);

        if(p1 == p2) return 0;

        if(rank[p2] > rank[p1]){
            par[p1] = p2;
            rank[p2] += rank[p1];
        }else{
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        return 1;
    }

    private int find(int node){
        while(node != par[node]){
            par[node] = par[par[node]];
            node = par[node];
        }
        return node;
    }

    private int findNoOfDisjointSets(int[][] edges){
        int result = nodes;
        for(int[] i: edges){
            result -= union(i[0], i[1]);
        }
        return result;
    }

    public static void main(String args[]){
        int n = 5;
        int edges[][] = {{0,1},{1,2},{2,4}};
        DisjointSets obj = new DisjointSets(n);
        int result = obj.findNoOfDisjointSets(edges);
        System.out.println("No. of disjoint sets: "+result);
    }
}
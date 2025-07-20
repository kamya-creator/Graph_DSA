package DSU;

public class CycleDetectionUndirectGraph_DSU {

    public  static int find(int x, int[] parent)
    {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x], parent);
    }

    public static void union(int x, int y, int[] parent, int[] rank)
    {
        int x_ult_parent = find(x, parent);
        int y_ult_parent = find(y, parent);

        if(x_ult_parent == y_ult_parent) return;

        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        else if(rank[y_ult_parent] > rank[x_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
        } else if (rank[x_ult_parent] == rank[y_ult_parent]) {

            parent[x_ult_parent] = y_ult_parent;
            rank[y_ult_parent]++;
        }
    }


    public static void main(String[] args) {
        int[][] edges = {{1, 3},{3, 0},{0, 2},{2 ,4}};
        int V =  edges.length +1;


        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            int x = find(u, parent);
            int y = find(v, parent);

            if(x == y)
            {
                System.out.println("Cycle Detected");
                return;
            }

            union(u, v, parent, rank);
        }

    }
}

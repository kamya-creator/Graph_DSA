package DSU;

import java.util.Arrays;

public class RedundantConnection_I {
    static int  find(int x, int[] parent)
    {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x], parent);
    }

    static public void union(int x, int y , int[] parent, int[] rank)
    {
        int x_ult_parent = find(x, parent);
        int y_ult_parent = find(y, parent);

        if(x_ult_parent == y_ult_parent)
        {
            return;
        }
        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        if(rank[y_ult_parent] > rank[x_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent ;
        }
        if(rank[x_ult_parent] == rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
            rank[x_ult_parent]++;
        }
    }
    static public int[] findRedundantConnection(int[][] edges) {

        int V = edges.length;

        int[] ans = new int[2];
        int[] parent = new int[V + 1];
        for(int i =0;i<V + 1;i++)
        {
            parent[i] = i;
        }
        int[] rank = new int[V + 1];

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            int x = find(u, parent);
            int y = find(v, parent);
            if(x == y)
            {
                ans  = edge;
            }
            else
                union(u, v, parent, rank);
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] redundantConnection = findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }
}

package DSU;

import java.util.HashMap;
import java.util.Map;

public class CountUnreachablePairsofNodesInanUndirectedGraph {
    public static int find(int x, int[] parent)
    {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x], parent);
    }
    public  static void union(int x, int y, int[] parent, int[] rank)
    {
        int x_ult_parent = find(x, parent);
        int y_ult_parent = find(y, parent);

        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        if(rank[x_ult_parent] < rank[y_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
        }
        if(rank[x_ult_parent] == rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
            rank[x_ult_parent]++;
        }
    }
    public  static long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        if( edges.length == 0)
        {
            // System.out.println(1L*n*(n-1));
            return (1L*n*(n-1))/2L;
        }
        for(int i =0 ;i<n;i++)
        {
            parent[i] = i;
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            union(u, v, parent, rank);
        }

        for(int i =0 ;i<n;i++)
        {
            parent[i] = find(i, parent);
        }

        HashMap<Integer, Long> map = new HashMap<>();
        for(int i =0 ;i<n;i++)
        {
            int curr = parent[i];
            map.put(curr, map.getOrDefault(curr, 0L )  + 1);
        }
        long ans = 0;
        long rem = n;
        for(Map.Entry<Integer, Long> entry :  map.entrySet())
        {
            long value = entry.getValue();
            ans = ans + value*(rem - value);
            rem = rem - value;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        long countPairs = countPairs(n, edges);
        System.out.println(countPairs);
    }
}

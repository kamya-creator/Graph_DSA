package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskals_Algorithm {
    static int[] parent;
    static int[] rank;
    static int find(int x)
    {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void  union(int x, int y)
    {
        int x_ult_parent = find(x);
        int y_ult_parent = find(y);
        if(x_ult_parent == y_ult_parent) return;

        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        else if(rank[x_ult_parent] < rank[y_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
        }
        else{
            parent[x_ult_parent] = y_ult_parent;
            rank[y_ult_parent]++;
        }
    }
    public  static int spanningTree(int V, List<List<Integer>> adj) {
        parent = new int[V];
        rank   = new int[V];
        for(int i =0;i<V;i++)
        {
            parent[i] = i;
        }
        Collections.sort(adj, (a, b) -> a.get(2) - b.get(2));
        int MSTCost = 0;
        for(int i = 0 ;i<adj.size();i++)
        {
            int u = adj.get(i).get(0);
            int v = adj.get(i).get(1);
            int wt = adj.get(i).get(2);

            if(find(u) != find(v))
            {
                union(u, v);
                MSTCost += wt;
            }
        }
        return MSTCost;
    }
    public static void main(String[] args) {

        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        //{ {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
        edges.add(Arrays.asList(0, 1, 2));
        edges.add(Arrays.asList(0, 3, 6));
        edges.add(Arrays.asList(1, 2, 3));
        edges.add(Arrays.asList(1, 3, 8));
        edges.add(Arrays.asList(1, 4, 5));
        edges.add(Arrays.asList(4, 2, 7));
        int spanningTreeCost = spanningTree(V, edges);
        System.out.println(spanningTreeCost);
    }
}

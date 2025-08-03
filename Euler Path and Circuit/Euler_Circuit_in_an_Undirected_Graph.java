package Euler_Path_and_Circuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Euler_Circuit_in_an_Undirected_Graph {
    public  static boolean isEularCircuitExist(int v, List<Integer>[] adj) {
        int[] degree = new int[v];
        //System.out.println(adj);
        int index =0;
        for(int i =0;i<adj.length;i++)
        {
            degree[index] = adj[i].size();
            index++;
        }

        for(int i =0;i<v;i++)
        {
            if(degree[i]%2 != 0)
                return false;
        }
        return true;

    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        List<Integer>[] adj = new ArrayList[V];
        for(int i =0;i<V;i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        System.out.println(Arrays.toString(adj));
        boolean eularCircuitExist = isEularCircuitExist(V, adj);
        System.out.println(eularCircuitExist);
    }
}

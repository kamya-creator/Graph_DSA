package Euler_Path_and_Circuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EulerPathCircuit_UndirectGraph {
    public static void DFS(int node, List<Integer>[] adj, boolean[] visited)
    {
        visited[node] = true;
        for(int nbr : adj[node])
        {
            if(visited[nbr] == false)
                DFS(nbr, adj, visited);
        }
    }
    public static int isEulerCircuit(int V, List<Integer>[] adj) {

        int[] degree = new int[V];
        for(int i =0;i<adj.length;i++)
        {
            degree[i] = adj[i].size();
        }

        // Check if graph with non zero degree is connected or not
        boolean[] visited = new boolean[V];
        for(int i =0;i<V;i++)
        {
            // check
            if(degree[i] != 0)
            {
                DFS(i, adj, visited);
                break;
            }
        }
        for(int i =0;i<V;i++)
        {
            if(degree[i] != 0 && visited[i] == false)
                return 0;
        }
        int oddDegreeCount = 0;
        boolean eulerPath = true;
        for(int i =0;i<V;i++)
        {
            if(degree[i] % 2 != 0)
            {
                oddDegreeCount++;
            }
        }
        // System.out.println(oddDegreeCount);

        boolean eulerCircuit = true;
        for(int i =0;i<V;i++)
        {
            if(degree[i] % 2 != 0)
                eulerCircuit = false;
        }
        if(eulerCircuit) return 2;


        if(oddDegreeCount > 2) eulerPath = false;
        if(eulerPath) return 1;

        return 0;


    }
    public static void main(String[] args) {

        int V = 7;
        //1 2
        //2 3
        //4 5
        //5 6
        //4 6
        //3 1
        int[][] edges = {{2, 3}, {1, 2}, {4,5}, {5, 6}, {4, 6}, {3,1}};
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

        int eulerCircuitPathOrNot = isEulerCircuit(V, adj);
        System.out.println(eulerCircuitPathOrNot);
    }
}

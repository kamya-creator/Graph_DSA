package Bipartite;

import java.util.ArrayList;
import java.util.Arrays;

public class Is_Bipartite_DFS {
    public static void main(String[] args) {
//        int V = 4;
//        int edges[][] = {{0, 3}, {1, 2}, {3, 2}, {0, 2}};
        int V = 3;
        int edges[][] = {{0, 1}, {1,2}};

        ArrayList<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        boolean ans = isBipartite(V, adjList);
        System.out.println(ans);
    }

    private static boolean isBipartite(int V,  ArrayList<Integer>[] adjList) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {

            if(color[i] == -1)
            {
                if(dfs(i, adjList, color, 0) == false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(int src, ArrayList<Integer>[] adjList, int[] color , int currCol)
    {
        color[src] = currCol;

        for (int nbr  :  adjList[src])
        {
            if(color[nbr] == -1)
            {
                if(dfs(nbr, adjList, color, 1- currCol) == false) return false;
            }

            if(color[nbr] == currCol)
            {
                return false;
            }
        }

        return true;
    }
}

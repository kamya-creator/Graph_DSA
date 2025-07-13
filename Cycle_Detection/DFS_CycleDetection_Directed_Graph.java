package org.example.CycleDetection.UndirectedGraph;

import java.util.ArrayList;

public class DFS_CycleDetection_Directed_Graph {
    public static void main(String[] args) {
        /*
        0 1
0 2
1 2
2 0
2 3
         */
        int V = 4;
        int[][] edges = {{0,1},{0,2},{1,2},{2,0},{2,3}};

        ArrayList<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int sr = edge[0];
            int dest = edge[1];
            adjList[sr].add(dest);
        }
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if(visited[i] == false)
            {
                boolean[] inRec = new boolean[V];
                if(dfs(i, adjList, visited, inRec))
                {
                    System.out.println("Cycle Deetcted");
                    return;
                }
            }
        }
    }
    public static boolean dfs(int src, ArrayList<Integer>[] adjList, boolean[] visited, boolean[] inRec)
    {
        visited[src] = true;
        inRec[src] = true;
        for(int nbr : adjList[src])
        {
            if(visited[nbr] == false)
            {
                if(dfs(nbr, adjList, visited, inRec)) return  true;
            }
            else if(inRec[nbr] == true)
            {
                return true;
            }
        }
        inRec[src] = false;
        return false;
    }
}

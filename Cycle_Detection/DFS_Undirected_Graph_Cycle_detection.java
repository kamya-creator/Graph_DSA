package org.example.CycleDetection.UndirectedGraph;

import java.util.ArrayList;

public class DFS_Undirected_Graph_Cycle_detection {
    public static void main(String[] args) {

        // 1 2
        //2 3
//        int[][] edges = {{0,1},{1,2},{2,4},{3,4},{1,3}};
//        int V = 6;

        int[][] edges = {{1,2},{2,3}};
        int V = 4;

        ArrayList<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            if(visited[i] == false)
            {
                parent[i] = -1;
                if(dfs(i, adjList, parent, visited))
                {
                    System.out.println("Cycle Detected");
                    return;
                }
            }
        }

    }
    public static boolean dfs(int src, ArrayList<Integer>[] adjList, int[] parent, boolean[] visited)
    {
        visited[src] = true;

        for (int nbr : adjList[src])
        {
            if(visited[nbr] == false)
            {
                parent[nbr] = src;
                if(dfs(nbr, adjList, parent, visited))return true;
            }
            /*
            Agar nbr visited h to check kro kahi nbr parent to nhi, agar parent h nbr to we can continue
            but agar parent nhi or nbr visited bhi h to mtlb cycle h
             */
            else if(visited[nbr] == true && parent[src] != nbr)
            {
                return true;
            }
        }
        return false;
    }
}

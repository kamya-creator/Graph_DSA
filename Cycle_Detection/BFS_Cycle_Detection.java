package org.example.CycleDetection.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    int v;
    int parent;
    Pair(int v, int parent)
    {
        this.v = v;
        this.parent = parent;
    }
}
public class BFS_Cycle_Detection {
    public static void main(String[] args) {
        // V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
        int V = 4, E = 4;
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};

        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        boolean flag = false;
        for (int i = 0; i < V; i++) {

            System.out.println("Kr");
            if(visited[i] == false)
            {
                if(bfs(i, adj, visited, parent))
                {
                    flag = true;
                    break;
                }
            }
        }
        if(flag)
        {
            System.out.println("Cycle Detected");
        }
        else{
            System.out.println("No Cycle Detected");
        }
    }
    public static boolean bfs(int src, ArrayList<Integer>[] adjList , boolean[] visited, int[] parent)
    {
        visited[src] = true;
        parent[src] = -1;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));

        while (queue.size() > 0)
        {
            Pair rem = queue.poll();
            int curr = rem.v;
            int p = rem.parent;

            visited[curr] = true;

            for (int nbr : adjList[curr])
            {
                if(visited[nbr] == false)
                {
                    visited[nbr] = true;
                    parent[nbr] = curr;

                    queue.add(new Pair(nbr, curr));
                }
                else if(visited[nbr] == true && parent[curr] != nbr)
                {
                    return  true;
                }
            }
        }
        return false;


    }
}

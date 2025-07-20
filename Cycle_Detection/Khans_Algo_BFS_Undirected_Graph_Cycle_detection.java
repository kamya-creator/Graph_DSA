package org.example.CycleDetection.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
        3
10
7
1 2
4 5
5 9
5 10
5 1
5 3
6 7
5
4
1 2
2 3
3 4
4 5
2
1
1 2

         */
public class Khans_Algo_BFS_Undirected_Graph_Cycle_detection {
    public static void main(String[] args) {

        /*
        5
8
1 4
1 5
1 2
4 1
2 4
3 4
5 2
1 3
         */
        //int V  = 11;
        int V = 8;
        ArrayList<Integer>[] adjList = new ArrayList[V];
        //int[][] edges = {{1, 2}, {4, 5}, {5, 9},{5, 10},  {5, 1},  {5, 3},{ 6, 7}};
        int[][] edges = {{1, 4}, {1, 5},{1,2},{4,1},{2,4},{3,4},{5,2}};
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0]; int v = edge[1];
            adjList[u].add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < V; i++) {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        while(queue.size() > 0)
        {
            int curr = queue.poll();
            list.add(curr);

            for (int nbr : adjList[curr])
            {
                indegree[nbr]--;
                if(indegree[nbr] == 0)
                {
                    queue.add(nbr);
                }
            }
        }

        System.out.println( list.size() == V - 1 ? "No Cycle detected" : "Cycle Detected");
    }
}

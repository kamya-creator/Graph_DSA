package org.example;

import java.util.ArrayList;

public class CountNumberofCompleteComponents {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        //         int[][] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}}; o/p - 1
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0;i<n;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges)
        {
            int v1 = edge[0];
            int v2 = edge[1];

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        int numberOfCompleteConnectedComponent = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {

            if(visited[i] == false) {


                int[] nodeCount = {0};
                int[] edgeCount = {0};
                dfs(adjList, i, visited, nodeCount, edgeCount);
                edgeCount[0] = edgeCount[0]/2;
                int reqEdgeCount = (nodeCount[0]*(nodeCount[0]-1))/2;
                if(reqEdgeCount == edgeCount[0])
                {
                    numberOfCompleteConnectedComponent++;
                }

            }
        }
        System.out.println(numberOfCompleteConnectedComponent);
    }

    public static void dfs(ArrayList<Integer>[] adjList, int src, boolean[] visited, int[] nodeCount, int[] edgeCount)
    {
        visited[src] = true;
        nodeCount[0]++;
        edgeCount[0] = edgeCount[0] + adjList[src].size();

        for(int nbr  :adjList[src])
        {
            if(visited[nbr] ==false)
            {
                dfs(adjList, nbr, visited, nodeCount, edgeCount);
            }
        }


    }
}

package org.example;

import java.util.ArrayList;

public class NumberofProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int n = isConnected.length;
        int m  = isConnected[0].length;

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(i != j && isConnected[i][j] == 1)
                {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i] == false)
            {
                count++;
                dfs(i, adjList, visited);
            }
        }
        System.out.println(count);
    }
    public static void dfs(int src, ArrayList<Integer>[] adjList , boolean[] visited)
    {
        visited[src ] =true;
        for (int nbr  : adjList[src])
        {
            if(visited[nbr] == false)
            {
                dfs(nbr, adjList, visited);
            }
        }
    }
}

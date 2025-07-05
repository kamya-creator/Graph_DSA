package org.example;

import java.util.ArrayList;

public class GetAllComponents {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,4},{6,7},{6,9},{7,8},{8,9}};
        int v = 11;
        ArrayList<Integer>[] adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges)
        {
            int v1 = edge[0];
            int v2 = edge[1];

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> componentes = new ArrayList<>();
        for (int i = 1; i < v; i++) {

            if(visited[i] == false) {
                ArrayList<Integer> bag = new ArrayList<>();
                dfs(adjList, i, visited, bag);
                componentes.add(bag);
            }
        }
        System.out.println(componentes);
        System.out.println(componentes.size() == 1 ? "Yes Graph is Connected" : "No Graph is not connected");
    }
    public static void dfs(ArrayList<Integer>[] adjList, int src, boolean[] visited, ArrayList<Integer> bag)
    {
        visited[src] = true;
        bag.add(src);
        for (int nbr : adjList[src])
        {
            if(!visited[nbr])
                dfs(adjList, nbr, visited, bag);
        }
    }
}

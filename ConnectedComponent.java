package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectedComponent {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{2,3},{4,5},{4,6},{5,6}};
        int n = 7;
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int v1 = edge[0];
            int v2 = edge[1];

            ArrayList<Integer> list = adjList[v1];
            list.add(v2);

            ArrayList<Integer> list2 = adjList[v2];
            list2.add(v1);
        }
        System.out.println(Arrays.toString(adjList));
        boolean[] visited = new boolean[n];
        getConnectedComponent(n, adjList, visited);
    }
    public static void getConnectedComponent(int n, ArrayList<Integer>[] adjList, boolean[] visited)
    {
        ArrayList<ArrayList<Integer>> components  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> comp = new ArrayList<>();
            if(visited[i] == false)
            {
                visited[i] = true;
                comp.add(i);
                solve(adjList, i, visited, comp);
                components.add(comp);
            }
        }
        System.out.println(components);
    }
    public static void solve(ArrayList<Integer>[] adjList, int src, boolean[] visited, ArrayList<Integer> comp)
    {

        for(int nbr : adjList[src])
        {
            if(visited[nbr] == false) {
                visited[nbr] = true;
                comp.add(nbr);
                solve(adjList, nbr, visited, comp);
            }
        }
    }
}

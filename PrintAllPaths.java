package org.example;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.GraphRepresentation.constructGraph;

public class PrintAllPaths {
    public static void main(String[] args) {
        int n = 7;
        //int[][] edges = {{0,1},{0,2},{3,2},{1,3},{4,3},{5,4},{6,4},{6,5}};
        int[][] edges = {{0,1},{1,3},{3,2},{3,5},{2,4},{4,5},{0,2},{5,6},{4,6}};
        ArrayList<Integer>[] adjList = constructGraph(n, edges);
        System.out.println(Arrays.toString(adjList));

        int sr = 0, dest = 6;
        boolean[] visited = new boolean[n];
        String psf = sr + "";
        printAllPaths(adjList, sr, dest, visited, psf);
    }
    public static void printAllPaths(ArrayList<Integer>[] adjList, int sr, int dest, boolean[] visited, String psf)
    {
        if(sr == dest)
        {
            System.out.println(psf);
            return;
        }

        visited[sr] = true;
        for (Integer nbr : adjList[sr])
        {
            if(visited[nbr] == false)
            {
                printAllPaths(adjList, nbr, dest, visited, psf + nbr);
            }
        }
        visited[sr] = false;
    }
}

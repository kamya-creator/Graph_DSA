package org.example;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.GraphRepresentation.constructGraph;

public class HasPath {
    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};

        ArrayList<Integer>[] adjList = constructGraph(n, edges);
        System.out.println(Arrays.toString(adjList));

        int sr = 3, dest = 5;
        boolean[] visited = new boolean[n];
      boolean hasPath_ = hasPath(adjList, sr, dest, visited);
       System.out.println("Has Path????" + hasPath_);
    }
    public static boolean hasPath(ArrayList<Integer>[] adjList, int sr, int dest, boolean[] visited)
    {
        if(sr == dest)
        {
            return true;
        }
        visited[sr] = true;
        for (Integer nbr : adjList[sr])
        {
            if(visited[nbr] == false) {
                boolean nbrHasPath = hasPath(adjList, nbr, dest, visited);
                if (nbrHasPath) {
                    return true;
                }
            }

        }
        return false;
    }
}

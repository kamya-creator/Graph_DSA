package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphRepresentation {
    public static void main(String[] args) {
        /*n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]

       int n = 3;
       int[][] edges = {{0,1},{1,2},{2,0}};
         */
       int n = 6;
       int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};

        ArrayList<Integer>[] adjList = constructGraph(n, edges);

        System.out.println(Arrays.toString(adjList));
    }
    public static ArrayList<Integer>[] constructGraph(int n , int[][] edges)
    {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges)
        {
            int[] currEdge = edge;
            int sr = currEdge[0];
            int dest = currEdge[1];

            ArrayList<Integer> list = adjList[sr];
            list.add(dest);

            ArrayList<Integer> list1 = adjList[dest];
            list1.add(sr);
        }
        return  adjList;
    }
}

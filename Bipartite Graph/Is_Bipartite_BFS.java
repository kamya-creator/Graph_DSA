package Bipartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Is_Bipartite_BFS {
    public static void main(String[] args) {
//        int V = 4;
//        int edges[][] = {{0, 3}, {1, 2}, {3, 2}, {0, 2}};
        int V = 3;
        int edges[][] = {{0, 1}, {1,2}};

        ArrayList<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        boolean ans = isBipartite(V, adjList);
        System.out.println(ans);
    }

    private static boolean isBipartite(int V,  ArrayList<Integer>[] adjList) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {

            if(color[i] == -1)
            {
                if(bfs(i, adjList, color, 0) == false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean bfs(int src, ArrayList<Integer>[] adjList, int[] color , int currCol)
    {
        color[src] = currCol;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while(queue.size() > 0) {

            int curr = queue.poll();
            for (int nbr : adjList[src]) {
                if (color[nbr] == -1) {
                    color[nbr] = 1 - color[curr];
                    queue.add(nbr);
                }

                if (color[nbr] == currCol) {
                    return false;
                }
            }
        }

        return true;
    }
}

package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinUndirectedGraph {
    public static void main(String[] args) {
        int adj[][] = {{1, 3}, {0, 2}, {1, 6}, {0, 4}, {3, 5}, {4, 6}, {2, 5, 7, 8}, {6, 8}, {7, 6}};
        int src = 0;
        int v = adj.length;
        int[] dist = new int[v];
        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (queue.size() > 0)
        {
            int curr = queue.poll();

            for(int nbr : adj[curr])
            {
                if(visited[nbr] == false)
                {
                    dist[nbr] = dist[curr]  + 1;
                    visited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}

package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_OF_Graph {
    public static void main(String[] args) {
        //adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
        int[][] adj = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        int v = adj.length;
        boolean[] visited = new boolean[v];
        ArrayList<Integer> bfsOfGraph = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while(queue.size() > 0 )
        {
            int curr = queue.poll();
            bfsOfGraph.add(curr);

            for(int nbr : adj[curr])
            {
                if(visited[nbr] == false)
                {
                    visited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
        System.out.println(bfsOfGraph);
    }
}

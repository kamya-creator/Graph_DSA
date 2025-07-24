package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintShortestPathFromS_To_T_in_Unweighted_Graph {
    public static void main(String[] args) {
        int V = 8;
        /*
        1 2
        2 3
        3 4
        1 3
        */
//        int[][] edges = {{1,2},{2,5},{1,3},{1,4},{4,6},{6,7},{5,8},{3,8},{7,8}};
//        int s = 1, t =8;

        int[][] edges = {{1,3},{2,3},{1,2},{3,4}};
        int s = 1, t = 4;
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V +1];
        int[] parent = new int[V +1];
        ArrayList<Integer>[] adjList = new ArrayList[V + 1]; // nodes 1 se shuru h
        for (int i =0;i<V+1;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0]; int v = edge[1];
            adjList[u].add(v); adjList[v].add(u);
        }

        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;

        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        distance[s] = 0;
        visited[s] = true;

        while(queue.size() > 0)
        {
            int curr = queue.poll();

            if(curr == t)
            {
                break;
            }

            for(int nbr : adjList[curr])
            {
                if(visited[nbr] == false)
                {
                    visited[nbr] = true;
                    parent[nbr] = curr;
                    distance[nbr] = distance[curr]  + 1;
                    queue.add(nbr);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));

        ArrayList<Integer> list = new ArrayList<>();
        findParentFromT_to_S(t, parent, list);


        System.out.println(list);

    }
    public static void findParentFromT_to_S(int curr, int[] parent , ArrayList<Integer> list)
    {
        if(curr == parent[curr])
        {
            list.add(curr);
            return;
        }
        findParentFromT_to_S(parent[curr], parent, list);
        list.add(curr);
    }
}

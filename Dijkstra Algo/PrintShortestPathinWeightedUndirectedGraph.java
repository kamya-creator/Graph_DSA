package DijkstraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrintShortestPathinWeightedUndirectedGraph {
    public static void main(String[] args) {
        int V = 5, m= 6;
        int[][]edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        int s = 1, t = 5;
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V +1];
        int[] parent = new int[V +1];
        ArrayList<Pair>[] adjList = new ArrayList[V + 1]; // nodes 1 se shuru h
        for (int i =0;i<V+1;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0]; int v = edge[1]; int wt = edge[2];
            adjList[u].add(new Pair(v, wt)); adjList[v].add(new Pair(u, wt));
        }

        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;

        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(s, 0));
        distance[s] = 0;

        while(pq.size() > 0)
        {
            Pair currPair = pq.poll();
            int currNode = currPair.dest;
            int currWt   = currPair.weight;

            if(currWt > distance[currNode]) continue;


            for(Pair nbrPair : adjList[currNode])
            {
                int nbr = nbrPair.dest;
                int nbrWt = nbrPair.weight;

                if(distance[nbr] > currWt + nbrWt)
                {
                    distance[nbr] = currWt + nbrWt;
                    parent[nbr] = currNode;
                    pq.add(new Pair(nbr, distance[nbr]));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));

        ArrayList<Integer> list = new ArrayList<>();
        findParentFromS_to_T(t, parent, list);
        System.out.println(list);
    }
    public static void findParentFromS_to_T(int curr, int[] parent, ArrayList<Integer> list)
    {
        if(curr == parent[curr])
        {
            list.add(curr);
            return;
        }
        findParentFromS_to_T(parent[curr], parent, list);
        list.add(curr);
    }
}

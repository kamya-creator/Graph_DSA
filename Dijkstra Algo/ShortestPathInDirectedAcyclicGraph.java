package DijkstraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
        /*
        V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
        V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
         */
        int V = 6, m= 7;
        int[][]edges = {{0, 1,  2}, {0,4, 1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int s = 0;
        int[] distance = new int[V];
        ArrayList<Pair>[] adjList = new ArrayList[V];
        for (int i =0;i<V;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0]; int v = edge[1]; int wt = edge[2];
            adjList[u].add(new Pair(v, wt));
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
                    pq.add(new Pair(nbr, distance[nbr]));
                }
            }
        }

        for(int i =0;i<V;i++)
        {
            if(distance[i] == Integer.MAX_VALUE )
            {
                distance[i] = -1;
            }
        }
        System.out.println(Arrays.toString(distance));

    }
}

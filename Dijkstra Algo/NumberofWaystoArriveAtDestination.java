package DijkstraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberofWaystoArriveAtDestination {
    public static void main(String[] args) {
        int V = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int[] distance = new int[V];
        int[] ways = new int[V];
        ArrayList<Pair>[] adjList = new ArrayList[V];
        for (int i =0;i<V;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : roads)
        {
            int u = edge[0]; int v = edge[1]; int wt = edge[2];
            adjList[u].add(new Pair(v, wt)); adjList[v].add(new Pair(u, wt));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        ways[0]     =  1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(pq.size() > 0)
        {
            Pair currPair = pq.poll();
            int currNode = currPair.node;
            int currWt   = currPair.weight;

            if(currWt > distance[currNode]) continue;


            for(Pair nbrPair : adjList[currNode])
            {
                int nbr = nbrPair.node;
                int nbrWt = nbrPair.weight;

                if(distance[nbr] > currWt + nbrWt)
                {
                    distance[nbr] = currWt + nbrWt;
                    pq.add(new Pair(nbr, distance[nbr]));
                    ways[nbr] = ways[currNode];
                }
                else if(distance[nbr] == currWt + nbrWt)
                {
                    ways[nbr] = ways[nbr] + ways[currNode];
                }
            }
        }
        System.out.println(Arrays.toString(ways));
        System.out.println("Number of ways to reach dest with minimun cost --" + ways[V-1]);
    }
}

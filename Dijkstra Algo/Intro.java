package DijkstraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair_Impl implements Comparable<Pair_Impl> {

    int node;
    int weight;

    Pair_Impl(int node, int weight)
    {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair_Impl o2)
    {
        return this.weight - o2.weight;
    }

    @Override
    public String toString()
    {
        return this.node + " , " + this.weight;
    }

}
public class Intro {
    public static void main(String[] args) {

        int n = 6;
        ArrayList<Pair_Impl>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[][] edges_with_weight = {{0,1,3},{0,2,1},{1,3,4},{2,3,2},{3,4,2},{3,5,1}};
        for (int[] edge : edges_with_weight)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList[u].add(new Pair_Impl(v, wt));
            adjList[v].add(new Pair_Impl(u, wt));
        }
        System.out.println(Arrays.toString(adjList));
        int src = 0;
        dijkstraAlgo(src, adjList, n);
    }
    public  static void dijkstraAlgo(int src, ArrayList<Pair_Impl>[] adjList, int n)
    {
        int[] distance_from_src = new int[n];
        Arrays.fill(distance_from_src, Integer.MAX_VALUE);

        PriorityQueue<Pair_Impl> pq = new PriorityQueue<>();
        pq.add(new Pair_Impl(src, 0));
        distance_from_src[src] = 0;

        while (pq.size() > 0)
        {
            Pair_Impl currPair = pq.poll();
            int currNode = currPair.node;
            int currWt = currPair.weight;

            for(Pair_Impl neighbour  : adjList[currNode])
            {
                int nbr = neighbour.node;
                int nbr_dist = neighbour.weight;

                int currDist = distance_from_src[nbr];
                int newDistance = currWt + nbr_dist;



                if(currDist > newDistance)
                {
                    distance_from_src[nbr] = newDistance;
                    pq.add(new Pair_Impl(nbr, newDistance));

                }
            }
        }
        System.out.println(Arrays.toString(distance_from_src));

    }
}

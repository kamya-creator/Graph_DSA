package DijkstraAlgo;

import java.util.*;


public class Dijistra_impl {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{1, 0, 1},{0,2,6},{1,2, 3}};
        ArrayList<Pair>[] adjList = new ArrayList[V];
        for(int i =0;i<V;i++)
        {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];

            adjList[src].add(new Pair(dest, wt));
            adjList[dest].add(new Pair(src, wt));
        }

        System.out.println(Arrays.toString(adjList));

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(2, 0));
        int[] cost = new int[V];

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[2] = 0;

        while(queue.size() > 0)
        {
            Pair rem = queue.poll();

            int curr_node = rem.dest;
            int curr_weight = rem.weight;
            System.out.println("Curr Node : " + curr_node + " & " + " Curr Node Weight " + curr_weight);
            for(Pair nbr : adjList[curr_node])
            {
                int nbr_node = nbr.dest;
                int nbr_weight = nbr.weight;

                if(cost[nbr_node] > curr_weight + nbr_weight)
                {
                    cost[nbr_node] = curr_weight + nbr_weight;
                    queue.add(new Pair(nbr_node, cost[nbr_node]));

                    System.out.println(queue);
                }
            }
        }
        System.out.println(Arrays.toString(cost));
    }
}

package DijkstraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathForWeightedGraph {

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        int V  = n + 1;
        ArrayList<Pair>[] adjList = new ArrayList[V];
        for(int i =0; i < V;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0]; int v = edge[1]; int wt = edge[2];

            adjList[u].add(new Pair(v, wt));
            adjList[v].add(new Pair(u, wt));
        }
        System.out.println(Arrays.toString(adjList) + "-----------------");
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        int[] parent = new int[V];
        for(int i =1;i<V;i++)
        {
            parent[i] = i;
        }
        Arrays.fill(dist, Integer.MAX_VALUE);


        pq.add(new Pair(1, 0 ));
        dist[1] = 0;

        while(pq.size() > 0)
        {
            Pair curr = pq.poll();
            int currNode = curr.dest;
            int currWt = curr.weight;

            if(dist[currNode] < currWt)
                continue;


            for(Pair nbrPair : adjList[currNode])
            {
                int currNbr = nbrPair.dest;
                int currNbrWt = nbrPair.weight;

                int currDist = dist[currNbr];
                int newDist = currWt + currNbrWt;

                if(currDist > newDist)
                {
                    pq.add(new Pair(currNbr, newDist));
                    dist[currNbr] = newDist;
                    System.out.println(Arrays.toString(dist));
                    parent[currNbr] = currNode;
                }
            }
        }
        ArrayList<Integer> parentList = new ArrayList<>();
        findParent(parent[n], parent, parentList);
        // System.out.println(Arrays.toString(parent));
        List<Integer> list = new ArrayList<>();

         System.out.println(parentList);

        return list;
    }
    public static void findParent(int parent_, int[] parent, ArrayList<Integer> list)
    {
        if(parent_ == parent[parent_])
        {
            list.add(parent_);
            return;
        }
        findParent(parent[parent_], parent, list);
        list.add(parent_);
    }

    public static void main(String[] args) {
        int n = 5, m= 6;
        int[][] edges = {{1, 2, 2},{ 2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        List<Integer> integers = shortestPath(n, m, edges);
        System.out.println(integers + "----------");

    }
}

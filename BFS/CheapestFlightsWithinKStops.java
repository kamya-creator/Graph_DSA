package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair implements Comparable<Pair>
{
    int node;
    int wt;
    Pair(int node, int wt)
    {
        this.node = node;
        this.wt = wt;
    }
    @Override
    public int compareTo(Pair o2)
    {
        return this.wt - o2.wt;
    }
}
public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {

       /*
       # Intuition
        Problem at first glance seems like **Dijkstra Algo**, as at first I thought we need only to minimize the cost to reach destination but there is twist.
        Yes we have to reach the destination at minimum cost but be within K stops,(jese ki hame goal tak pahuchna h with minimum effort but within 2-3 years :) , just realting to life)
        So here problem demands to prioritize the number of Stops with minicost over the shorest distance to reach destination.

        We can relate the Stops as level of Tree or Graph
        **Hence BFS would be best suited for this problem.**
        Go with level order traversal (BFS) of graph , keep in mind **level should not exceed k + 2** (inculding src and dest as well in level).

        Caluclate the cost to reach each level node from src node and store it in dist[] array. Whenever the destionation node encountered in BFS's queue polling compare the cost with previously stored cost, if it's min then overwrite it (iska mtlb hua ki hame destionation tak pahuchne ka ek or better rasta mil gya being within K stops).

        **After processing each level nodes, don't forget to increase the level by 1.**

        # Approach
        <!-- Describe your approach to solving the problem. -->

        # Complexity
        - Time complexity: BFS Traversal TC  O(V+E)

        - Space complexity: Storing dist[] array for each node so O(V)
        */


        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        ArrayList<Pair>[] adjList = new ArrayList[n];
        for(int i =0;i<n;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : flights)
        {
            int u = edge[0]; int v = edge[1]; int wt = edge[2];
            adjList[u].add(new Pair(v, wt));
        }
        int[] costToReachEachNode = new int[n];
        Arrays.fill(costToReachEachNode, Integer.MAX_VALUE);
        costToReachEachNode[src] = 0 ;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));

        int level = 0 ;

        while (queue.size() > 0 && level < k + 1)
        {
            int size = queue.size();
            while(size-- > 0)
            {
                Pair currPair = queue.poll();
                int curr_node = currPair.node;
                int curr_wt = currPair.wt;

                for(Pair nbrPair : adjList[curr_node])
                {
                    int nbr = nbrPair.node;
                    int nbrWt = nbrPair.wt;
                    if(costToReachEachNode[nbr] > curr_wt + nbrWt)
                    {
                        costToReachEachNode[nbr] = curr_wt + nbrWt;
                        queue.add(new  Pair(nbr, costToReachEachNode[nbr]));
                    }
                }
            }
            level++;
        }
        System.out.println(level);
        System.out.println(Arrays.toString(costToReachEachNode));
    }
}

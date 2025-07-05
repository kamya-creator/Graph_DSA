package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair_PQ implements Comparable<Pair_PQ>
{
    int cost;
    String psf;

    public Pair_PQ(int cost, String psf) {
        this.cost = cost;
        this.psf = psf;
    }
    @Override
    public String toString()
    {
        return "Cost: " + this.cost + " PathSoFar : " + this.psf;
    }
    @Override
    public int compareTo(Pair_PQ o2)
    {
        return this.cost - o2.cost;
    }


}
class Pair_Weight
{
    int vt;
    int wt;

    Pair_Weight(int vt, int wt)
    {
        this.vt = vt;
        this.wt = wt;
    }

    @Override
    public String toString()
    {
        return "V : " + this.vt + " W : " + this.wt;
    }
}

public class AllPathWeight {
    static String smallestPath ;
    static int smallestPathWeight = Integer.MAX_VALUE;

    static String largestPath;
    static int largestPathWeight = Integer.MIN_VALUE;

    static int ceilPathWeight = Integer.MAX_VALUE;
    static String ceilPath ;

    static int floorPathWeight = Integer.MIN_VALUE;
    static String floorPath ;

    static int kthPathWeight = Integer.MIN_VALUE;
    static String kthLargestPath;

    public static void main(String[] args) {
        int[][] edges = {{0,1,10},{0,3,40},{1,2,10},{3,2,10},{3,4,2},{4,5,3},{5,6,3},{4,6,8}};
        int vertices = 7;

        ArrayList<Pair_Weight>[] adjList = new ArrayList[vertices];
        for (int i = 0;i<vertices;i++)
        {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : edges)
        {
            int v1 = edge[0];
            int v2 = edge[1];
            int weight = edge[2];

            adjList[v1].add(new Pair_Weight(v2, weight));
            adjList[v2].add(new Pair_Weight(v1, weight));
        }
        System.out.println(Arrays.toString(adjList));
        int src = 0, dest = vertices - 1;
        String psf = src + "";
        int k = 3, category = 40, csf = 0;
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair_PQ> pq = new PriorityQueue<>();
        solve(adjList, src, dest, psf, csf, k, category, visited, pq);
        System.out.println("Largest Path : " + largestPath + " @ " + largestPathWeight);
        System.out.println("Smallest Path : " + smallestPath + " @ " + smallestPathWeight);
        System.out.println("Ceil Path to " +category + " :" + ceilPath +" @ " + ceilPathWeight );
        System.out.println("Floor Path to " +category + " :" + floorPath +" @ " + floorPathWeight );
        System.out.println("Kth largest Path is: " +pq.peek());
    }
    public static void solve(ArrayList<Pair_Weight>[] adjList, int src, int dest, String psf, int csf, int k, int category, boolean[] visited, PriorityQueue<Pair_PQ> pq)
    {
        if(src == dest)
        {

            if(largestPathWeight < csf)
            {
                largestPathWeight = csf;
                largestPath = psf;
            }

            if(smallestPathWeight > csf)
            {
                smallestPathWeight = csf;
                smallestPath = psf;
            }

            if(csf > category && csf < ceilPathWeight)
            {
                ceilPathWeight = csf;
                ceilPath = psf;
            }
            if(csf < category && csf > floorPathWeight)
            {
                floorPathWeight = csf;
                floorPath = psf;
            }
            pq.add(new Pair_PQ(csf,psf));
            while (pq.size() > k)
            {
                pq.poll();
            }
            return;

        }


        visited[src] = true;
        for(Pair_Weight p : adjList[src])
        {
            int nbr = p.vt;
            int weight = p.wt;

            if(visited[nbr] == false)
            {
                solve(adjList, nbr,dest, psf + nbr, csf + weight, k, category, visited, pq);
            }
        }
        visited[src] = false;
    }

}

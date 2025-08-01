package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair1 implements Comparable<Pair1>
{
    int node;
    int wt;
    Pair1(int node, int wt)
    {
        this.node = node;
        this.wt  =  wt;
    }
    @Override
    public int compareTo(Pair1 o2)
    {
        return this.wt - o2.wt;
    }
}
public class Min_Cost_to_Connect_All_Points {
    public static int minCostConnectPoints(int[][] house) {
        int n = house.length;
        int V = n;
        ArrayList<Pair1>[] adjList = new ArrayList[V];
        for(int i = 0;i<n;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int i =0; i < n; i++)
        {
            int[] curr = house[i];
            for(int j = i + 1;j<n;j++)
            {
                int[] nbr = house[j];
                int dis   = Math.abs(curr[0] - nbr[0]) + Math.abs(curr[1] - nbr[1]);
                adjList[i].add(new Pair1(j, dis));
                adjList[j].add(new Pair1(i, dis));
            }
        }
        PriorityQueue<Pair1> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        pq.add(new Pair1(0, 0));
        int sum =0;
        while(pq.size() > 0)
        {
            Pair1 rem = pq.poll();
            int currNode = rem.node;
            int currWt   = rem.wt;
            if(visited[currNode]) continue;

            visited[currNode] = true;
            sum = sum + currWt;

            for(Pair1 nbrPair : adjList[currNode])
            {
                int nbr  = nbrPair.node;
                int nbrWt = nbrPair.wt;

                if(visited[nbr] == false)
                {
                    pq.add(new Pair1(nbr, nbrWt));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] houses = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int minCostConnectPointsMSTCost = minCostConnectPoints(houses);
        System.out.println(minCostConnectPointsMSTCost);
    }
}

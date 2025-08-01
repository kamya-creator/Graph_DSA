package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>
{
    int node;
    int parentNode;
    int nodeWt;

    Pair(int wt, int node, int parent)
    {
        this.node = node;
        this.parentNode = parent;
        this.nodeWt = wt;
    }
    @Override
    public int compareTo(Pair o2)
    {
        return this.nodeWt - o2.nodeWt;
    }

}
public class PrimsAlgo {
    public static int spanningTree(int V, int[][] edges) {
        int sum = 0;
        ArrayList<Pair>[] adjList = new ArrayList[V];
        for(int i =0;i<V;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge :edges)
        {
            int u = edge[0], v = edge[1], wt = edge[2];
            adjList[u].add(new Pair(wt, v , -1));
            adjList[v].add(new Pair(wt, u, -1));
        }
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];


        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, -1));

        while(pq.size() > 0)
        {
            Pair rem = pq.poll();
            int currNode = rem.node;
            int currWt = rem.nodeWt;
            int currParent = rem.parentNode;

            if(visited[currNode]) continue;
            visited[currNode] = true;
            sum = sum + currWt;
            parent[currNode] = currParent;

            for(Pair edge : adjList[currNode])
            {
                int nbr = edge.node;
                int wt = edge.nodeWt;

                if(visited[nbr] == false)
                {
                    pq.add(new Pair(wt, nbr, currNode));
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        return sum;

    }

    public static void main(String[] args) {
//        int V = 3, E = 3;
//        int[][] Edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        int V = 7, E = 8;
        int[][] Edges = {{0, 1, 5}, {1, 2, 5}, {0, 3, 20},{2,3,5},{3,4,1},{4,5,2},{5,6,2},{4,6,4}};
        int spanningTreeCost = spanningTree(V, Edges);
        System.out.println("MST Cost " + spanningTreeCost);

    }
}

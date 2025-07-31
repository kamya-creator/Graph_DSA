package BellmanFord_Algo;

import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
//        int V = 5;
//        int[][] edges= {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
//        int src = 0;
        int V = 4;
        int edges[][] = {{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}};
        int src = 0;
        /*
        Bellman ford algo says, go edges wise and relax each edge V - 1 times,
         after relaxing V - 1 times you will get ur ans in dist[] array
         Even after relaxing V - 1 times if , you relax edges one more time and any dist[node] get changed then it means graph have negative
         cycle( mtlab graph m overall weights ka sum -ve h) then return -1 otherwise return dist[]
         */
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]  = 0;
        for (int i = 0; i < V - 1; i++) {

            for(int[] edge :edges)
            {
                int u = edge[0], v = edge[1], wt = edge[2];

                if(dist[u] != Integer.MAX_VALUE)
                {
                    if(dist[v] > dist[u] + wt)
                    {
                        // relaxing step
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        boolean didURelaxeOneMoreTime = false;
        for (int i = 0; i < V - 1; i++) {

            for(int[] edge :edges) {
                int u = edge[0], v = edge[1], wt = edge[2];

                if (dist[u] != Integer.MAX_VALUE) {
                    if (dist[v] > dist[u] + wt) {
                        // relaxing step
                        dist[v] = dist[u] + wt;
                        didURelaxeOneMoreTime = true;
                        break;
                    }
                }
            }
        }
        if(didURelaxeOneMoreTime) System.out.println("Negative Cycle detected");
        System.out.println(Arrays.toString(dist));
    }
}

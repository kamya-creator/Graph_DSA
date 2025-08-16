package Graph_Level_2;
import java.util.*;

class Pair3 implements Comparable<Pair3>
{
    int u ;
    int v;
    int wt;
    Pair3(int u, int v, int wt)
    {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    @Override
    public int compareTo(Pair3 o2)
    {
        return this.wt - o2.wt;
    }

    @Override
    public String toString()
    {
        return u  + " " + v + " " + wt;
    }
}
public class Optimize_Water_Distribution {
    
    public static int find(int x, int[] parent)
    {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
    public static void union(int x, int y, int[] parent, int[] rank)
    {
        int x_ult_parent = find(x, parent);
        int y_ult_parent = find(y, parent);
        if(x_ult_parent == y_ult_parent) return;
        if(rank[x_ult_parent] > rank[y_ult_parent])
        {
            parent[y_ult_parent] = x_ult_parent;
        }
        else if(rank[y_ult_parent] > rank[x_ult_parent])
        {
            parent[x_ult_parent] = y_ult_parent;
        }
        else{
            parent[x_ult_parent] = y_ult_parent;
            rank[y_ult_parent]++;
        }
    }
    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {

        int[] parent = new int[n+1];
        for(int i = 1 ;i < n + 1;i++)
        {
            parent[i] = i;
        }
        int[] rank = new int[n+1];
        ArrayList<Pair3> adj = new ArrayList<>();
        for(int[] pipe : pipes)
        {
            adj.add(new Pair3(pipe[0], pipe[1], pipe[2]));
        }
        for(int i = 0; i< wells.length ;i++)
        {
            adj.add(new Pair3(0, i + 1, wells[i]));
        }
        Collections.sort(adj);

        //System.out.println(adj);
        int MSTCost = 0;
        for(int i = 0; i < adj.size();i++)
        {
            Pair3 curr = adj.get(i);
            int curr_x = curr.u;
            int curr_y = curr.v;
            int curr_wt = curr.wt;

            if(find(curr_x, parent) != find(curr_y, parent))
            {
                union(curr_x, curr_y, parent, rank);
                MSTCost += curr_wt;
            }
        }
        return MSTCost;

    }

    public static void main(String[] args) {
        int[][] pipes = {{1,2,2},{2,3,4},{1,4,12},{2,4,8},{2,5,14},{3,5,7}};
        int[] wells = {3,9,3,10,6};
        int water = supplyWater(5, pipes.length, wells, pipes);
        System.out.println(water);

    }

}

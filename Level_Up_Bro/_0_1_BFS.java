package Graph_Level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Pair2
{
    int vt;
    int wt;
    Pair2(int vt, int wt)
    {
        this.vt = vt;
        this.wt = wt;
    }
    @Override
    public String toString()
    {
        return vt + "  " + wt;
    }
}
public class _0_1_BFS {
    public static void main(String[] args) {
        int[][] edge = { {1,2},{6,2},{3,2},{3,4},{7,4},{7,5},{5,6}};
        int vertex   = edge.length;

        ArrayList<Pair2>[] adjList = new ArrayList[vertex];
        boolean[] visited          = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edg : edge)
        {
            int src  = edg[0];
            int dest = edg[1];
            adjList[src - 1].add(new Pair2(dest - 1, 0));
            adjList[dest - 1].add(new Pair2(src - 1,  1));
        }
        System.out.println(Arrays.toString(adjList));

        LinkedList<Pair2> queue = new LinkedList<>();
        queue.add(new Pair2(0, 0));

        while(queue.size() > 0)
        {
            Pair2 rem = queue.poll();
            int curr_vtx   = rem.vt;
            int curr_wt    = rem.wt;

            if(curr_vtx == vertex - 1)
            {
                System.out.println("Final Cost to reach dest : " + curr_wt);
                return;
            }
            visited[curr_vtx] = true;
            for (Pair2 nbr : adjList[curr_vtx])
            {
                int curr_nbr    = nbr.vt;
                int curr_nbr_wt = nbr.wt;

                if(visited[curr_nbr] == false)
                {
                    if(curr_nbr_wt == 0)
                    {
                     queue.addFirst(new Pair2(curr_nbr, curr_wt + 0));
                    }
                    else if(curr_nbr_wt == 1)
                    {
                        queue.addLast(new Pair2(curr_nbr, curr_wt +  1));
                    }
                }
            }
        }

        System.out.println("Final Cost to reach dest : " + -1);


    }
}

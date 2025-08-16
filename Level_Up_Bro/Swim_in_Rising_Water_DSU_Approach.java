package Graph_Level_2;

import java.util.ArrayList;
import java.util.Collections;

public class Swim_in_Rising_Water_DSU_Approach {
    class Pair implements Comparable<Pair>
    {
        int i;
        int j;
        int wt;
        Pair(int i, int j, int wt)
        {
            this.i =i;
            this.j =j;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair o2)
        {
            return this.wt - o2.wt;
        }

        @Override
        public String toString()
        {
            return i + " " + j + " " + wt;
        }

    }
        int find(int x, int[] parent)
        {
            if(x == parent[x]) return x;
            return parent[x] = find(parent[x], parent);
        }
        void  union(int x, int y, int[] parent, int[] rank)
        {
            int x_ult_parent = find(x, parent);
            int y_ult_parent = find(y, parent);
            if(x_ult_parent == y_ult_parent) return;

            if(rank[x_ult_parent] > rank[y_ult_parent])
            {
                parent[y_ult_parent] = x_ult_parent;
            }
            else if(rank[x_ult_parent] < rank[y_ult_parent])
            {
                parent[x_ult_parent] = y_ult_parent;
            }
            else{
                parent[x_ult_parent] = y_ult_parent;
                rank[y_ult_parent]++;
            }
        }
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            int[] parent = new int[n*n];
            int[] rank   = new int[n*n];
            for(int i =0;i<parent.length;i++)
            {
                parent[i] = i;
            }
            int[][] dir = {{0,1},{1,0},{-1, 0},{0, -1}};
            ArrayList<Pair> list = new ArrayList<>();
            for(int i =0;i<n;i++)
            {
                for(int j = 0 ;j < n ; j ++)
                {
                    int val      = grid[i][j];
                    list.add(new Pair(i, j, val));
                }
            }
            Collections.sort(list);
            //System.out.println(list.size());
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i++)
            {
                Pair curr = list.get(i);
                int   x   = curr.i;
                int   y   = curr.j;
                int  wt   = curr.wt;
                int currCell = x * n + y;

                // System.out.println(currCell + " curr ");
                for(int j = 0; j < 4; j++)
                {
                    int nbr_x = x + dir[j][0];
                    int nbr_y = y + dir[j][1];

                    if(nbr_x >= 0 && nbr_y >= 0 && nbr_x < n && nbr_y < n)
                    {
                        int nbrCell = nbr_x * n + nbr_y;

                        //System.out.println(currCell + " " + nbrCell);
                        if(grid[nbr_x][nbr_y] <= wt && find(currCell , parent) != find(nbrCell, parent)) {   // ✅ ensure neighbor is accessible
                            union(currCell, nbrCell, parent, rank);
                        }
                    }
                }

                if(find(0, parent) == find((n-1) * n + (n -1), parent))
                {
                    return wt;
                }

            }
            return -1;
        }

    public static void main(String[] args) {
        Swim_in_Rising_Water_DSU_Approach obj = new Swim_in_Rising_Water_DSU_Approach();
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        int water = obj.swimInWater(grid);
        System.out.println(water);
    }
}

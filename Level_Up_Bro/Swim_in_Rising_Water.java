package Graph_Level_2;

import java.util.PriorityQueue;

public class Swim_in_Rising_Water {

    class Pair implements Comparable<Pair>
    {
        int i;
        int j;
        int wt;
        Pair(int i, int j, int wt)
        {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair o2)
        {
            return this.wt - o2.wt;
        }
    }

    public int swimInWater(int[][] grid) {
            int n = grid.length;
            boolean[][] visited = new boolean[n][n];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(0, 0, grid[0][0]));
            int globalMIN = Integer.MAX_VALUE;
            int[][] dir = {{1, 0},{0, 1},{0, -1},{-1, 0}};
            while(pq.size() > 0)
            {
                Pair rem = pq.poll();
                int x    = rem.i;
                int y    = rem.j;
                int cost = rem.wt;
                visited[x][y] = true;
                if(x == grid.length -1 && y == grid.length -1)
                {
                    globalMIN = Math.min(globalMIN, cost);
                }
                for(int i =0;i<4;i++)
                {
                    int nbr_x = x + dir[i][0];
                    int nbr_y = y + dir[i][1];

                    if(nbr_x >=0 && nbr_y >= 0 && nbr_x < grid.length && nbr_y < grid.length && visited[nbr_x][nbr_y] == false)
                    {
                        int localMax = Math.max(cost,grid[nbr_x][nbr_y]);
                        pq.add(new Pair(nbr_x, nbr_y, localMax));
                    }

                }
            }
            return globalMIN;
        }
       public static void main(String[] args) {
           Swim_in_Rising_Water obj = new Swim_in_Rising_Water();
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

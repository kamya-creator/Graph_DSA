package Graph_Level_2;


import java.util.LinkedList;
import java.util.Queue;

public class RottemOrranges {
    static class Pair
    {
        int x;
        int y;
        int level;
        Pair(int row, int col, int level)
        {
            this.x = row;
            this.y = col;
            this.level = level;
        }
    }

        public static int bfs(Queue<Pair> queue, int[][] grid, boolean[][] visited, int freshCount, int[][] time)
        {
            int n = grid.length;
            int m = grid[0].length;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int ans  = 0;
            while(queue.size() > 0)
            {

                Pair rem = queue.poll();
                int curr_x = rem.x; int curr_y = rem.y; int curr_level = rem.level;
                 ans = Math.max(curr_level ,ans );

                for(int i =0;i<4;i++)
                {
                    int nbr_x = curr_x + dx[i];
                    int nbr_y = curr_y + dy[i];
                    if(isValid(nbr_x, nbr_y, grid.length, grid[0].length) &&  grid[nbr_x][nbr_y] == 1 && visited[nbr_x][nbr_y] == false)
                    {
                        grid[nbr_x][nbr_y] = 2;
                        queue.add(new Pair(nbr_x, nbr_y, curr_level + 1));
                        time[nbr_x][nbr_y] = curr_level + 1;
                        visited[nbr_x][nbr_y] = true;
                        freshCount--;
                    }
                }
            }
            if(freshCount != 0) return -1;


            return ans;
        }
        public static boolean isValid(int i, int j, int n, int m)
        {
            return i >=0 && j >= 0 && i < n && j <m;
        }
        public  static int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] visited = new boolean[n][m];
            int[][] time = new int[n][m];
            Queue<Pair> queue = new LinkedList<>();
            int freshCount  = 0;
            for(int i = 0 ;i < n;i++)
            {
                for(int j  = 0 ;j < m ; j ++)
                {
                    if(grid[i][j] == 2)
                    {
                        visited[i][j] = true;
                        queue.add(new Pair(i, j, 0));
                    }
                    if(grid[i][j] == 1)
                    {
                        freshCount++;
                    }
                }
            }
            if(freshCount == 0) return 0;
            int ans = bfs(queue, grid, visited, freshCount, time);
            return ans;
        }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 2, 1}
        };

        int i = orangesRotting(grid);
        System.out.println(i);
    }
}


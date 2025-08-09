package Graph_Level_2;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
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
        public  static int bfs(Queue<Pair> queue , int[][] grid, boolean[][] visited )
        {
            int n = grid.length; int m = grid[0].length;
            int ans = 0 ;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            while(queue.size() > 0)
            {
                Pair rem = queue.poll();
                int curr_x = rem.x; int curr_y = rem.y ; int curr_level = rem.level;
                ans = Math.max(ans, curr_level);
                for(int i =0;i<4;i++)
                {
                    int nbr_x = curr_x + dx[i];
                    int nbr_y = curr_y + dy[i];
                    if(isValid(nbr_x, nbr_y, n, m) && grid[nbr_x][nbr_y] == 0 && visited[nbr_x][nbr_y] == false)
                    {
                        visited[nbr_x][nbr_y]  = true;
                        queue.add(new Pair(nbr_x, nbr_y, curr_level + 1));
                    }
                }
            }
            if(ans == 0) ans = -1;
            return ans;
        }
        public static boolean isValid(int i, int j, int n, int m)
        {
            return i >=0 && j >= 0 && i < n && j <m;
        }
        public  static int maxDistance(int[][] grid) {
            int n = grid.length; int m = grid[0].length;
            boolean[][] visited = new boolean[n][m];
            Queue<Pair> queue = new LinkedList<>();
            for(int i = 0 ;i < n;i++)
            {
                for(int j  = 0 ;j < m ; j ++)
                {
                    if(grid[i][j] == 1)
                    {
                        visited[i][j] = true;
                        queue.add(new Pair(i, j, 0));
                    }
                }
            }
            if(queue.size() == 0) return -1;
            return bfs(queue, grid, visited);
        }

    public static void main(String[] args) {

        int[][] grid = {{1,0,1},{0,0,0},{1, 0,1}};
        int maxDistance = maxDistance(grid);
        System.out.println(maxDistance);
    }
}

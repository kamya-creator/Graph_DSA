package Graph_Level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Bridge {
    public static int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean flag = false;
        Queue<Pair> coordinatesOfIsland1 = new LinkedList<>();

        // find island 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                {
                    flag = true;
                    // DFS on island 1
                    dfs(i, j, grid, coordinatesOfIsland1);
                    break;
                }
            }
            if(flag)
                break;
        }
        // BFS from island1 to find island2
        int ans = bfs(coordinatesOfIsland1, grid);
        return ans;
    }
    public static int bfs(Queue<Pair> queue, int[][] grid)
    {

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(queue.size() > 0)
        {
            Pair rem = queue.poll();
            int curr_x = rem.x; int curr_y = rem.y; int curr_level = rem.level;

            for (int i = 0; i < 4; i++) {
                int nbr_x = curr_x + dx[i];
                int nbr_y = curr_y + dy[i];

                if(isValid(nbr_x, nbr_y, n, m) && grid[nbr_x][nbr_y] == 1) {

                    return curr_level;
                }
                if(isValid(nbr_x, nbr_y, n, m) && grid[nbr_x][nbr_y] == 0 && visited[nbr_x][nbr_y] == false)
                {

                    visited[nbr_x][nbr_y] = true;
                    queue.add(new Pair(nbr_x, nbr_y, curr_level + 1));
                }
            }

        }
        return -1;
    }
    public static boolean isValid(int i, int j, int n, int m)
    {
        return i >=0 && j >= 0 && i < n && j <m;
    }
    public static void dfs(int i, int j, int[][] grid, Queue<Pair> coordinates)
    {
        if(i<0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;

        coordinates.add(new Pair(i, j, 0));
        grid[i][j] = 0;

        dfs(i, j + 1, grid, coordinates);
        dfs(i, j - 1, grid, coordinates);
        dfs(i + 1, j, grid, coordinates);
        dfs(i-1,   j, grid, coordinates);



    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},{1,1,0,1,1},{1,1,0,0,0}};
        int shortestBridge = shortestBridge(grid);
        System.out.println(shortestBridge);
    }
}

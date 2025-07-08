package org.example;

public class MaximumNumberofFishinaGrid {
    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        int maxFish = 0;
        int n = grid.length; int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(visited[i][j] == false && grid[i][j] > 0)
                {
                    int[] countFish = {0};
                    dfs(i, j, grid, visited, countFish);
                    maxFish = Math.max(countFish[0], maxFish);
                }
            }
        }
        System.out.println(maxFish);
    }
    public static void dfs(int r, int c, int[][] grid, boolean[][] visited, int[] countFish)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c] == 0)
        {
            return;
        }
        visited[r][c] = true;
        countFish[0] += grid[r][c];

        dfs(r-1, c, grid, visited, countFish);
        dfs(r+1, c, grid, visited, countFish);
        dfs(r, c -1, grid, visited, countFish);
        dfs(r,  c + 1, grid, visited, countFish);
    }
}

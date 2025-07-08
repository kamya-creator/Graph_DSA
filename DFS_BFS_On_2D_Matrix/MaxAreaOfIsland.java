package org.example;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int maxArea = 0; int n = grid.length ; int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                {
                    int[] area = {0};
                    dfs(i, j, grid, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }
        System.out.println("Max Area : " + maxArea);
    }
    public static void dfs(int r, int c, int[][] grid, int[] area)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||  grid[r][c] == 0)
        {
            return;
        }

        grid[r][c] = 0;
        area[0]++;
        dfs(r - 1, c, grid, area);
        dfs(r + 1, c, grid, area);
        dfs(r, c -1, grid, area);
        dfs(r, c + 1, grid, area);

    }
}

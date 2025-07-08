package org.example;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        int n = grid.length;
        int m = grid[0].length;
        int[] prem = new int[1] ;
        // DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                {
                    prem[0] = 0;
                    dfs(i, j, grid,prem);
                }
            }
        }
        System.out.println("Perimeter :" + prem[0]);
    }
    public static void dfs(int r,int c, int[][] grid, int[] prem)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || grid[r][c] == -1)
        {
            return;
        }

        grid[r][c] = -1;
        if(isOutOfBoxOrWater(r-1, c, grid))
        {
            prem[0]++;
        }
        if(isOutOfBoxOrWater(r+1, c, grid))
        {
            prem[0]++;
        }
        if(isOutOfBoxOrWater(r, c - 1, grid))
        {
            prem[0]++;
        }
        if(isOutOfBoxOrWater(r, c + 1, grid))
        {
            prem[0]++;
        }

        dfs(r-1, c, grid, prem);
        dfs(r+1, c, grid, prem);
        dfs(r, c -1, grid, prem);
        dfs(r, c + 1, grid, prem);
    }
    public static boolean isOutOfBoxOrWater(int r, int c, int[][] grid)
    {
        if(r < 0 || c < 0 || r>= grid.length || c >= grid[0].length || grid[r][c] == 0)
        {
            return true;
        }
        return false;
    }
}

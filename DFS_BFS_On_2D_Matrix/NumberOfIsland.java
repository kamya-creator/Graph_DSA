package org.example;

public class NumberOfIsland {
    public static void main(String[] args) {
        /*
        Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
         */
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int countOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false)
                {
                    dfs(grid, i, j, visited);
                    countOfIsland++;
                }
            }
        }
        System.out.println(countOfIsland);
    }
    public static void dfs(int[][] grid, int r, int c, boolean[][] visited)
    {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == 0 || visited[r][c] == true)
        {
            return;
        }
        visited[r][c] = true;
        dfs(grid, r - 1,c, visited );
        dfs(grid, r + 1, c, visited);
        dfs(grid, r , c -1, visited);
        dfs(grid, r, c + 1, visited);
    }
}

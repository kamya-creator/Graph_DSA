package Graph_Level_2;

public class Number_of_Enclaves {
    public static void dfs(int i, int j, int[][] grid, boolean[][] visited)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == 0)
        {
            return;
        }

        visited[i][j] = true;
        grid[i][j] = 0;
        dfs(i - 1, j , grid, visited);
        dfs(i + 1, j , grid, visited);
        dfs(i, j + 1 , grid, visited);
        dfs(i , j - 1 , grid, visited);


    }
    public static  int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int j = 0 ; j < m ; j++)
        {
            if(grid[0][j] == 1)
                dfs(0, j, grid, visited);

            if(grid[n-1][j] == 1)
                dfs(n -1, j, grid, visited);
        }

        for(int i = 0 ;i < n ;i++)
        {
            if(grid[i][0] == 1)
                dfs(i, 0, grid, visited);

            if(grid[i][m-1] == 1)
                dfs(i, m -1, grid, visited);
        }

        int res = 0;

        for(int i =0;i<n;i++)
        {
            for(int j =0 ;j < m;j++)
            {
                if(grid[i][j] == 1)
                    res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int numEnclaves = numEnclaves(grid);
        System.out.println(numEnclaves);
    }
}

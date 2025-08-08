package Graph_Level_2;

import java.util.HashSet;

public class Number_of_Distinct_Islands {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public  static  void dfs(int i, int j, int n, int m, int[][] grid, boolean[][] visited, StringBuilder psf)
    {

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || visited[i][j] == true)
        {
            return;
        }
        visited[i][j] = true;
        for(int k = 0 ; k < 4; k++ )
        {
            int nbr_x = i + dx[k];
            int nbr_y = j + dy[k];
            if(isValid(nbr_x, nbr_y, n , m) && grid[nbr_x][nbr_y] == 1 && visited[nbr_x][nbr_y] == false)
            {
                if(k == 0)
                    psf.append("u");

                if(k == 1)
                    psf.append("r");

                if(k == 2)
                    psf.append("d");

                if(k == 3)
                    psf.append("l");

                dfs(nbr_x, nbr_y,n , m, grid, visited, psf);
                psf.append("Z");
            }
        }
    }
    static boolean  isValid(int i, int j , int n, int m)
    {
        return i>=0 && j >= 0 && i < n && j < m;
    }
    static int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ;i < n ;i++)
        {
            for(int j = 0 ;j < m ; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == false)
                {

                    StringBuilder psf = new StringBuilder();
                    psf.append("b");
                    dfs(i, j , n, m, grid, visited, psf);
                    set.add(psf.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();

    }
    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        int distinctIslands = countDistinctIslands(grid);
        System.out.println(distinctIslands);

    }
}

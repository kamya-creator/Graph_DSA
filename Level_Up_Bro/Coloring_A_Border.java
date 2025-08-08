package Graph_Level_2;

import java.util.Arrays;

public class Coloring_A_Border {
    public  static void dfs(int[][] grid, int i, int j, boolean[][] visited, int color, int targetColor)
    {
        visited[i][j] = true;
        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, 1, 0 , -1};

        for (int k = 0; k < 4; k++) {
            int nbr_x = i + dx[k];
            int nbr_y = j + dy[k];

            if(isValidIndexAndUnVisited(nbr_x, nbr_y, grid.length, grid[0].length, visited) && grid[nbr_x][nbr_y] == color)
            {
                dfs(grid, nbr_x, nbr_y, visited, color, targetColor);
            }
        }

    }
    public static boolean isValidIndexAndUnVisited(int i, int j, int n, int m, boolean[][] visited)
    {
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] == true ) return false;

        return true;
    }
    public static boolean isValid(int i, int j, int n, int m)
    {
        if(i < 0 || j < 0 || i >= n || j >= m  ) return false;

        return true;
    }
    public  static int[][] colorBorder(int[][] grid, int row, int col, int color)
    {
        int n = grid.length; int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int srcColor = grid[row][col];

        dfs(grid, row, col, visited, srcColor,color);


        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, 1, 0 , -1};

        int[][] nbrCount = new int[n][m];
        int[][] ans = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] == true)
                {
                    for (int k = 0; k < 4; k++) {
                        int nbr_x = i + dx[k];
                        int nbr_y = j + dy[k];

                        if(isValid(nbr_x, nbr_y, n, m) && visited[nbr_x][nbr_y] == true)
                        {
                            nbrCount[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(nbrCount[i][j] > 0 && nbrCount[i][j] < 4)
                {
                    ans[i][j] = color;
                }
            }
        }
        if(nbrCount[row][col] == 0) ans[row][col] = color;
        return ans;

    }

    public static void main(String[] args) {
//        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
//        int row = 1, col = 1, color = 2;
        int[][] grid = {{1,1,1,2,2},{2, 1,2,2,2},{1,1,2,2,1}};
        int row = 1, col = 0, color = 3;
        int[][] coloredBorder = colorBorder(grid, row, col, color);
        for (int i = 0; i < coloredBorder.length; i++) {
            System.out.println(Arrays.toString(coloredBorder[i]));
        }
    }

}


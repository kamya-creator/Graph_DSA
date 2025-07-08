package org.example;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {

         int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
         int sr = 1, sc = 1, color = 2;
         int n = image.length ; int m = image[0].length;
         boolean[][] visited  = new boolean[n][m];
         int expected = image[sr][sc];
         dfs(sr, sc, image, visited, expected, color);

         for (int[] img : image)
        System.out.println(Arrays.toString(img));
    }
    public static void dfs(int r, int c, int[][] image, boolean[][] visited, int expected, int color)
    {
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || visited[r][c] == true || image[r][c] != expected)
        {
            return;
        }

        visited[r][c] = true;
        image[r][c] = color;
        dfs(r-1, c, image, visited, expected, color);
        dfs(r + 1, c, image, visited, expected, color);
        dfs(r, c + 1, image, visited, expected, color);
        dfs(r, c -1, image, visited, expected, color);

    }
}

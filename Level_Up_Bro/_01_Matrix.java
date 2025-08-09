package Graph_Level_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    int x;
    int y;
    int level;
    Pair(int x, int y, int level)
    {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
public class _01_Matrix {
    public static void bfs(Queue<Pair> queue , boolean[][] visited, int[][] ans)
    {

        int n = ans.length; int m = ans[0].length;
        int[] dx = {1, -1,0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!queue.isEmpty())
        {
            Pair rem = queue.poll();
            int curr_x = rem.x;
            int cuur_y = rem.y;
            int curr_level = rem.level;

            for (int i = 0; i < 4; i++) {
                int nbr_x = curr_x + dx[i];
                int nbr_y = cuur_y + dy[i];

                if(isValid(nbr_x, nbr_y, n, m) && visited[nbr_x][nbr_y] == false)
                {
                    visited[nbr_x][nbr_y] = true;
                    ans[nbr_x][nbr_y] = curr_level + 1;
                    queue.add(new Pair(nbr_x, nbr_y, curr_level + 1));
                }
            }
        }
    }
    public static boolean isValid(int i, int j, int n, int m)
    {
        return i>=0 && j >= 0 && i<n && j<m;
    }
    public static int[][] updateMatrix(int[][] mat) {

        int n = mat.length; int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<Pair>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 0)
                {
                    ans[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        bfs(queue, visited, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {{0,1,1,1}, {1,1,1,1},{1,1,1,1}};
        int[][] updated = updateMatrix(mat);
        for (int i = 0; i < updated.length; i++) {
            System.out.println(Arrays.toString(updated[i]));
        }
    }
}

package BFS;

import java.util.LinkedList;
import java.util.Queue;

class PairCord
{
    int row;
    int col;
    int cost;
    PairCord(int row, int col, int cost)
    {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}
public class ShortestPathInBinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, -1, 0, 1, 1, 1, 0 ,-1};
        int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1};
        Queue<PairCord> queue = new LinkedList<>();
        int[] src = {0, 0}; int[] dest = {n-1, m-1};

        if(grid[src[0]][src[1]] == 1) {
            System.out.println("No Path possible");
            System.exit(0);
        }
        queue.add(new PairCord(src[0], src[1], 1));
        visited[src[0]][src[1]] = true;

        while(queue.size() > 0)
        {
            PairCord currPair = queue.poll();
            int currX = currPair.row;
            int currY = currPair.col;
            int currCost = currPair.cost;

            if(currX == dest[0] && currY == dest[1])
            {
                System.out.println(currCost);
                break;
            }

            for(int i =0;i<8;i++)
            {
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(isSafe(newX, newY, n, m) && visited[newX][newY] == false && grid[newX][newY] == 0)
                {
                    visited[newX][newY] = true;
                    queue.add(new PairCord(newX, newY, currCost + 1));
                }
            }
        }
    }
    public static boolean isSafe(int newX, int newY, int n , int m)
    {
        return newX >= 0 && newY >= 0 && newX < n && newY < m ;
    }
}

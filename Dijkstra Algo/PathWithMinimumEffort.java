package DijkstraAlgo;

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair_Coordinate implements Comparable<Pair_Coordinate>
{
    int x;
    int y;
    int wt;
    Pair_Coordinate(int x, int y, int wt)
    {
        this.x  = x;
        this.y = y;
        this.wt = wt;
    }
    @Override
    public int compareTo(Pair_Coordinate o2)
    {
        return this.wt - o2.wt;
    }
}
public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
        //int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int n = heights.length; int m = heights[0].length;

        int[][] res = new int[n][m];
        for (int[] arr : res)
        {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        res[0][0] = 0;
        PriorityQueue<Pair_Coordinate> pq = new PriorityQueue<>();
        pq.add(new Pair_Coordinate(0, 0, 0));
        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(pq.size() > 0)
        {
            Pair_Coordinate currPair = pq.poll();
            int curr_x               = currPair.x;
            int curr_y               = currPair.y;
            int curr_diff           = currPair.wt;

            for(int i =0;i<4;i++)
            {
                int nbrX = curr_x + dx[i];
                int nbrY = curr_y + dy[i];

                if(isValid(nbrX, nbrY, n, m)) {
                    int nbrDiff = Math.abs(heights[curr_x][curr_y] - heights[nbrX][nbrY]);
                    nbrDiff = Math.max(nbrDiff, curr_diff);

                    if (res[nbrX][nbrY] > nbrDiff) {
                        res[nbrX][nbrY] = nbrDiff;
                        pq.add(new Pair_Coordinate(nbrX, nbrY, nbrDiff));
                    }
                }
            }
        }
        System.out.println(res[n-1][m-1]);
    }
    public static boolean isValid(int x, int y, int n , int m)
    {
        if(x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }
}

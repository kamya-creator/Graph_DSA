package Graph_Level_2;

import java.util.*;
public class NumberOfIslandII {
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
        int[] parent = new int[n*m];
        int[] rank =   new int[n*m];
        Arrays.fill(parent, -1);
        int countofIsland  = 0;
        int[] ans = new int[q];
        int index = -1 ;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] q1 : queries)
        {
            index = index + 1;
            int row = q1[0];
            int col = q1[1];

            int cellNumber = row*m + col;
            parent[cellNumber] = cellNumber;
            rank[cellNumber] = 1;
            countofIsland++;
            ans[index] = countofIsland;

            for(int[] dir : directions)
            {
                int nbr_row = row + dir[0];
                int nbr_col = col + dir[1];
                int nbr_cell_number = nbr_row*m + nbr_col;
                if(nbr_row < 0 || nbr_col < 0 || nbr_row >=n  || nbr_col >= m || parent[nbr_cell_number] == -1)
                {
                    continue;
                }

                // if nbr cell has parent = -1 it means it's island so we have to mearge into it

                int ult_parent_nbr = find(nbr_cell_number, parent);
                int ult_parent_curr = find(cellNumber, parent);
                if(ult_parent_curr != ult_parent_nbr)
                {
                    if(rank[ult_parent_nbr] > rank[ult_parent_curr])
                    {
                        parent[ult_parent_curr] = ult_parent_nbr;
                    }
                    else if(rank[ult_parent_nbr] < rank[ult_parent_curr])
                    {
                        parent[ult_parent_nbr] = ult_parent_curr;
                    }
                    else if(rank[ult_parent_curr] == rank[ult_parent_nbr])
                    {

                        parent[ult_parent_nbr] = ult_parent_curr;
                        rank[ult_parent_curr]++;
                    }
                    countofIsland--;

                    ans[index] = countofIsland;

                }

            }

        }
        return ans;
    }
    public  static int find(int x, int[] parent)
    {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public static void main(String[] args) {
        /*Input: 'n' = 3, 'm' = 4
        'queries' = [[1, 1], [1, 2], [2, 3]]

         */
        int n = 3, m = 4;
        int[][] queries = {{1,1},{1,2},{2,3}};
        int q =queries.length;
        int[] ofIslandII = numberOfIslandII(n, m, queries, q);
        System.out.println(Arrays.toString(ofIslandII));
    }
}

package org.example;

public class BattleshipsInBoard {
    public static void main(String[] args) {
        String[][] board = {{"X",".",".","X"},{".",".",".","X"},{".",".",".","X"}};
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j].equals("X") && visited[i][j] ==false)
                {
                    count++;
                    dfs(i, j , board, visited);
                }
            }
        }
        System.out.println("Number of battleships : "+count);
        /*
        TC - O(n"m) SC  - O(n*m)
        Let's optimized it without using extra space and not modify the existing grid
         */

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j].equals("X"))
                {
                    /*
                    There should not be battleship i.e 'X' on left and Top of current position???
                    Why??? Battleship form only horizontally and vertically X cells and there is no overlapping battleships are present in grid
                     */
                    // check for top
                    int prev_top_row = i - 1;
                    int prev_top_col = j;

                    // check for left
                    int prev_left_row = i;
                    int pre_left_col = j - 1;

                    if( ( pre_left_col < 0 || board[prev_left_row][pre_left_col].equals(".") ) &&
                            (prev_top_row < 0 || board[prev_top_row][prev_top_col].equals("."))){
                        count++;
                    }

                }
            }
        }
        System.out.println("Count is : " + count);
    }
    public static void dfs(int r, int c, String[][] grid, boolean[][] visited)
    {
        if(r < 0 ||c < 0 || r>=grid.length || c >= grid[0].length || visited[r][c] == true || grid[r][c].equals("."))
        {
            return;
        }
        visited[r][c] = true;
        dfs(r -1, c, grid, visited);
        dfs(r +1, c, grid, visited);
        dfs(r, c - 1, grid, visited);
        dfs(r, c + 1, grid, visited);
    }
}

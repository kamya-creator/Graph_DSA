package org.example;

public class SurroundedRegion {
    public static void main(String[] args) {
        /*
        [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
         */
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
        int n = board.length;
        int m = board[0].length;

        // Step1 : DFS at borders of board - mark all O's of border and connected O's from border as '#'

        // top border
        for (int i = 0; i < m; i++) {
            if(board[0][i] == 'O')
            {
                dfs(0, i, n, m , board);
            }
        }

        // bottom border
        for (int i = 0; i < m; i++) {
            if(board[n-1][i] == 'O')
            {
                dfs(n-1, i, n, m , board);
            }
        }

        // left border
        for (int j = 0; j < n; j++) {
            if(board[j][0] == 'O')
            {
                dfs(j, 0, n, m , board);
            }
        }

        // right border
        for (int j = 0; j < n; j++) {
            if(board[j][m-1] == 'O')
            {
                dfs(j, m-1, n, m , board);
            }
        }

        // Step 2 : Flip all safe O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println("The Border and connected to border has be marked '#'");
        display(board);
        // Step 3 : Revert back all boarder O's and connected to them into it's original character i.e 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == '#')
                {
                    board[i][j] = 'O';
                }
            }
        }

        System.out.println("Final ANS_--------------------------");
        display(board);
    }
    public static void dfs(int r, int c, int row, int col, char[][] board)
    {
        if(r < 0 || c < 0 || r >= row || c >= col || board[r][c] == '#' || board[r][c] == 'X')
        {
            return;
        }

        board[r][c] = '#';
        dfs(r-1, c, row, col, board);
        dfs(r + 1, c, row, col, board);
        dfs(r, c - 1, row, col, board);
        dfs(r, c + 1, row, col, board);
    }
    public static void display(char[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

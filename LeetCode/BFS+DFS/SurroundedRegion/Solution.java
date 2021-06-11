/*
Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/
class Solution {
    private int rows = 0;
    private int cols = 0;
    
    private void dfs(char[][] board, int r, int c){
        board[r][c] = 'Y';
        if(c > 0 && board[r][c - 1] == 'O'){
            dfs(board, r, c - 1);
        }
        
        if(r > 0 && board[r - 1][c] == 'O'){
            dfs(board, r - 1, c);
        }
        
        if(c < cols - 1 && board[r][c + 1] == 'O'){
            dfs(board, r, c + 1);
        }
        
        if(r < rows - 1 && board[r + 1][c] == 'O'){
            dfs(board, r + 1, c);
        }
    }
    public void solve(char[][] board) {
        rows = board.length;
        if(rows == 0)
            return;
        cols = board[0].length;
        int row = 0;
        for(int c = 0; c < cols; c++){
            if(board[row][c] == 'O')
                dfs(board, row, c);
        }
        row = rows - 1;
        for(int c = 0; c < cols; c++){
            if(board[row][c] == 'O')
                dfs(board, row, c);
        }
        
        int col = 0;
        for(int r = 0; r < rows; r++){
            if(board[r][col] == 'O')
                dfs(board, r, col);
        }
        
        col = cols - 1;
        for(int r = 0; r < rows; r++){
            if(board[r][col] == 'O')
                dfs(board, r, col);
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                } else if(board[r][c] == 'Y'){
                    board[r][c] = 'O';
                }
            }
        }
    }
}

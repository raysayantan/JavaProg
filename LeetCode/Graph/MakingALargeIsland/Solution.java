/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
*/
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] area = new int[n*n + 2];
        int col = 2;
        boolean hasZero = false;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0) hasZero = true;
                if(grid[r][c] == 1){
                    grid[r][c] = col;
                    area[col] = dfs(grid, r, c, col);
                    col++;
                }
            }
        }
        
        if(hasZero == false) return n*n;
        int ans = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0){
                    HashSet<Integer> nbr = new HashSet<>();
                    if(c - 1 >= 0 && grid[r][c - 1] >= 2){
                        nbr.add(grid[r][c - 1]);
                    }
                    
                    if(r - 1 >= 0 && grid[r - 1][c] >= 2){
                         nbr.add(grid[r - 1][c]);
                    }
                    
                    if(c + 1 < grid.length && grid[r][c + 1] >= 2){
                         nbr.add(grid[r][c + 1]);
                    }
                    
                    if(r + 1 < grid.length && grid[r + 1][c] >= 2){
                         nbr.add(grid[r + 1][c]);
                    }
                    
                    int sum = 1;
                    for(int idx : nbr){
                        sum += area[idx];
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int r, int c, int col){
        int res = 1;
        grid[r][c] = col;
        if(c - 1 >= 0 && grid[r][c - 1] == 1){
            res += dfs(grid, r, c - 1, col);
        }
        
        if(r - 1 >= 0 && grid[r - 1][c] == 1){
            res += dfs(grid, r - 1, c, col);
        }
        
        if(c + 1 < grid.length && grid[r][c + 1] == 1){
            res += dfs(grid, r, c + 1, col);
        }
        
        if(r + 1 < grid.length && grid[r + 1][c] == 1){
            res += dfs(grid, r + 1, c, col);
        }
        
        return res;
    }
}

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int total = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    q.add(new ArrayList<>(Arrays.asList(r,c)));
                }
            }
        }
        
        while(!q.isEmpty()){
            List<Integer> l = q.remove();
            int r = l.get(0);
            int c = l.get(1);
            if(grid[r][c] < 0) continue;
            //left
            if(c > 0){
                if(grid[r][c - 1] >= 1){
                    if(grid[r][c - 1] == 1){
                        grid[r][c - 1] = grid[r][c] + 1;
                    } else if(grid[r][c - 1] > 2){
                        grid[r][c - 1] = Math.min(grid[r][c - 1], grid[r][c] + 1);
                    }
                    q.add(Arrays.asList(r, c - 1));
                }
            }
            
            //top
            if(r > 0){
                if(grid[r - 1][c] >= 1){
                    if(grid[r - 1][c] == 1){
                        grid[r - 1][c] = grid[r][c] + 1;
                    } else if(grid[r - 1][c] > 2){
                        grid[r - 1][c] = Math.min(grid[r - 1][c], grid[r][c] + 1);
                    }
                    q.add(Arrays.asList(r - 1, c));
                }
            }
            
            //right
            if(c + 1 < cols){
                if(grid[r][c + 1] >= 1){
                    if(grid[r][c + 1] == 1){
                        grid[r][c + 1] = grid[r][c] + 1; 
                    } else if(grid[r][c + 1] > 2){
                        grid[r][c + 1] = Math.min(grid[r][c + 1], grid[r][c] + 1);
                    }
                    q.add(Arrays.asList(r, c + 1));
                }
            }
            
            //bottom
            if(r + 1 < rows){
                if(grid[r + 1][c] >= 1){
                    if(grid[r + 1][c] == 1){
                        grid[r + 1][c] = grid[r][c] + 1;
                    } else if(grid[r + 1][c] > 2){
                        grid[r + 1][c] = Math.min(grid[r][c] + 1,grid[r + 1][c]);
                    }
                    q.add(Arrays.asList(r + 1, c));
                }
            }
            
            grid[r][c] = -grid[r][c];
        }
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                //System.out.print(grid[r][c] + " ");
                if(grid[r][c] == 1){
                    return -1;
                }
                total = Math.max(total, Math.abs(grid[r][c]));
            }
            //System.out.println("");
        }
        if(total >= 2)
            total = total - 2;
        return total;
    }
}

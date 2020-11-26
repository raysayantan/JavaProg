class Solution {
    private int rows;
    private int cols;
    private boolean helper(int time, int[][] grid){
        boolean isContinue = false;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == time){
                    isContinue = true;
                    //left
                    if(c > 0){
                        if(grid[r][c - 1] == 1){
                            grid[r][c - 1] = time + 1;
                        }
                    }
                    
                    //top
                    if(r > 0){
                        if(grid[r - 1][c] == 1){
                            grid[r - 1][c] = time + 1;
                        }
                    }
                    
                    //right
                    if(c + 1 < cols){
                        if(grid[r][c + 1] == 1){
                            grid[r][c + 1] = time + 1;
                        }
                    }
            
                    //bottom
                    if(r + 1 < rows){
                        if(grid[r + 1][c] == 1){
                            grid[r + 1][c] = time + 1;
                        }
                    }
                }
            }
        }
        
        return isContinue;
    }
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int total = 2;
        while(helper(total, grid)){
            total++;
        }    
        //System.out.println(total);
        total = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                //System.out.print(grid[r][c] + " ");
                if(grid[r][c] == 1){
                    return -1;
                }
                
                total = Math.max(total, grid[r][c]);
            }
            //System.out.println("");
        }
        
        if(total >= 2) 
            total = total - 2;
        
        return total;
    }
}

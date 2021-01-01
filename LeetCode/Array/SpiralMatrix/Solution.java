/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while((rowStart <= rowEnd) && (colStart <= colEnd)){
            //move to the right
            if(colStart <= colEnd && rowStart <= rowEnd){
                for(int idx = colStart; idx <= colEnd; idx++){
                    res.add(matrix[rowStart][idx]);
                }
                rowStart++;
            }
            
            //move to the down
            if(colStart <= colEnd && rowStart <= rowEnd){
                for(int idx = rowStart; idx <= rowEnd; idx++){
                    res.add(matrix[idx][colEnd]);
                }
                colEnd--;
            }
            
            //move to the left
            if(colStart <= colEnd && rowStart <= rowEnd){
                for(int idx = colEnd; idx >= colStart; idx--){
                    res.add(matrix[rowEnd][idx]);
                }
                rowEnd--;
            }
            
            //move to the up
            if(colStart <= colEnd && rowStart <= rowEnd){
                for(int idx = rowEnd; idx >= rowStart; idx--){
                    res.add(matrix[idx][colStart]);
                }
                colStart++;
            }
        }
        return res;
    }
}

/*
Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 

Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]
Example 2:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n, K <= 100
1 <= mat[i][j] <= 100
*/
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        //matrix to store the row sum i.e. for a row r and colum c, it wil be sum
        //of all the elements from 0 to c in row r
        int[][] sum = new int[rows + 1][cols + 1];
        for(int r = 0; r <= rows; r++){
            //make first colums to zero
            sum[r][0] = 0;
        }
        
        for(int c = 0; c <= cols; c++){
            //first row to zero
            sum[0][c] = 0;
        }
        
        for(int r = 1; r <= rows; r++){
            for(int c = 1; c <= cols; c++){
                sum[r][c] = sum[r][c - 1] + mat[r - 1][c- 1];
            }
        }
        
        int[][] answer = new int[rows][cols];
        for(int r = 1; r <= rows; r++){
            for(int c = 1; c <= cols; c++){
                int rlow = (r - K) < 1 ? 1 : r - K;
                int rhigh = (r + K) > rows ? rows : r + K;
                int clow = c - (K + 1) < 0 ? 0 : c - (K + 1);
                int chigh = c + K > cols ? cols : c + K;
                for(int s = rlow; s <= rhigh; s++){
                    answer[r - 1][c - 1] += sum[s][chigh] - sum[s][clow];
                } 
            }
        }
        
        return answer;
    }
}

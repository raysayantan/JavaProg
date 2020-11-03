/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
 

Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;
        int[][] dp = new int[alen + 1][blen + 1];
        int maxlen = 0;
        for(int i = 0; i <= alen; i++){
            for(int k = 0; k <= blen; k++){
                if(i == 0 || k == 0){
                    dp[i][k] = 0;
                } else {
                    if(A[i - 1] == B[k - 1]){
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                        maxlen = Math.max(maxlen, dp[i][k]);
                    }
                }
            }
        }
        
        return maxlen;
    }
}

/*
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= A.length == B.length <= 2 * 104
1 <= A[i], B[i] <= 6
*/
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int len = A.length;
        int key = -1;
        for(int idx = 0; idx < len; idx++){
            if(A[idx] == B[idx]){
                int val = 0;
                if(counter.containsKey(A[idx])){
                    val = counter.get(A[idx]);
                }
                counter.put(A[idx], val + 1);
                if(val + 1 == len){
                    key = A[idx];
                    break;
                }
            } else {
                int val1 = 0;
                int val2 = 0;
                if(counter.containsKey(A[idx])){
                    val1 = counter.get(A[idx]);
                }
                if(counter.containsKey(B[idx])){
                    val2 = counter.get(B[idx]);
                }
                counter.put(A[idx], val1 + 1);
                counter.put(B[idx], val2 + 1);
                if(val1 + 1 == len){
                    key = A[idx];
                    break;
                }
                
                if(val2 + 1 == len){
                    key = B[idx];
                    break;
                }
            }
        }
        
        if(key == -1){
            return -1;
        }
        
        int aCnt = 0;
        int bCnt = 0;
        for(int idx = 0; idx < len; idx++){
            if(key != A[idx]) aCnt++;
            if(key != B[idx]) bCnt++;
        }
        
        return (aCnt < bCnt) ? aCnt : bCnt;
    }
}

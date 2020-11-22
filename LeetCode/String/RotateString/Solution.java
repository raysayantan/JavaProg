/*
We are given two strings, A and B. A shift on A consists of taking string A and moving the leftmost character to the rightmost position. 
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.
*/
class Solution {
    private StringBuilder shiftString(StringBuilder str){
        StringBuilder temp = new StringBuilder();
        temp.append(str.substring(1));
        temp.append(str.charAt(0));
        return temp;
    }
    public boolean rotateString(String A, String B) {
        StringBuilder aSb = new StringBuilder(A);
        int len = A.length();
        int blen = B.length();
        if(len != blen) return false;
        if(len == 0) return true;
        
        for(int idx = 0; idx < len; idx++){
            if(aSb.toString().equals(B)){
                return true;
            }
            
            aSb = shiftString(aSb);
        }
        return false;
    }
}

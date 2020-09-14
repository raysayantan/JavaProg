/*
Idea taken from the post : https://leetcode.com/problems/wildcard-matching/discuss/370736/Detailed-Intuition-From-Brute-force-to-Bottom-up-DP
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*/
class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        boolean[][] d = new boolean[ls + 1][lp + 1];
        int pIdx;
        int sIdx;
        
        for(int i = 0; i <= ls; i++){
            for(int j = 0; j <= lp; j++){
                sIdx = i - 1;
                pIdx = j - 1;
                if( i == 0 && j == 0){
                    d[i][j] = true;
                } else if( i == 0){
                    d[i][j] = (p.charAt(pIdx) == '*') && d[i][j - 1];
                } else if( j == 0){
                    d[i][j] = false;
                } else if(p.charAt(pIdx) == '*'){
                        d[i][j] = d[i][j - 1] | d[i - 1][j];
                } else if(p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx)){
                        d[i][j] = d[i - 1][j - 1];
                }
            }
        }
        
        return d[ls][lp];
    }
}

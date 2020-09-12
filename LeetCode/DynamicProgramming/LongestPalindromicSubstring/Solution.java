/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
class Solution {
    Integer start = 0;
    Integer maxLen = 0;
    public String longestPalindrome(String s) {
        int l = s.length();
        for(int idx = 0; idx < l; idx++){
            helper(s,idx, idx);
            helper(s, idx, idx + 1);
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private void helper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(maxLen < right - left - 1){
            start = left + 1;
            maxLen = right - left - 1;
        }
    }
}

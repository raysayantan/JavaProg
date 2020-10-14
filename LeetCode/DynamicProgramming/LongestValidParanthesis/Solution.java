/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. 

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/
class Solution {
    public int longestValidParentheses(String s) {
       StringBuilder str = new StringBuilder();
        int l = s.length();
        for(int idx = 0; idx < l; idx++){
            if(s.charAt(idx) != ')'){
                str.append(s.charAt(idx));
            } else {
                int pos = str.length() - 1;
                while(pos >= 0 && str.charAt(pos) == 'p'){
                    pos--;
                }
                
                if(pos >= 0 && str.charAt(pos) == '('){
                    str.setCharAt(pos, 'p');
                } else {
                    str.append(s.charAt(idx));
                }
            }
        }
        
        int maxLen = Integer.MIN_VALUE;
        int currLen = 0;
        for(int idx = 0; idx < str.length(); idx++){
            if(str.charAt(idx) == 'p'){
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 0;
            }
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen*2;
    }
}

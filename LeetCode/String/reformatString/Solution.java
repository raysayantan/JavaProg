/*
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"
Output: "1a2b3"
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/
class Solution {
    private String multiplex(StringBuilder sb1, StringBuilder sb2){
        StringBuilder res = new StringBuilder();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < sb1.length() && idx2 < sb2.length()){
            res.append(sb1.charAt(idx1++)).append(sb2.charAt(idx2++));
        }
        
        if(idx1 < sb1.length())
            res.append(sb1.charAt(idx1));
        
        return res.toString();
    }
    public String reformat(String s) {
        StringBuilder chars = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        
        for(int idx = 0; idx < s.length(); idx++){
            char c = s.charAt(idx);
            if(c >= 'a' && c <= 'z'){
                chars.append(c);
            } else {
                digits.append(c);
            }
        }
        
        int charLen = chars.length();
        int digLen = digits.length();
        if(Math.abs(digLen - charLen) > 1) return "";
        if(charLen > digLen)
            return multiplex(chars, digits);
        else
            return multiplex(digits, chars);
    }
}

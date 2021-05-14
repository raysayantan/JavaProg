/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*/
class Solution {
    String cancatNtimes(String s, int n){
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(idx <= n){
            sb.append(s);
            idx++;
        }
        
        return sb.toString();
    }
    public boolean repeatedSubstringPattern(String s) {
        for(int len = 1; len <= s.length()/2; len++){
            if(s.length() % len == 0){
                String str = s.substring(0, len);
                //System.out.println(str);
                String concat = cancatNtimes(str, s.length()/len);
                if(concat.equals(s))
                    return true;
            }
        }
        
        return false;
    }
}

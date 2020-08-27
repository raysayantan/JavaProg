/*
Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from string t if you can:

Insert exactky one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
 

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "a", t = ""
Output: true
Example 4:

Input: s = "", t = "A"
Output: true
 

Constraints:

0 <= s.length <= 104
0 <= t.length <= 104
*/
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        int si = 0;
        int ti = 0;
        boolean done = false;
        
        while(si < slen && ti < tlen){
            if(s.charAt(si) == t.charAt(ti)){
                si++;
                ti++;
            } else {
                if(done){
                    return false;
                } else {
                    done = true;
                    if(slen == tlen){
                        //we can only replace here
                        si++;
                        ti++;
                    } else if(slen < tlen){
                        //we can only add here
                        ti++;
                    } else {
                        //we can only dlete here
                        si++;
                    }
                }
            }
        }
        
        if(si == slen && ti == tlen){
            return done;
        } else if(Math.abs(slen - tlen) == 1){
            return true;
        }
        return false;
    }
}

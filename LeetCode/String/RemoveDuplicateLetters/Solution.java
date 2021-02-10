/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        
        for(int idx = 0; idx < s.length(); idx++){
            lastIndex.put(s.charAt(idx), idx);
        }
        
        for(int idx = 0; idx < s.length(); idx++){
            char c = s.charAt(idx);
            if(!seen.contains(c)){
                while(!st.empty() && c < st.peek() && lastIndex.get(st.peek()) > idx){
                    seen.remove(st.pop());
                }
            
                seen.add(c);
                st.push(c);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(char c : st){
            res.append(c);
        }
        
        return res.toString();
    }
}

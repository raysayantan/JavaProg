/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/
class Solution {
    private List<String> res;
    private Set<String> set = new HashSet<>();
    void helper(int idx, String s, List<String> l, StringBuilder sb){
        if(idx == s.length()){
            StringBuilder r = new StringBuilder();
            for(int i = 0; i < l.size(); i++){
                if(i > 0){
                    r.append(" ");
                }
                r.append(l.get(i));
            }
            
            if(r.length() > 0){
                res.add(r.toString());
            }
            sb.setLength(0);
        } else {
            char c = s.charAt(idx);
            sb.append(c);
            int len = sb.length();
            if(set.contains(sb.toString())){
                int oldl = l.size();
                l.add(sb.toString());
                helper(idx + 1, s, l, new StringBuilder());
                int size = l.size();
                if(size > 0){
                    l.remove(size - 1);
                }
            }
            if(idx + 1 < s.length())
                helper(idx + 1, s, l, sb);
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<String>();
        for(String str : wordDict){
            set.add(str);
        }
        List<String> l = new ArrayList<>();
        helper(0, s, l, new StringBuilder());
        return res;
    }
}

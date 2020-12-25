/*
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, 
and return a list of integers representing the size of these parts. 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        int lastIdx = 0;
        int idx = 0;
        List<Integer> res = new ArrayList<>();
        int[] index = new int[26];
        for(idx = 0; idx < S.length(); idx++){
            index[S.charAt(idx) - 'a'] = Math.max(index[S.charAt(idx) - 'a'], idx);
        }
        idx = 0;
        while(idx < S.length()){
            int start = idx;
            lastIdx = index[S.charAt(idx) - 'a'];
            while(idx < lastIdx){
                lastIdx = Math.max(lastIdx, index[S.charAt(idx) - 'a']);
                idx++;
            }
            res.add(lastIdx - start + 1);
            idx = lastIdx + 1;
        }
        
        return res;
    }
}

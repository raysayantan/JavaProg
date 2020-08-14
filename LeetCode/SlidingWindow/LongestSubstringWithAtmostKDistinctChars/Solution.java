/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int start = 0;
        int currLen = 0;
        int maxLen = Integer.MIN_VALUE;
        int charFreq = 0;
        
        if(len == 0 || k == 0){
            return 0;
        }
        
        Map<Character, Integer> tracker = new HashMap<>();
        for(int idx = 0; idx < len; idx++){
            if(tracker.containsKey(s.charAt(idx)) && tracker.get(s.charAt(idx)) != 0){
                Integer t = tracker.get(s.charAt(idx)) + 1;
                tracker.put(s.charAt(idx), t);
            } else {
                tracker.put(s.charAt(idx), 1);
                charFreq++;
                if(charFreq > k){
                    int i = start;
                    while(charFreq > k && i < idx){
                        if(tracker.get(s.charAt(i)) > 0){
                            Integer t = tracker.get(s.charAt(i)) - 1;
                            tracker.put(s.charAt(i), t);
                            if(tracker.get(s.charAt(i)) == 0){
                                charFreq--;
                            }
                        }
                        i++;
                    }
                    start = i;
                }
            }
            
            currLen = idx - start + 1;
            if(currLen > maxLen){
                maxLen = currLen;
            }
        }
        
        return maxLen;
    }
}

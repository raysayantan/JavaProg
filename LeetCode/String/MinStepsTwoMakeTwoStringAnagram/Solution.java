/*
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s. An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
Example 4:

Input: s = "xxyyzz", t = "xxyyzz"
Output: 0
Example 5:

Input: s = "friend", t = "family"
Output: 4
 

Constraints:

1 <= s.length <= 50000
s.length == t.length
s and t contain lower-case English letters only.
*/
/**********************************Using HAshMap******************************/
class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> charCounter = new HashMap<>();
        //read each character in s and put it in hash map
        for(int idx = 0; idx < s.length(); idx++){
            char c = s.charAt(idx);
            if(charCounter.containsKey(c)){
                charCounter.put(c, charCounter.get(c) + 1);
            } else {
                charCounter.put(c, 1);
            }
        }
        
        for(int idx = 0; idx < t.length(); idx++){
            char c = t.charAt(idx);
            if(charCounter.containsKey(c)){
                charCounter.put(c, charCounter.get(c) - 1);
                if(charCounter.get(c) == 0){
                    charCounter.remove(c);
                }
            }
        }
        
        int count = 0;
        for(Map.Entry<Character,Integer> e : charCounter.entrySet()){
            count += e.getValue();
        }
        
        return count;
    }
}
/*******************************Using counter Array****************************/
class Solution {
    public int minSteps(String s, String t) {
        int[] counter = new int[26];
        for(int idx = 0; idx < s.length(); idx++){
            counter[s.charAt(idx) - 'a']++;
        }
        int count = s.length();
        for(int idx = 0; idx < t.length(); idx++){
            char c = t.charAt(idx);
            if(counter[c - 'a'] > 0){
                counter[c - 'a']--;
                count--;
            }
        }
        return count;
    }
}

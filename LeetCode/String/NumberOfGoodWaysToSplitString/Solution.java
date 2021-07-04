/*
You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where its concatenation is equal to s and the number of distinct letters in p and q are the same.

Return the number of good splits you can make in s.

 

Example 1:

Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
Example 2:

Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").
Example 3:

Input: s = "aaaaa"
Output: 4
Explanation: All possible splits are good.
Example 4:

Input: s = "acbadbaada"
Output: 2
 

Constraints:

s contains only lowercase English letters.
1 <= s.length <= 10^5
*/

//===============================First Approch to the problem=============================
class Solution {
    public int numSplits(String s) {
        int count = 0;
        
        //left will contains the unique chars of the left part of the partition
        //and right will contain the unique chars for the other half of the partition
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        
        for(int idx = 0; idx < s.length(); idx++){
            char c = s.charAt(idx);
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        
        //now move the string from to construct the left, as soon as adding one to
        //left, discard the same from the right. If size of left and right are same
        //then we have a good split.
        for(int idx = 0; idx < s.length(); idx++){
            char c = s.charAt(idx);
            left.add(c);
            right.put(c, right.get(c) - 1);
            if(right.get(c) == 0){
                right.remove(c);
            }
            
            if(right.size() == left.size()){
                count++;
            }
        }
        return count;
    }
}

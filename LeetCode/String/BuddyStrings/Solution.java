/*
Given two strings a and b, return true if you can swap two letters in a so the result is equal to b, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at a[i] and b[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: a = "ab", b = "ba"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'b' to get "ba", which is equal to b.
Example 2:

Input: a = "ab", b = "ab"
Output: false
Explanation: The only letters you can swap are a[0] = 'a' and a[1] = 'b', which results in "ba" != b.
Example 3:

Input: a = "aa", b = "aa"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'a' to get "aa", which is equal to b.
Example 4:

Input: a = "aaaaaaabc", b = "aaaaaaacb"
Output: true
 

Constraints:

1 <= a.length, b.length <= 2 * 104
a and b consist of lowercase letters.
*/
class Solution {
    public boolean buddyStrings(String a, String b) {
        int pos1 = -1;
        int pos2 = -1;
        int count = 0;
        int len1 = a.length();
        int len2 = b.length();
        int[] f = new int[26];
        if(len1 != len2) return false;
        for(int idx = 0; idx < len1; idx++){
            f[a.charAt(idx) - 'a']++;
            if(a.charAt(idx) != b.charAt(idx)){
                count++;
                if(pos1 == -1){
                    pos1 = idx;
                } else {
                    pos2 = idx;
                }
            }
            
            if(count > 2) return false;
        }
        
        if(count == 0){
            for(int idx = 0; idx < 26; idx++){
                if(f[idx] >= 2) return true;
            }
            
            return false;
        }
        
        if(pos1 != -1 && pos2 != -1 && count == 2){
            if(a.charAt(pos1) == b.charAt(pos2) && b.charAt(pos1) == a.charAt(pos2)){
                return true;
            }
        }
        
        return false;
    }
}

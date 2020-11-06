/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.
The answer is guaranteed to fit in a 32-bit integer.

Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. 
So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
Example 4:

Input: s = "1"
Output: 1
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
*/
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] combination = new int[len + 1];
        combination[0] = 1;
        
        if(s.charAt(0) == '0'){
            return 0;
        }
        
        for(int idx = 0; idx < len; idx++){
            if(idx == 0){
                combination[idx + 1] = 1;
            } else {
                if(s.charAt(idx) == '0'){
                    //current char 0 and there could be two scenario valid and invalid
                    if(s.charAt(idx - 1) > '2' || s.charAt(idx - 1) < '1'){
                        //invalid e.g 30 - 0 current char and prev is 3
                        //System.out.println("Here "+ s.charAt(idx - 1));
                        return 0;
                    } else {
                        combination[idx + 1] = combination[idx - 1];
                    }
                } else {
                    //current character non zero
                    if(s.charAt(idx - 1) == '0'){
                        //prev char is 0
                        combination[idx + 1] = combination[idx];
                    } else if(s.charAt(idx - 1) == '1'){
                        //prev char is 1
                        combination[idx + 1] = combination[idx] + combination[idx - 1];
                    } else if(s.charAt(idx - 1) == '2'){
                        //prev char is 2
                        if(s.charAt(idx) >= '1' && s.charAt(idx) <= '6'){
                            //curr char in between 1 and 6
                            combination[idx + 1] = combination[idx] + combination[idx - 1];
                        } else {
                            //curr char greater than 6
                            combination[idx + 1] = combination[idx];
                        }
                    } else {
                        //prev char greater than 2
                        combination[idx + 1] = combination[idx];
                    }
                }
            }
        }
        
        return combination[len];
    }
}

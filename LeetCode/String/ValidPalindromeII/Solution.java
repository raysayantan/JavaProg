/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/
class Solution {
    public boolean validPalindrome(String s) {
        //String of length 1 or less are always palindrome
        if(s.length() < 2){
            return true;
        }
        boolean mismatch = false;
        boolean status = true;
        int start = 0;
        int end = s.length() - 1;
        
        //This loop will find either the string is palindrome or will
        //break at first mismatch
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                mismatch = true;
                break;
            }
            
            start++;
            end--;
        }
        
        //If we have a mismatch in the earlier loop
        if(mismatch){
            int prevStart = start;
            int prevEnd = end;
            start++;
            
            //First checking the rest is palindrome or not discarding the mismatch char at start pos
            while(start <= end){
                if(s.charAt(start) != s.charAt(end)){
                    status = false;
                    break;
                }
                start++;
                end--;
            }
            
            //if discarding the char at start we have palindrome then we have done so return
            if(status){
                return status;
            }
            
            start = prevStart;
            end = prevEnd - 1;
            status = true;
            //Now checking the rest is palindrome or not discarding the mismatch char at end pos
            while(start <= end){
                if(s.charAt(start) != s.charAt(end)){
                    status = false;
                    break;
                }
                start++;
                end--;
            }
        } 
        
        return status;
    }
}

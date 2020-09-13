/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String result = strs[0];
        for(int idx = 1; idx < strs.length; idx++){
            int counter = 0;
            String str = strs[idx];
            for(int s = 0; s < Math.min(result.length(), str.length()); s++){
                if(result.charAt(s) == str.charAt(s)){
                    counter++;
                } else {
                    break;
                }
            }
            
            result = result = result.substring(0, counter);
            if(result == ""){
                break;
            }
        }
        
        return result;
    }
}

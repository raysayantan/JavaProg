/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. 
If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        int remCnt = len;
        int start = 0;
        int end = k;
        while(remCnt >= k){
            //Take first k character
            String part1 = "";
            if(end >= len)
                part1 = sb.substring(start);
            else 
                part1 = sb.substring(start, end);
            StringBuilder sbpart1 = new StringBuilder(part1);
            res.append(sbpart1.reverse());
            remCnt -= k;
            start += k;
            end += k;
            //rem count is less than k
            if(remCnt < k){
                if(remCnt <= 0) {
                    break;
                }
                String part2 = sb.substring(start);
                res.append(part2);
                remCnt = 0;
                break;
            }
            
            String part2 = sb.substring(start, end);
            res.append(part2);
            remCnt -= k;
            start += k;
            end += k;
        }
        
        if(remCnt > 0){
            String part1 = sb.substring(start);
            StringBuilder sbpart1 = new StringBuilder(part1);
            res.append(sbpart1.reverse());
        }
        
        return res.toString();
    }
}

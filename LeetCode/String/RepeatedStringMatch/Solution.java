/*
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be 
a substring of a after repeating it, return -1. Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and repeated 2 times is "abcabc".

Example 1:

Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:

Input: a = "a", b = "aa"
Output: 2
Example 3:

Input: a = "a", b = "a"
Output: 1
Example 4:

Input: a = "abc", b = "wxyz"
Output: -1
 

Constraints:

1 <= a.length <= 104
1 <= b.length <= 104
a and b consist of lower-case English letters.
*/
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int result = -1;
               
        //There are 3 possibilities here 
        //1. We have not found a in b, so either b is a substring of a or (suffix of a + prefix of a) will be equal to b
        //2. We have some n times occurances of a in b and a prefix that should match with suffix of a and 
        //   a suffix that should match with prefix of a 
        //3. We dont have any match we will retun -1
        
        int index = b.indexOf(a);
        if(index == -1){
            if(a.contains(b)){
                return 1;
            } else {
                int start = 0;
                while(start < blen){
                    if(start == 0){
                        if(a.endsWith(b) || a.startsWith(b)){
                            result = 1;
                            break;
                        }
                    } else {
                        String prefix = b.substring(0, start);
                        String suffix = b.substring(start);
                        if(a.endsWith(prefix) && a.startsWith(suffix)){
                            result = 2;
                            break;
                        }
                    }
                    start++;
                }
            }
        } else {
            int begin = index;
            System.out.println("begin idx " + begin);
            int end = blen;
            result = 0;
            while(a.equals(b.substring(index, index + alen))){
                result++;
                end = index + alen;
                index = end;
                if(index + alen >= blen) break;
            }
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            if(begin > 0)
                prefix.append(b.substring(0, begin));
            if(end < blen)
                suffix.append(b.substring(end));
            
            if(!prefix.toString().equals("")){
                System.out.println("here");
                if(a.endsWith(prefix.toString())){
                    result++;
                } else {
                    return -1;
                }
            }
            
            if(!suffix.toString().equals("")){
                if(a.startsWith(suffix.toString())){
                    result++;
                } else {
                    return -1;
                }
            }
        }
        
        return result;
    }
}

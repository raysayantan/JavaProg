/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1
*/
class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        boolean isNegative = (x < 0) ? true : false;
        if(x == max || x == min) return 0;
        if(isNegative == true){
            x = -x;
        }
        
        int rNum = 0;
        
        while(x > 0){
            int digit = x % 10;
            
            if(isNegative == true){
                if(-rNum < min/10) return 0;
                if(-rNum == min/10){
                    if(digit > -(min%10)) return 0;
                }
            } else {
                if(rNum > max/10) return 0;
                if(rNum == max/10){
                    if(digit > max%10) return 0;
                }
            }
            
            rNum = rNum*10 + digit;
            x = x / 10;
        }
        
        return (isNegative == true) ? -rNum : rNum;
    }
}

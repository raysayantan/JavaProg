/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
class Solution {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        if(num1.length() == 0){
            return num2;
        }
        
        if(num2.length() == 0){
            return num1;
        }
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while(idx1 >= 0 && idx2 >= 0){
            int sum = 0;
            int dig1 = num1.charAt(idx1) - '0';
            int dig2 = num2.charAt(idx2) - '0';
            sum = dig1 + dig2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            res.append(sum);
            idx1--;
            idx2--;
        }
        
        while(idx1 >= 0){
            int sum = 0;
            int dig1 = num1.charAt(idx1) - '0';
            sum = dig1 + carry;
            carry = sum / 10;
            sum = sum % 10;
            res.append(sum);
            idx1--;
        }
        
        while(idx2 >= 0){
            int sum = 0;
            int dig2 = num2.charAt(idx2) - '0';
            sum = dig2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            res.append(sum);
            idx2--;
        }
        
        if(carry > 0){
            res.append(carry);
        }
        
        return res.reverse().toString();
    }
}

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0
*/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        
        StringBuilder fraction = new StringBuilder();
        boolean neg = false;
        if(numerator < 0){
            if(denominator > 0){
                neg = true;
            }
        } else {
            if(denominator < 0){
                neg = true;
            }
        }
        
        if(neg == true){
            fraction.append("-");
        }
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        HashMap<Long, Integer> tracker = new HashMap<>();
        long div = num / den;
        long rem = num % den;
        fraction.append(div);
        if(rem == 0){
            return fraction.toString();
        }
        fraction.append(".");
        while(rem != 0){
            if(tracker.containsKey(rem)){
                fraction.insert(tracker.get(rem), "(");
                fraction.append(')');
                break;
            }
            
            tracker.put(rem, fraction.length());
            rem *= 10;
            div = rem / den;
            fraction.append(div);
            rem %= den;
        }
        
        return fraction.toString();
    }
}

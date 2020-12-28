/*
Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 
Constraints:

0 <= num <= 231 - 1
*/
class Solution {
    private static final String[] units =   {"Hundred", "Thousand", "Million", "Billion"};
    private static final String[] numbers = {"", "One", "Two", "Three", "Four", "Five",
                                             "Six", "Seven", "Eight", "Nine"};
    private static final String[] units1 =  {"","", "Twenty", "Thirty", "Forty", "Fifty", 
                                             "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] units2 =  {"Ten", "Eleven", "Twelve", "Thirteen", 
                                             "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                                             "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        Stack<String> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int counter = 0;
        while(num > 0){
            int rem = num % 1000;
            String temp = convertToString(rem, counter);
            st.push(temp);
            counter++;
            num /= 1000;
        }
        
        while(!st.isEmpty()){
            if(res.length() > 0 && !st.peek().equals("")){
                res.append(" ");
            }
            
            res.append(st.pop());
        }
        
        return res.toString().trim();
    }
    
    private String convertToString(int num, int index){
        StringBuilder str = new StringBuilder();
        int hundred = num/ 100;
        if(hundred > 0){
            str.append(numbers[hundred]).append(" Hundred");
        }
        
        num %= 100;
        if(num >= 20){
            if(str.length() > 0)
                str.append(" ");
            str.append(units1[num/10]);
            num %= 10;
            if(num > 0){
                if(str.length() > 0)
                    str.append(" ");
                str.append(numbers[num]);
            }
        } else if(num >= 10){
            if(str.length() > 0)
                str.append(" ");
            str.append(units2[num % 10]);
        } else if(num > 0){
            if(str.length() > 0)
                str.append(" ");
            str.append(numbers[num]);
        }
        
        if(index > 0 && str.length() > 0){
            str.append(" ").append(units[index]);
        }
        
        return str.toString();
    }
}

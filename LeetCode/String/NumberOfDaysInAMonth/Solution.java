/*
Given a year Y and a month M, return how many days there are in that month.

 

Example 1:

Input: Y = 1992, M = 7
Output: 31
Example 2:

Input: Y = 2000, M = 2
Output: 29
Example 3:

Input: Y = 1900, M = 2
Output: 28
 

Note:

1583 <= Y <= 2100
1 <= M <= 12
*/
class Solution {
    boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }
    
    int daysInMonth(int month, int year){
        int days = 0;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8
           || month == 10 || month == 12){
            days = 31;
        } else if(month == 2){
            days = (isLeapYear(year)) ? 29 : 28;
        } else {
            days = 30;
        }
        return days;
    }
    public int numberOfDays(int Y, int M) {
        return (daysInMonth(M, Y));
    }
}

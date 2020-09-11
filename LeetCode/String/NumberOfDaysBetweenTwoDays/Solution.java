/*
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

 

Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15
 

Constraints:

The given dates are valid dates between the years 1971 and 2100.
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
    
    public int daysBetweenDates(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0,4));
        int month1 = Integer.parseInt(date1.substring(5,7));
        int day1 = Integer.parseInt(date1.substring(8));
        
        int year2 = Integer.parseInt(date2.substring(0,4));
        int month2 = Integer.parseInt(date2.substring(5,7));
        int day2 = Integer.parseInt(date2.substring(8));
        
        int days = 0;
        int s = Math.min(year1, year2);
        int e = Math.max(year1, year2);
        for(int y = s + 1; y < e; y++){
            int t = (isLeapYear(y)) ? 366 : 365;
            days += t;
        }
        
        if(year1 != year2){
            if(s == year1){
                for(int m = month1 + 1; m <= 12; m++){
                    days += daysInMonth(m, s);
                }
                
                days += daysInMonth(month1, year1) - day1;
                for(int m = 1; m < month2; m++){
                    days += daysInMonth(m, e);
                }
                days += day2;
            } else {
                for(int m = month2 + 1; m <= 12; m++){
                    days += daysInMonth(m, s);
                }            
                days += daysInMonth(month2, year2) - day2;
                for(int m = 1; m < month1; m++){
                    days += daysInMonth(m, e);
                }
                days += day1;
            }
        } else {
            if(month1 == month2){
                days += Math.abs(day1 - day2);
            } else {
                int sm = Math.min(month1, month2);
                int em = Math.max(month1, month2);
                for(int m = sm + 1; m < em; m++){
                    days += daysInMonth(m, year1);
                }
                
                if(sm == month1){
                    days += daysInMonth(sm, year1) - day1;
                    days += day2;
                } else {
                    days += daysInMonth(sm, year1) - day2;
                    days += day1;
                }
            }
        }
        
        return days;
    }
}

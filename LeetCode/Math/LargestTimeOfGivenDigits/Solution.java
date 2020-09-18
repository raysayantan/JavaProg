/*
Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.

Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.

 

Example 1:

Input: A = [1,2,3,4]
Output: "23:41"
Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.
Example 2:

Input: A = [5,5,5,5]
Output: ""
Explanation: There are no valid 24-hour times as "55:55" is not valid.
Example 3:

Input: A = [0,0,0,0]
Output: "00:00"
Example 4:

Input: A = [0,0,1,0]
Output: "10:00"
 

Constraints:

arr.length == 4
0 <= arr[i] <= 9
*/
class Solution {
    private int maxNum = -1;
    private void validTime(int[] arr, HashSet<Integer> s, int count, int idx, int num){
        num = num * 10 + arr[idx];
        if(count == 3){
            if((num / 100 < 24 && num % 100 < 60) && num > maxNum){
                maxNum = num;
            }
            return;
        }
        s.add(idx);
        for(int index = 0; index < 4; index++){
            if(!s.contains(index)){
                validTime(arr, s, count + 1, index, num);
                s.remove(index);
            }
        }
    }
    public String largestTimeFromDigits(int[] arr) {
        HashSet<Integer> s = new HashSet<>();
        for(int idx = 0; idx < 4; idx++){
            validTime(arr, s, 0, idx, 0);
            s.remove(idx);
        }
        boolean isAppendZero = false;
        if(maxNum < 1000){
            isAppendZero = true;
        }
        if(maxNum == 0){
            return "00:00";
        } else if(maxNum > 0){
            int count = 0;
            StringBuilder res = new StringBuilder();
            
            while(maxNum > 0){
                int rem = maxNum % 10;
                maxNum = maxNum / 10;
                res.append(Integer.toString(rem));
                count++;
                if(count == 2){
                    res.append(":");
                }
            }
            
            if(isAppendZero){
                res.append("0");
            }
            return res.reverse().toString();
        }
        
        return "";
    }
}

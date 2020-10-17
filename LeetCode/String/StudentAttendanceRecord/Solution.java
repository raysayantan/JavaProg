/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/
class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;
        
        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) == 'A'){
                aCount++;
            } else if(s.charAt(idx) == 'L'){
                if(idx > 0 && s.charAt(idx - 1) == 'L'){
                    lCount++;
                } else {
                    lCount = 1;
                }
            }
            
            if(lCount > 2 || aCount > 1){
                return false;
            }
        }
        
        return true;
    }
}

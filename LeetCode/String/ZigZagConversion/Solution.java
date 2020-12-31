/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
*/
class Solution {
    public String convert(String s, int numRows) {
        int row = 0;
        int isDown = 1;
        StringBuilder[] sb = new StringBuilder[numRows];
        int idx = 0;
        while(idx < s.length()){
            if(row < numRows && row >= 0){
                if(sb[row] == null){
                    sb[row] = new StringBuilder();
                }
                sb[row].append(s.charAt(idx++));
            }
            
            if(row == numRows - 1){
                isDown = -1;
            } else if(row == 0){
                isDown = 1;
            }
            if(numRows > 1)
                row += isDown;
        }
        StringBuilder res = new StringBuilder();
        for(idx = 0; idx < numRows; idx++){
            if(sb[idx] != null){
                res.append(sb[idx].toString());
            }
        }
        
        return res.toString();
    }
}

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/
class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNum = new ArrayList<>();
        uglyNum.add(1);
        int l2 = 0;
        int l3 = 0;
        int l5 = 0;
        for(int idx = 1; idx < n; idx++){
            int ugly = Math.min(Math.min(uglyNum.get(l2)*2, uglyNum.get(l3)*3), uglyNum.get(l5)*5);
            uglyNum.add(ugly);
            if(ugly == uglyNum.get(l2)*2) l2++;
            if(ugly == uglyNum.get(l3)*3) l3++;
            if(ugly == uglyNum.get(l5)*5) l5++;
        }
        
        return uglyNum.get(n-1);
    }
}

/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        int p = -1;
        int len = nums.length;
        for(int idx = 0; idx < len - 1; idx++){
            if(nums[idx] > nums[idx + 1]){
                if(p != -1) return false;
                p = idx;
            }
        }
        
        return (p == -1 || p == 0 || p == len - 2 || nums[p - 1] <= nums[p + 1] || nums[p] <= nums[p + 2]);
    }
}

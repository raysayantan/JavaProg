/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxVal = nums[0];
        
        for(int idx = 1; idx < nums.length; idx++){
            int temp = maxSoFar;
            maxSoFar = Math.max(nums[idx], Math.max(maxSoFar*nums[idx], minSoFar*nums[idx]));
            minSoFar = Math.min(nums[idx], Math.min(temp*nums[idx], minSoFar*nums[idx]));
            maxVal = Math.max(maxVal, maxSoFar);
        }
        
        return maxVal;
    }
}

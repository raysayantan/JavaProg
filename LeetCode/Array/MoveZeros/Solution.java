/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIdx = - 1;
        int nonZeroIdx = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroIdx = i;
                break;
            }
        }
        
        for(int i = zeroIdx + 1; i < nums.length; i++){
            if(nums[i] != 0){
                nonZeroIdx = i;
                break;
            }
        }
        
        if(zeroIdx == -1 || nonZeroIdx == -1)
            return;
        
        while(zeroIdx < nums.length && nonZeroIdx < nums.length){
            if(zeroIdx < nonZeroIdx){
                nums[zeroIdx] = nums[nonZeroIdx];
                nums[nonZeroIdx] = 0;
                zeroIdx++;
                nonZeroIdx++;
            }
            
            while(nonZeroIdx < nums.length && nums[nonZeroIdx] == 0){
                nonZeroIdx++;
            }
        }
    }
}

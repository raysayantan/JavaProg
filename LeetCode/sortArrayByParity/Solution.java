/*
Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
*/
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            while(start < nums.length){
                if(nums[start] % 2 != 0) break;
                start++;
            } 
            
            while(end >= 0){
                if(nums[end] % 2 == 0) break;
                end--;
            }
            
            if(start < end){
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
        
        return nums;
    }
}

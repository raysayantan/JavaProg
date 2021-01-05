/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int lower = -1;
        
        for(int idx = nums.length -1; idx > 0; idx--){
            if(nums[idx] > nums[idx - 1]){
                lower = idx - 1;
                break;
            }
        }
        
        if(lower == -1){
            Arrays.sort(nums);
        } else {
            int nextHigher = Integer.MAX_VALUE;
            int nextHigherIdx = -1;
            for(int idx = lower + 1; idx < nums.length; idx++){
                if(nums[idx] > nums[lower]){
                    if(nextHigher > nums[idx]){
                        nextHigher = nums[idx];
                        nextHigherIdx = idx;
                    }
                }
            }
            int temp = nums[lower];
            nums[lower] = nums[nextHigherIdx];
            nums[nextHigherIdx] = temp;
            Arrays.sort(nums, lower + 1, nums.length);
        }
    }
}

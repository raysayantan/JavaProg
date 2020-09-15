/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/
class Solution {
    private int helper(int[] nums, int start, int end, int len){
        if(start <= end){
            //Length of the array is 1 means we have the element at index 0.
            //If the Arrray is already sorted then the fist element is the smallest
            if(len == 1 || nums[0] < nums[len - 1]){
                return nums[0];
            }
            
            int mid = (start + end) / 2;
            //If we have mid element greater than mid + 1, then mid + 1 is the smallest
            if(mid + 1 < len && nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            //else if mid is lesser than mid - 1, mid is the smallest one
            if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid] < nums[start]){
                //we have rotated part in interval (start, mid - 1)
                return helper(nums, start, mid - 1, len);
            } else if(nums[mid] > nums[end]){
                //we have rotated part in (mid + 1) to end
                return helper(nums, mid + 1, end, len);
            }
        }
        
        return Integer.MIN_VALUE;
    }
    public int findMin(int[] nums) {
        int len = nums.length;
        return helper(nums, 0, len - 1, len);
    }
}

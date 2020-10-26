/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        
        for(int idx = 0; idx < len; idx++){
            //reading the element at index idx and making the index
            //at nums[idx] to negative. If we come to pos where we do
            //have already a negative i.e. this place already encountered
            //which means this is a duplicate and put in result vector
            int index = Math.abs(nums[idx]) - 1;
            if(nums[index] < 0){
                result.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
}

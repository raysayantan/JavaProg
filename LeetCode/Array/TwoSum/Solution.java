/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int idx = 0; idx < nums.length; idx++){
            m.put(nums[idx], idx);
        }
        
        for(int idx = 0; idx < nums.length; idx++){
            int diff = target - nums[idx];
            if(m.containsKey(diff) && m.get(diff) != idx){
                result[0] = idx;
                result[1] = m.get(diff);
                break;
            }
        }
        return result;
    }
}

/*
Given an integer array nums, return the number of longest increasing subsequences.
Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

Constraints:

0 <= nums.length <= 2000
-106 <= nums[i] <= 106
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] lengths =  new int[len];
        int[] count = new int[len];
        
        Arrays.fill(count, 1);
        Arrays.fill(lengths, 1);
        
        for(int i = 0; i < len; i++){
            for(int k = 0; k < i; k++){
                if(nums[i] > nums[k]){
                    if(lengths[k] >= lengths[i]){
                        lengths[i] = lengths[k] + 1;
                        count[i] = count[k];
                    } else if(lengths[k] + 1 == lengths[i]){
                        count[i] += count[k];
                    }
                }
            }
        }
        
        int longest = 0;
        for(int idx = 0; idx < len; idx++){
            longest = Math.max(longest, lengths[idx]);
        }
        
        int ans = 0;
        for(int idx = 0; idx < len; idx++){
            if(lengths[idx] == longest){
                ans += count[idx];
            }
        }
        
        return ans;
    }
}

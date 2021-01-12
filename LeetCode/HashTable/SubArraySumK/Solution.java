/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int sum = 0;
        int counter = 0;
        for(int idx = 0; idx < nums.length; idx++){
            sum += nums[idx];
            int count = 1;
            if(sum == k){
                counter++;
            }
            
            if(tracker.containsKey(sum - k)){
                counter += tracker.get(sum - k);
            }
            
            if(tracker.containsKey(sum)){
                count += tracker.get(sum);
            }
            tracker.put(sum, count);
        }
        
        return counter;
    }
}

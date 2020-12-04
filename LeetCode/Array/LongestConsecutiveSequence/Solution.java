/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
Follow up: Could you implement the O(n) solution?  

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int idx = 0; idx < nums.length; idx++){
            if(counter.containsKey(nums[idx])) continue;
            int lower = nums[idx] - 1;
            int upper = nums[idx] + 1;
            int count = (counter.containsKey(lower) ? counter.get(lower) : 0) + 
                        (counter.containsKey(upper) ? counter.get(upper) : 0) + 1;
            while(counter.containsKey(lower)){
                counter.put(lower, count);
                lower--;
            }
            
            while(counter.containsKey(upper)){
                counter.put(upper, count);
                upper++;
            }
            
            counter.put(nums[idx], count);
        }
        
        int maxlen = 0;
        for(Map.Entry<Integer,Integer> e : counter.entrySet()){
            maxlen = Math.max(maxlen, e.getValue());
        }
        
        return maxlen;
    }
}

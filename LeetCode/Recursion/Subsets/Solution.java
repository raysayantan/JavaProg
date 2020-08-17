/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int idx = 0; idx < nums.length; idx++){
            int size = result.size();
            for(int setIdx = 0; setIdx < size; setIdx++){
                List<Integer> tempSet = new ArrayList<>(result.get(setIdx));
                tempSet.add(nums[idx]);
                result.add(tempSet);
            }
        }
        
        return result;
    }
}

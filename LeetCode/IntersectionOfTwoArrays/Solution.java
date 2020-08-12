/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1 == 0 || len2 == 0){
            return new int[result.size()];
        }
        
        Map<Integer, Boolean> tracker = new HashMap<>();
        
        for(int idx = 0; idx < len1; idx++){
            tracker.put(nums1[idx], false);
        }
        
        for(int idx = 0; idx < len2; idx++){
            if(tracker.containsKey(nums2[idx]) && tracker.get(nums2[idx]) == false){
                result.add(nums2[idx]);
                tracker.put(nums2[idx], true);
            }
        }
        
        int[] resArray = new int[result.size()];
        for(int idx = 0; idx < result.size(); idx++){
           resArray[idx] = result.get(idx);
        }
        return resArray;
    }
}

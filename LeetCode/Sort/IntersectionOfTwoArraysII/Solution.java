/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       ArrayList<Integer> result = new ArrayList<>();
        
        Arrays.sort(nums1, 0, nums1.length);
        Arrays.sort(nums2, 0, nums2.length);
        
        int idx1 = 0; 
        int idx2 = 0;
               
        while(idx1 < nums1.length && idx2 < nums2.length){
            if(nums1[idx1] == nums2[idx2]){
                result.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if(nums1[idx1] < nums2[idx2]){
                idx1++;
            } else if(nums1[idx1] > nums2[idx2]){
                idx2++;
            }
        }
        
        int[] res = new int[result.size()];
        int i = 0;
        for(int ele : result){
            res[i++] = ele;
        }
        return res; 
    }
}

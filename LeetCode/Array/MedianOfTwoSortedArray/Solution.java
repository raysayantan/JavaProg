/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
Follow up: The overall run time complexity should be O(log (m+n)).
 
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        int start = 0;
        int end = l1;
        int partitionX;
        int partitionY;
        double median = Integer.MAX_VALUE;
        
        while(start <= end){
            partitionX = (start + end)/2;
            partitionY = (l1 + l2 + 1)/2 - partitionX;
            
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == l1) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == l2) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxX <= minY && maxY <= minX){
                //we have the meadian
                if((l1 + l2) % 2 == 0){
                    median = ((double)(Math.max(maxX, maxY) + Math.min(minX, minY)))/2;
                } else {
                    median = Math.max(maxX, maxY);
                }
                
                break;
            } else if(maxX > minY){
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }
        
        return median;
    }
}

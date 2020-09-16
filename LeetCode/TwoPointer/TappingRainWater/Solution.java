/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 
Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
class Solution {
    public int trap(int[] height) {
        //We have two pointers one from start and another from end, let say leftMax and rightMax
        //max from left and right respectively. At each index we will find how much water it can 
        //be stored in that index position. Now find the min between left and right. If leftMax is min, 
        //then at current index start we have water = (left - height[start]) and if rightMax is smaller 
        //then water = (right - height[end]). At each index we need to find the respective max from left and right
        
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int capacity = 0;
        
        while(start < end){
            if(height[start] > leftMax){
                leftMax = height[start];
            }
            
            if(height[end] > rightMax){
                rightMax = height[end];
            }
            
            if(leftMax < rightMax){
                capacity += (leftMax - height[start]);
                start++;
            } else {
                capacity += (rightMax - height[end]);
                end--;
            }
        }
        
        return capacity;
    }
}

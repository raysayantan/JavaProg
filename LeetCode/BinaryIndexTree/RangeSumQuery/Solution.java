/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
 

Constraints:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
0 <= i <= j <= nums.length - 1
*/
class NumArray {
    private int[] arr;
    private int[] data;
    int len;
    public NumArray(int[] nums) {
        len = nums.length;
        arr = new int[len];
        data = new int[len + 1];
        
        for(int idx = 0; idx < len; idx++){
            arr[idx] = nums[idx];
            create(idx, nums[idx]);
        }
    }
    
    private void create(int i, int val){
        int l = i + 1;
        while(l < len + 1){
            data[l] += val;
            l += l & (-l);
        }
    }
    
    public void update(int i, int val) {
        int l = i + 1;
        int diff = val - arr[i];
        arr[i] = val;
        while(l < len + 1){
            data[l] += diff;
            l += (l) & (-l);
        }
    }
    
    private int sumFirstN(int i){
        int total = 0;
        while(i > 0){
            total += data[i];
            i -= i & (-i);
        }
        
        return total;
    }
    
    public int sumRange(int i, int j) {
        return sumFirstN(j + 1) - sumFirstN(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

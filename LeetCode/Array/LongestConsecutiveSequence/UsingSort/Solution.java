class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        Arrays.sort(nums);
        int maxlen = 0;
        int currlen = 1;
         for(int idx = 0; idx < nums.length - 1; idx++){
             if(nums[idx] == nums[idx + 1]) continue;
             if(nums[idx] + 1 == nums[idx + 1]){
                 currlen++;
             } else {
                 maxlen = Math.max(currlen, maxlen);
                 currlen = 1;
             }
         }
        
        maxlen = Math.max(currlen, maxlen);
        
        return maxlen;
    }
}

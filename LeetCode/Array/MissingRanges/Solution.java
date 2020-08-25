/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
*/
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            if(lower == upper){
                result.add(Integer.toString(lower));
            } else {
                result.add(lower + "->" + upper);
            }
            return result;
        }
        
        long l = lower;
        long u = upper;
        int i = 0;
        while(i < len && l < u){
            if(nums[i] >= l){
                if(nums[i] == l){
                    l = (long)(nums[i]) + 1;
                } else if(nums[i] > l){
                    if(nums[i] == l + 1){
                        result.add(Long.toString(l));
                        if(l + 1 == u){
                            l = (long)(nums[i]) + 1;
                            break;
                        }                        
                    } else {
                        if(nums[i] - 1 <= u){
                            result.add(l + "->" + (nums[i] - 1));
                        } else {
                           result.add(l + "->" + u); 
                        }
                    }
                    
                    l = (long)(nums[i]) + 1;
                }
            }
            i++;
        }
        if(l < u){
            result.add(l + "->" + u);
        } else if(nums[len - 1] < l && l == u){
            result.add(Long.toString(l));
        }
        
        return result;
    }
}

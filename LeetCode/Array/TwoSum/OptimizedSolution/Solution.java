class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int[] res = new int[2];
        for(int idx = 0; idx < nums.length; idx++){
            int rem = target - nums[idx];
            if(numbers.containsKey(rem) && numbers.get(rem) != idx){
                res[0] = idx;
                res[1] = numbers.get(rem);
                break;
            }
            
            numbers.put(nums[idx], idx);
        }
        
        return res;
    }
}

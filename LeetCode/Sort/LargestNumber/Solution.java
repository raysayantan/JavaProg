/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
*/
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        List<String> l = new ArrayList<>();
        for(int idx = 0; idx < nums.length; idx++){
            l.add(String.valueOf(nums[idx]));
        }
        Collections.sort(l, (String s1, String s2) -> {
            String concat1 = s1 + s2;
            String concat2 = s2 + s1;
            
            return concat2.compareTo(concat1);
        });
        
        for(int idx = 0; idx < l.size(); idx++){
            res.append(l.get(idx));
            System.out.println(l.get(idx));
        }
        
        if(res.length() > 0 && res.charAt(0) == '0')
            return "0";
        
        return res.toString();
    }
}

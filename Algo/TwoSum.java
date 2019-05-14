package algo.myprog;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int[] nums1 = {3,3};
		int[] res = twoSum(nums,9);
		
		System.out.println("("+res[0]+","+res[1]+")");
		
		res = twoSum(nums1,6);
		System.out.println("("+res[0]+","+res[1]+")");
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> m =  new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			m.put(nums[i], i);
		}
		
		for(int i = 0; i < nums.length; i++) {
			int rest = target - nums[i];
			
			if(m.containsKey(rest) && m.get(rest)!= i) {
				return new int[] {i,m.get(rest) };
			}
		}
		
		return new int[] {};
    }
}

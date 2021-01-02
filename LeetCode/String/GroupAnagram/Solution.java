/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mapper = new HashMap<>();
        for(int idx = 0; idx < strs.length; idx++){
            char[] temp = strs[idx].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if(!mapper.containsKey(key)){
                mapper.put(key, new ArrayList<String>());
            }
            
            List<String> list = mapper.get(key);
            list.add(strs[idx]);
            mapper.put(key, list);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : mapper.entrySet()){
            res.add(e.getValue());
        }
        
        return res;
    }
}

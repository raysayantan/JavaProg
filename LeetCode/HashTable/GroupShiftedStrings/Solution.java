/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> m = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(String str : strings){
            int offset = str.charAt(0) - 'a';
            StringBuilder key = new StringBuilder();
            for(int idx = 0; idx < str.length(); idx++){
                char c =(char)(str.charAt(idx) - offset);
                if(c < 'a'){
                    c += 26;
                }
                
                key.append(c);
            }
            
            if(!m.containsKey(key.toString())){
                m.put(key.toString(), new ArrayList<String>());
            }
            
            List<String> t = m.get(key.toString());
            t.add(str);
            m.put(key.toString(), t);
        }
        
        for(Map.Entry<String,List<String>> e : m.entrySet()){
            List<String> l = e.getValue();
            Collections.sort(l);
            res.add(l);
        }
        
        return res;
    }
}

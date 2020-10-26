/*
You have a list of words and a pattern, and you want to know which words in words matches the pattern. A word matches the pattern if there exists a permutation 
of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word. (Recall that a permutation of letters is a 
bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 
You may return the answer in any order.

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 

Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20
*/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int len = words.length;
        for(int idx = 0; idx < len; idx++){
            if(match(words[idx], pattern)){
                result.add(words[idx]);
            }
        }
        
        return result;
    }
    
    private boolean match(String word, String pattern){
        HashMap<Character, Character> m = new HashMap<>();
        for(int idx = 0; idx < word.length(); idx++){
            char c = word.charAt(idx);
            char p = pattern.charAt(idx);
            if(!m.containsKey(p)){
                m.put(p, c);
            } else {
                if(m.get(p) != c){
                    return false;
                }
            }
        }
        
        boolean[] seen = new boolean[26];
        for(Map.Entry<Character, Character> e : m.entrySet()){
            if(seen[e.getValue() - 'a']){
                return false;
            }
            
            seen[e.getValue() - 'a'] = true;
        }        
        return true;
    }
}

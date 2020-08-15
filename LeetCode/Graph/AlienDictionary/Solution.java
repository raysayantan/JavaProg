/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, HashSet<Character>> dictionary = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();;
        int len = words.length;
        StringBuilder result = new StringBuilder();
        
        //Initialize the inorder and dictionary map
        for(int i = 0; i < len; i++){
            for(int k = 0; k < words[i].length(); k++){
                indegree.put(words[i].charAt(k), 0);
                dictionary.put(words[i].charAt(k), new HashSet<>());
            }
        }
        
        //populate the indegree and adjuscency list
        for(int i = 0; i < len - 1; i++){
            //check for later one is the prefix of the earlier
            if(words[i].length() > words[i + 1].length()     && (words[i]).startsWith(words[i + 1])){
                return "";
            }
            
            for(int k = 0; k < Math.min(words[i].length(), words[i + 1].length()); k++){
                if(words[i].charAt(k) != words[i + 1].charAt(k)){
                    if(!(dictionary.get(words[i].charAt(k))).contains(words[i + 1].charAt(k))){
                        dictionary.get(words[i].charAt(k)).add(words[i + 1].charAt(k));
                        indegree.put(words[i + 1].charAt(k), indegree.get(words[i + 1].charAt(k)) + 1);
                    }
                    break;
                }
            }
        }
        
        //queue used for BFS
        Queue<Character> q = new LinkedList<>();
        for(Character c : indegree.keySet()){
            //push all the nodes having '0' indegree
            if(indegree.get(c).equals(0)){
                q.add(c);
            }
        }
        
        while(!q.isEmpty()){
            Character c = q.remove();
            result.append(c);
            //Decrement the indegree of all the adjucent node of the current character node
            for(Character c1 : dictionary.get(c)){
                indegree.put(c1, indegree.get(c1) - 1);
                if(indegree.get(c1).equals(0)){
                    q.add(c1);
                }
            }
        }
        
        //now check all the character are in the result else return empty string
        if(result.length() < indegree.size()){
            return "";
        }
        
        return result.toString();
    }
}

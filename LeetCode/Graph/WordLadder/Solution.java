/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> dict = new HashMap<>();
        int len = beginWord.length();
        for(int w = 0; w < wordList.size(); w++){
            String str = wordList.get(w);
            for(int idx = 0; idx < len; idx++){
                String newWord = str.substring(0, idx) + '*' + str.substring(idx + 1, len);
                List<String> list = dict.getOrDefault(newWord, new ArrayList<String>());
                list.add(str);
                dict.put(newWord, list);
            }
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        q.add(new Pair(beginWord, 1));
        visited.put(beginWord, true);
        while(!q.isEmpty()){
            Pair<String, Integer> p = q.remove();
            String str = p.getKey();
            int level = p.getValue();
            for(int idx = 0; idx < len; idx++){
                String newWord = str.substring(0, idx) + '*' + str.substring(idx + 1, len);
                List<String> list = dict.getOrDefault(newWord, new ArrayList<String>());
                for(String s : list){
                    if(s.equals(endWord)){
                        return level + 1;
                    }
                    if(!visited.containsKey(s)){
                        visited.put(s, true);
                        q.add(new Pair(s, level + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}

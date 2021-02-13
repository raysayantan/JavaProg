/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.
*/
class WordDictionary {
    class Trie{
        Trie[] next;
        boolean isWord = false;
        public Trie(){
            next = new Trie[26];
        }
    }

    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        Trie p = trie;
        for(int idx = 0; idx < word.length(); idx++){
            char c = word.charAt(idx);
            if(p.next[c - 'a'] == null)
                p.next[c - 'a'] = new Trie();
            p = p.next[c - 'a'];
        }
        p.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(trie, word, 0);
    }
    
    private boolean helper(Trie trie, String word, int idx){
        if(idx == word.length()) {
            if(trie.isWord == true) {
                return true;
            }
            return false;
        }
        char c = word.charAt(idx);
        if(c != '.'){
            return (trie.next[c - 'a'] != null && helper(trie.next[c - 'a'], word, idx + 1));
        } else {
            boolean status = false;
             for(int i = 0; i < 26; i++){
                if(trie.next[i] != null){
                    status |= helper(trie.next[i], word, idx + 1);
                    if(status == true) return true;
                }
            }
            return status;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

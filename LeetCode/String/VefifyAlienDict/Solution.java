/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters. Given a sequence of words written in the alien language, 
and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 
Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
*/
class Solution {
    public boolean isAlienSorted(String[] words, String order) {      
        for(int idx = 0; idx < words.length - 1; idx++){
            String first = words[idx];
            String next = words[idx + 1];
            
            //later one should not be the substring of the first
            if(first.length() > next.length() && first.startsWith(next)){
                return false;
            }
            
            //now check char order are sorted
            int limit = Math.min(first.length(), next.length());
            for(int s = 0; s < limit; s++){
                char c1 = first.charAt(s);
                char c2 = next.charAt(s);
                if(c1 != c2){
                    if(order.indexOf(c1) > order.indexOf(c2)){
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return true;
    }
}

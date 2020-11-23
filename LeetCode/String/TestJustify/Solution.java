/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has
exactly maxWidth characters. Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly 
between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 
Constraints:
1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int currlen = 0;
        int idx = 0;
        int wordcnt = 0;
        List<String> container = new ArrayList<>();
        List<String> result = new ArrayList<>();
        while(idx < words.length){
            int sep = (wordcnt > 0) ? 1 : 0;
            if(currlen + words[idx].length() + sep > maxWidth){
                int spaces = maxWidth - (currlen - (wordcnt - 1));
                int spaceBetween = 0;
                if(wordcnt > 1){
                    spaceBetween = spaces / (wordcnt - 1);
                }
                int remSpaces = spaces - (spaceBetween) * (wordcnt - 1);
                StringBuilder str = new StringBuilder();
                StringBuilder seperator = new StringBuilder();
                for(int i = 0; i < spaceBetween; i++){
                    seperator.append(" ");
                }
                
                str.append(container.get(0));
                for(int sIdx = 1; sIdx < container.size(); sIdx++){
                    StringBuilder sepSpaces = new StringBuilder(seperator);
                    if(remSpaces > 0){
                        sepSpaces.append(" ");
                        remSpaces--;
                    }
                    str.append(sepSpaces); 
                    str.append(container.get(sIdx));
                }
                
                int len = str.length();
                for(int i = 0; i < maxWidth - len; i++){
                    str.append(" ");
                }
                    
                result.add(str.toString());
                currlen = 0;
                wordcnt = 0;
                container.clear();
            } else {
                container.add(words[idx]);
                currlen += words[idx].length() + sep;
                wordcnt++;
                idx++;
            }
        }
        
        StringBuilder str = new StringBuilder(container.get(0));
        for(int sIdx = 1; sIdx < container.size(); sIdx++){
            str.append(" ");
            str.append(container.get(sIdx));
        }
        int len = str.length();
        for(int i = 0; i < maxWidth - len; i++){
            str.append(" ");
        }
        result.add(str.toString());
        
        return result;
    }
}

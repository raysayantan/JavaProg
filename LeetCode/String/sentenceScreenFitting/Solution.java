/*
Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive words in a line.

 

Example 1:

Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.
Example 2:

Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
Output: 2
Explanation:
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.
Example 3:

Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
Output: 1
Explanation:
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.
 

Constraints:

1 <= sentence.length <= 100
1 <= sentence[i].length <= 10
sentence[i] consists of lowercase English letters.
1 <= rows, cols <= 2 * 104
*/
//Brute force solution
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 0;
        int c = 0;
        int count = 0;
        while(r < rows){
            int idx = 0;
            while(idx < sentence.length){
                int len = sentence[idx].length();
                int space = 0;
                if(c > 0){
                    space = 1;
                }
                
                c = c + len + space;
                if(c > cols){
                    r++;
                    if(r >= rows) break;
                    c = 0;
                    continue;
                }
                idx++;
                if(idx == sentence.length){
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}
//Optimized solution
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        //We are concatinating all the strings seperated with space.
        //Everytime we are finding the next new start position in a row
        //which is pos. if adding cols to pos ending a char other than " "
        //it means this new word will not fit in this row, so we need to traverse
        //back till we find a space. Likewise we will keep moving until we reach
        //row >= total number of rows. And return pos/len.
        String s = String.join(" ", sentence) + " ";
        int pos = 0;
        int len = s.length();
        for(int r = 0; r < rows; r++){
            pos += cols;
            while(pos >= 0 && s.charAt(pos%len) != ' '){
                pos--;
            }
            
            pos++;
        }
        
        return pos/len;
    }
}

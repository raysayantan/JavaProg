/*
Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
*/
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wlen = word.length();
        int abbrlen = abbr.length();
        int widx = 0;
        int abbridx = 0;
        int shift = 0;
        while(widx < wlen && abbridx < abbrlen){
            if(abbr.charAt(abbridx) >= '0' && abbr.charAt(abbridx) <= '9'){
                //digit
                if(shift == 0 && abbr.charAt(abbridx) == '0'){
                    return false;
                }
                shift = shift * 10 + (abbr.charAt(abbridx) - '0');
                abbridx++;
            } else {
                widx = widx + shift;
                if(widx >= wlen || word.charAt(widx) != abbr.charAt(abbridx)){
                    return false;
                }
                shift = 0;
                widx++;
                abbridx++;
            }
        }
        widx += shift;
        return (widx == wlen && abbridx == abbrlen);
    }
}

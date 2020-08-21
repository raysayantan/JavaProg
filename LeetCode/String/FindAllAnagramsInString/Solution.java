/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        List<Integer> result = new ArrayList<>();
        
        if(slen == 0 || slen < plen){
            return result;
        }
        
        int start = 0;
        int end = plen - 1;
        Map<Character, Integer> countTracker = new HashMap<>();
        
        //fill the map with char count in the pattern
        for(int idx = 0; idx < plen; idx++){
            if(!countTracker.containsKey(p.charAt(idx)))
                countTracker.put(p.charAt(idx), 1);
            else
                countTracker.put(p.charAt(idx), countTracker.get(p.charAt(idx)) + 1);
        }
        
        //get a temporary tracker to track a substring o len plen
        Map<Character, Integer> temp = new HashMap<>(countTracker);
        int counter = 0;
        int newStart = start + 1;
        Boolean found = false;
        while(start <= slen - plen){
            if(!found){
                for(int i = start; i <= end; i++){
                    //there will be two scenario - either the char will
                    //appear in the pattern or not. If it appears then we
                    //will decrement the tracker matching key value if it is
                    //greater than 0 and if all char in this substring match with 
                    //appears in pattern then we awill have a anagram and make an
                    //entry to result and move to the next substring starting at
                    //start + 1 location. Else we don't have match so need to
                    //adjust the next search start just after the non matching
                    //character.
                    if(temp.containsKey(s.charAt(i))){
                        //we have matching
                        if(temp.get(s.charAt(i)) > 0){
                            temp.put(s.charAt(i), temp.get(s.charAt(i)) - 1);
                            counter++;
                        } else {
                           newStart = start + 1; 
                        }
                    } else {
                        //do don't have match
                        newStart = i + 1;
                        break;
                    }
                }
            } else {
                if(temp.containsKey(s.charAt(end))){
                    if(temp.get(s.charAt(end)) > 0){
                        temp.put(s.charAt(end), temp.get(s.charAt(end)) - 1);
                        counter++;
                    } else {
                        newStart = start + 1;
                    }
                } else {
                    newStart = end + 1;
                    counter = 0;
                }
            }
            
            if(counter == plen ){
                //anagram found
                result.add(start);
                //temp = countTracker;
                temp.put(s.charAt(start), temp.get(s.charAt(start)) + 1);
                counter--;
                start++;
                end++;
                found = true;
            } else {
                //not found
                temp = new HashMap<>(countTracker);
                start = newStart;
                counter = 0;
                end = start + plen - 1;
                found = false;
            }
        }
        
        return result;
    }
}

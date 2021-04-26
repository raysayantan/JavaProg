/*
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Constraints:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
*/
class Solution {
    public List<Pair<Integer, Integer>> bucketize(String S){
        List<Pair<Integer, Integer>> bucket = new ArrayList<>();
        int count = 1;
        int start = 0;
        for(int idx = 1; idx < S.length(); idx++){
            char curr = S.charAt(idx);
            char prev = S.charAt(idx - 1);
            if(curr == prev){
                count++;
            } else {
                bucket.add(new Pair<Integer, Integer>(start, start + count - 1));
                start = start + count;
                count = 1;
            }
        }
        
        bucket.add(new Pair<Integer, Integer>(start, start + count -1));
        
        return bucket;
    }
    
    boolean compare(String S, String word, List<Pair<Integer, Integer>> b1, List<Pair<Integer, Integer>> b2){
        boolean isPresent = false;
        if(b1.size() != b2.size())
            return false;
        for(int idx = 0; idx < b1.size(); idx++){
            Pair<Integer, Integer> p1 = b1.get(idx);
            Pair<Integer, Integer> p2 = b2.get(idx);
            int start1 = p1.getKey();
            int start2 = p2.getKey();
            int end1 = p1.getValue();
            int end2 = p2.getValue();
            if(S.charAt(start1) != word.charAt(start2)){
                return false;
            }
            if(end1 - start1 + 1 >= 3 && end1 - start1 >= end2 - start2) {
                isPresent = true;
                continue;
            } else {
                if(end1 - start1 != end2 - start2){
                    return false;
                }
            }
        }
        
        return isPresent;
    }
    
    public int expressiveWords(String S, String[] words) {
        List<Pair<Integer, Integer>> sourceBucket = bucketize(S);
        int counter = 0;
        for(int idx = 0; idx < words.length; idx++){
            List<Pair<Integer, Integer>> tempBucket = bucketize(words[idx]);
            if(compare(S, words[idx], sourceBucket, tempBucket)){
                counter++;
            }
        }
        
        return counter;
    }
}

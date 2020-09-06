/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
class Solution {
    private void validparanthesis(ArrayList<String> result, String s, int open, int close, int n){
        if(s.length() == n * 2){
            result.add(s);
            return;
        }
        
        if(open < n){
            validparanthesis(result, s + "(", open + 1, close, n);
        }
        
        if(close < open){
            validparanthesis(result, s + ")", open, close + 1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        String s = "";
        validparanthesis(result, s, 0, 0, n);
        
        return result;
    }
}

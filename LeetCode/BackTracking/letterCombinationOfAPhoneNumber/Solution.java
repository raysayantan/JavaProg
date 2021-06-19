/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution {
    private Map<Character, List<Character>> map = new HashMap<>();
    private void init(){
        map.put('2', Arrays.asList(new Character[] {'a', 'b', 'c'}));
        map.put('3', Arrays.asList(new Character[] {'d', 'e', 'f'}));
        map.put('4', Arrays.asList(new Character[] {'g', 'h', 'i'}));
        map.put('5', Arrays.asList(new Character[] {'j', 'k', 'l'}));
        map.put('6', Arrays.asList(new Character[] {'m', 'n', 'o'}));
        map.put('7', Arrays.asList(new Character[] {'p', 'q', 'r', 's'}));
        map.put('8', Arrays.asList(new Character[] {'t', 'u', 'v'}));
        map.put('9', Arrays.asList(new Character[] {'w', 'x', 'y', 'z'}));
    }
    
    private void dfs(String digits, int pos, StringBuilder number, List<String> res){
        if(pos == digits.length()){
            if(number.length() > 0)
                res.add(number.toString());
            return;
        }
        
        char c = digits.charAt(pos);
        List<Character> list = map.get(c);
        System.out.println(list);
        for(char ch : list){
            number.append(ch);
            dfs(digits, pos + 1, number, res);
            number.setLength(number.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        init();
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }
}

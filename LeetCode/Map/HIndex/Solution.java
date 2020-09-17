/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int hIndex = 0;
        TreeMap<Integer, Integer> order = new TreeMap<>(Collections.reverseOrder());
        for(int idx = 0; idx < len; idx++){
            if(order.containsKey(citations[idx])){
                order.put(citations[idx], order.get(citations[idx]) + 1);
            } else {
                order.put(citations[idx], 1);
            }
        }
        int counter = 0;
        for(Map.Entry<Integer, Integer> e : order.entrySet()){
            int first = e.getKey();
            int second = e.getValue();
            counter += second;
            if(first >= counter){
                hIndex = counter;
            } else {
                hIndex = Math.max(first, hIndex);
                break;
            }
        }
        
        return hIndex;
    }
}

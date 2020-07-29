/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
class Solution {
    public int maxProfit(int[] prices) {
        //We will use dynamic programming to solve this. We have an array dp[len][2]
        //There are two possiblities on a day i, and this 2 is the Array's 2nd dim
        //1 - we have stock on that day : max of below two
        //    - We buy on that day 
        //          It means we have sold at day i - 2 => dp[i - 2][0] - prices[i]
        //    - We just carrying forward from prev => dp[i - 1][1]
        //2 - we don't have stock on that day, it max of below two
        //    - we sold that day => dp[i - 1][1] + prices[i]
        //    - we just carrying forward prev with no action => dp[i - 1][0]
        
        int len = prices.length;
        //if we have only one element
        if(len <= 1)
            return 0;
        
        //if we have exactly 2 elements
        if(len == 2 && prices[1] > prices[0])
            return (prices[1] - prices[0]);
        else if(len == 2 && prices[1] < prices[0])
            return 0;
        
        int[][] dp = new int[len][2];
        //we are here means we have more than two elements, lets calculate the first two 
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        
        for(int i = 2; i < len; i++){
            dp[i][0] = Math.max(dp[i- 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        
        //at the very last day we should nat have any stock at hand
        return dp[len - 1][0];
    }
}

/*
You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.

Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.

 

Example 1:

Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
Output: 4
Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
No other pairs satisfy the condition, so we return the max of 4 and 1.
Example 2:

Input: points = [[0,0],[3,0],[9,2]], k = 3
Output: 3
Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
 

Constraints:

2 <= points.length <= 105
points[i].length == 2
-108 <= xi, yi <= 108
0 <= k <= 2 * 108
xi < xj for all 1 <= i < j <= points.length
xi form a strictly increasing sequence.
*/
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        /* 
         As xi < xj, yi + yj + |xi - xj| = (yi - xi) + (yj + xj)
        */
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            new Comparator<Pair<Integer, Integer>>(){
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                    Integer num1 = p1.getKey();
                    Integer num2 = p2.getKey();
                    
                    return num2.compareTo(num1);
                }
            });
        
        pq.add(new Pair<Integer, Integer>(points[0][1] - points[0][0], points[0][0]));
        int ans = Integer.MIN_VALUE;
        for(int idx = 1; idx < points.length; idx++){
            while(!pq.isEmpty() && (points[idx][0] - pq.peek().getValue()) > k){
                pq.poll();
            }
            
            if(!pq.isEmpty()){
                ans = Math.max(pq.peek().getKey() + (points[idx][0] + points[idx][1]), ans);
            }
            pq.add(new Pair<Integer, Integer>(points[idx][1] - points[idx][0], points[idx][0]));
        }
        
        return ans;
    }
}

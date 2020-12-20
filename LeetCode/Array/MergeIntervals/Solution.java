/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover 
all the intervals in the input. 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] p1, int[] p2){
               if(p1[0] != p2[0]){
                   return p1[0] - p2[0];
               } else {
                   return p1[1] - p2[1];
               }
           } 
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<ArrayList<Integer>> res = new ArrayList<>();
        for(int idx = 1; idx < intervals.length; idx++){
            if(intervals[idx][0] > end){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(start);
                l.add(end);
                res.add(l);
                start = intervals[idx][0];
                end = intervals[idx][1];                
            } else {
                //overlapping
                end = Math.max(end, intervals[idx][1]);
            }
        }
        
        ArrayList<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        res.add(l);
        
        int[][] result = new int[res.size()][2];
        for(int idx = 0; idx < res.size(); idx++){
            result[idx][0] = res.get(idx).get(0);
            result[idx][1] = res.get(idx).get(1);
        }
        
        return result;
    }
}

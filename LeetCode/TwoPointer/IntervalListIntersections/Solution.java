/*
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. 
Each list of intervals is pairwise disjoint and in sorted order. Return the intersection of these two interval lists.

A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b. The intersection of two closed intervals is a set of real numbers 
that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:

Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
Example 3:

Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
Example 4:

Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
 

Constraints:

0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109
endj < startj+1
*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int flen = firstList.length;
        int slen = secondList.length;
        if(slen == 0 || flen == 0) return new int[0][0];
        int i = 0;
        int j = 0;
        List<ArrayList<Integer>> res = new ArrayList<>();
        while(i < flen && j < slen){
            ArrayList<Integer> l = new ArrayList<>();
            if(firstList[i][0] < secondList[j][0]){
                l.add(secondList[j][0]);
                if(firstList[i][1] >= secondList[j][0]){
                    if(firstList[i][1] < secondList[j][1]){
                        l.add(firstList[i][1]);
                        i++;
                    } else {
                        l.add(secondList[j][1]);
                        j++;
                    }
                    
                    res.add(l);
                } else {
                    i++;
                }
            } else {
                l.add(firstList[i][0]);
                if(secondList[j][1] >= firstList[i][0]){
                    if(secondList[j][1] < firstList[i][1]){
                        l.add(secondList[j][1]);
                        j++;
                    } else {
                        l.add(firstList[i][1]);
                        i++;
                    }
                    
                    res.add(l);
                } else {
                    j++;
                }
            }
        }
        
        int[][] result = new int[res.size()][2];
        int idx = 0;
        for(ArrayList<Integer> l : res){
            result[idx][0] = l.get(0);
            result[idx][1] = l.get(1);
            idx++;
        }
        
        return result;
    }
}

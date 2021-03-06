/*
There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.

Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1
Explanation: The tap at point 0 can cover the interval [-3,3]
The tap at point 1 can cover the interval [-3,5]
The tap at point 2 can cover the interval [1,3]
The tap at point 3 can cover the interval [2,4]
The tap at point 4 can cover the interval [4,4]
The tap at point 5 can cover the interval [5,5]
Opening Only the second tap will water the whole garden [0,5]
Example 2:

Input: n = 3, ranges = [0,0,0,0]
Output: -1
Explanation: Even if you activate all the four taps you cannot water the whole garden.
Example 3:

Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
Output: 3
Example 4:

Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
Output: 2
Example 5:

Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
Output: 1
 

Constraints:

1 <= n <= 10^4
ranges.length == n + 1
0 <= ranges[i] <= 100
*/
class Solution {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>(){
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
                    Integer key1 = p1.getKey();
                    Integer key2 = p2.getKey();
                    if(key1 != key2){
                        return key1.compareTo(key2);
                    }
                    
                    Integer val1 = p1.getValue();
                    Integer val2 = p2.getValue();
                    return val1.compareTo(val2);
                }
        });
        
        for(int idx = 0; idx < ranges.length; idx++){
            if(ranges[idx] == 0) continue;
            int start = idx - ranges[idx];
            int end = idx + ranges[idx];
            if(start < 0)
                start = 0;
            
            pq.add(new Pair<Integer, Integer>(start, end));
        }
        
        int counter = 0;
        int currStart = 0;
        int currEnd = 0;
        if(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.poll();
            currStart = p.getKey();
            currEnd = p.getValue();
        }
        
        while(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.poll();
            int start = p.getKey();
            int end = p.getValue();
            
            if(start > currStart){
                counter++;
                currStart = currEnd;
            }
            if(start > currEnd + 1) {
                return -1;
            }
            if(start <= currEnd + 1){
                if(end <= currEnd) {
                    continue;
                }
                if(end > currEnd){
                    currEnd = end;
                }
            }
            
            if(currEnd >= n){
                counter++;
                break;
            }
        }
        
        if(currEnd < n)
            return -1;
        
        return counter;
    }
}

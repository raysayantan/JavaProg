/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] slot1, int[] slot2){
                return (slot1[0] - slot2[0]);
            }
        });
        //Will put the end time of each slot
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int counter = 0;
        for(int idx = 0; idx < intervals.length; idx++){
            int startTime = intervals[idx][0];
            int endTime = intervals[idx][1];
            
            if(!pq.isEmpty() && startTime >= pq.peek()){
                pq.poll();
            } else {
                counter++;
            }
            pq.add(endTime);
        }
        
        return counter;
    }
}

/*
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104
*/
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
        
        //This will store triplet(startTime, endTime, profit)
        int[][] jobs = new int[len][3];
        
        for(int idx = 0; idx < len; idx++){
            jobs[idx][0] = startTime[idx];
            jobs[idx][1] = endTime[idx];
            jobs[idx][2] = profit[idx];
        }
        
        //Sort the array based on endtime. When we traverse through the 
        //Array i.e. jobs, we have two options, 1. we can do this job or 
        //2. do not. So, we will find the profit of the end time less 
        //than or equal to the curr start time i.e. prevProfit and
        //currProfit = prevProfit + jobs[2]. If this is greater than
        //the curr max profit we will store than in map, else discard
        Arrays.sort(jobs, (arr1, arr2) -> arr1[1] - arr2[1]);
        //This will store the key as endTime and value as max profit till now
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for(int[] job : jobs){
            int currProfit = map.floorEntry(job[0]).getValue() + job[2];
            int prevProfit = map.lastEntry().getValue();
            if(currProfit > prevProfit){
                map.put(job[1], currProfit);
            }
        }
        
        return map.lastEntry().getValue();
    }
}

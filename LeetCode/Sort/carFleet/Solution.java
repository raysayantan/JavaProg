/*
N cars are going to the same destination along a one lane road.  The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


How many car fleets will arrive at the destination?

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.

Note:

0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
All initial positions are different.
*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>(){
            public int compare(Integer m1, Integer m2){
                return m2.compareTo(m1);
            }
        });
        for(int idx = 0; idx < position.length; idx++){
            map.put(position[idx], speed[idx]);
        }
        
        Double lastTime = -1.0;
        int fleet = 0;
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int pos = e.getKey();
            int s = e.getValue();
            double t = (target - pos)/(double)s;
            if(t > lastTime){
                lastTime = t;
                fleet++;
            }
        }
        
        return fleet;
    }
}

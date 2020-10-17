/*
There are N network nodes, labelled 1 to N.
Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, 
and w is the time it takes for a signal to travel from source to target. 
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 
Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
*/
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] cost = new int[N + 1];
        
        for(int i = 0; i < N + 1; i++){
            cost[i] = Integer.MAX_VALUE;
        }
        
        //create the adj list
        int len = times.length;
        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> adj = new HashMap<>();
        for(int idx = 0; idx < len; idx++){
            int u = times[idx][0];
            int v = times[idx][1];
            int w = times[idx][2];
            
            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            
            adj.get(u).add(new Pair<Integer, Integer>(v, w));
        }
        
        //use BFS to calculate cost
        q.add(K);
        cost[K] = 0;
        int total = 0;
        while(!q.isEmpty()){
            int front = q.remove();
            for(int idx = 0; adj.containsKey(front) && idx < adj.get(front).size(); idx++){
                Pair<Integer, Integer> p = adj.get(front).get(idx);
                int v = p.getKey();
                int w = p.getValue();
                
                if(cost[v] > cost[front] + w){
                    cost[v] = cost[front] + w;
                    q.add(v);
                }
                
            }
        }
        
        
        for(int idx = 1; idx <= N; idx++){
            if(cost[idx] == Integer.MAX_VALUE){
                return -1;
            }
            
            total = Math.max(total, cost[idx]);
        }
        
        return total;
    }
}

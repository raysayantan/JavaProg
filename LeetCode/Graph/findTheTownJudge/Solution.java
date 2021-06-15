/*
In a town, there are n people labelled from 1 to n.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: n = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= n
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        int judge = -1;
        //we will represent a directed edge from person1 to person2
        //if person1 trust person2. This means, there will be an
        //in coming edge to person2. We will keep all the incoming
        //edge count in an array, indegree. The one who is judge, 
        //will have (n-1) incoming edge, as all other than the judge 
        //trust the judge. And the outdegree array will have the out
        //wards edge count, for the judge it will be 0, as it trust none
        for(int idx = 0; idx < trust.length; idx++){
            int person1 = trust[idx][0];
            int person2 = trust[idx][1];
            outdegree[person1 - 1]++;
            indegree[person2 - 1]++;
        }
        
        for(int idx = 0; idx < n; idx++){
            if(outdegree[idx] == 0){
                if(indegree[idx] == n - 1){
                    judge = idx + 1;
                }
                
                break;
            }
        }
        
        return judge;
    }
}

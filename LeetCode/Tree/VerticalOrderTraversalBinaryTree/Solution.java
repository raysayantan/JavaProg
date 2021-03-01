/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int low = 0;
        int high = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        if(root == null) 
            return res;
        q.add(new Pair<TreeNode, Integer>(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
            for(int idx = 0; idx < size; idx++){
                Pair<TreeNode, Integer> p = q.remove();
                TreeNode node = p.getKey();
                int level = p.getValue();
                low = Math.min(low, level);
                high = Math.max(high, level);
                if(!m.containsKey(level)){
                    m.put(level, new ArrayList<Integer>());
                }
                ArrayList<Integer> t = m.get(level);
                t.add(node.val);
                m.put(level, t);
                if(node.left != null){
                    q.add(new Pair<TreeNode, Integer>(node.left, level - 1));
                }
                if(node.right != null){
                    q.add(new Pair<TreeNode, Integer>(node.right, level + 1));
                }
            }
            
            for(Map.Entry<Integer,ArrayList<Integer>> e : m.entrySet()){
                int key = e.getKey();
                ArrayList<Integer> l = e.getValue();
                Collections.sort(l);
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                ArrayList<Integer> t = map.get(key);
                t.addAll(l);
                map.put(key, t);
            }
        }
        
        for(int idx = low; idx <= high; idx++){
            res.add(map.get(idx));
        }
        
        return res;
    }
}

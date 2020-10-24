/*
Given a binary tree, return the sum of values of its deepest leaves. 

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
 
Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return 0;
        }
        
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()){
            sum = 0;
            int size = q.size();
            for(int idx = 0; idx < size; idx++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                
                if(node.right != null){
                    q.add(node.right);
                }
                
                sum += node.val;
            }
        }
        return sum;
    }
}

/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

Constraints:
The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
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
    private int sum = 0;
    private int maxlevel = 0;
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(level == maxlevel){
            sum += root.val;
        } else if(level > maxlevel){
            maxlevel = level;
            sum = root.val;
        }
        if(root.left != null)
            helper(root.left, level + 1);
        if(root.right != null)
            helper(root.right, level + 1);
    }
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}

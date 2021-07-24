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
    int minDepth = Integer.MAX_VALUE;
    private void helper(TreeNode root, int level){
        if(root == null){
            minDepth = 0;
            return;
        }
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth, level);
            return;
        }
        
        if(level > minDepth)
            return;
        
        if(root.left != null){
            helper(root.left, level + 1);
        }
        
        if(root.right != null){
            helper(root.right, level + 1);
        }
    }
    public int minDepth(TreeNode root) {
        helper(root, 1);
        return minDepth;
    }
}

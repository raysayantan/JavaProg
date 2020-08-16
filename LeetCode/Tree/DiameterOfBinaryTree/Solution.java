/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
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
    private int maxDia = 0;
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int diameter = left + right;
        maxDia = Math.max(diameter, maxDia);
        
        return (Math.max(left, right) + 1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int h = helper(root);
        return maxDia;
    }
}

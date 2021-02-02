/**
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any path.
Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
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
    int maxSum = -2000;
    public int maxPathSum(TreeNode root){
        int temp = maxPathSumHelper(root);
        return maxSum;
    }
    public int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return -1001;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        int maxSubtree = Math.max(left, right);
        int maxWithRoot = Math.max(maxSubtree, maxSubtree + root.val);
        int maxtill = Math.max(maxWithRoot, root.val);
        int maxPath = Math.max(left + right + root.val, maxtill);
        maxSum = Math.max(maxPath, maxSum);
        return Math.max(left + root.val, Math.max(right + root.val, root.val));
    }
}

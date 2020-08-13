/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public void helper(TreeNode root, List<String> paths, String path){
        if(root.left == null && root.right == null){
            path += root.val;
            paths.add(path);
            return;
        }
        
        path = path + root.val + "->";
        if(root.left != null){
            helper(root.left, paths, path);
        }
        
        if(root.right != null){
            helper(root.right, paths, path);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        
        if(root == null){
            return paths;
        }
        
        String path = "";
        helper(root, paths, path);
        
        return paths;
    }
}

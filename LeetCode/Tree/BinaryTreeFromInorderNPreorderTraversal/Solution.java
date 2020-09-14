/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    int idx = 0;
    public TreeNode helper(int[] pre, int[] in, int s, int e){
        if(s > e){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[idx]);
        int inIdx = 0;
        for(int i = s; i <= e; i++){
            if(pre[idx] == in[i]){
                inIdx = i;
                break;
            }
        }
        idx++;
        root.left = helper(pre, in, s, inIdx - 1);
        root.right = helper(pre, in, inIdx + 1, e);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
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
    private boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        
        if(s == null || t == null){
            return false;
        }
        
        if(s.val != t.val){
            return false;
        }
        
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        if(t == null)
            return true;
        if(s == null && t != null)
            return false;
        q.add(s);
        while(!q.isEmpty()){
            TreeNode front = q.remove();
            if(helper(front, t) == true){
                return true;
            }
            
            if(front.left != null)
                q.add(front.left);
            if(front.right != null)
                q.add(front.right);
        }
        
        return false;
    }
}

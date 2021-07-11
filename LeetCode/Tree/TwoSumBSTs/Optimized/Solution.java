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
    Set<Integer> s = new HashSet<>();
    void constructSet(TreeNode root, int target){
        if(root == null)
            return;
        constructSet(root.left, target);
        s.add(target - root.val);
        constructSet(root.right, target);
    }
    
    boolean search(TreeNode root){
        if(root == null)
            return false;
        return (s.contains(root.val) || search(root.left) || search(root.right));
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        constructSet(root1, target);
        return search(root2);
    }
}

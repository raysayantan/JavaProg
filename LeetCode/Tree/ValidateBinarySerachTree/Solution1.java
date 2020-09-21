class Solution1 {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        boolean left = isValidBST(root.left);
        if(prev != null && root.val <= prev.val){
            return false;
        }
        
        prev = root;
        boolean right = isValidBST(root.right);
        
        return (left & right);
    }
}

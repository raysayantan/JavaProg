/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return res.toString();
        q.add(root);
        res.append(root.val);
        while(!q.isEmpty()){
            TreeNode top = q.remove();
            if(top.left != null){
                q.add(top.left);
                res.append(" ").append(top.left.val);
            } else {
                res.append(" ").append("null");
            }
            
            if(top.right != null){
                q.add(top.right);
                res.append(" ").append(top.right.val);
            } else {
                res.append(" ").append("null");
            }
        }
        System.out.println(res.toString());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isBlank() || data.isEmpty())
            return null;
        TreeNode start = null;
        String[] strs = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        int idx = 0;
        q.add(new TreeNode(Integer.parseInt(strs[idx++])));
        while(!q.isEmpty() && idx < strs.length){
            TreeNode top = q.remove();
            if(start == null)
                start = top;
            TreeNode left = (strs[idx].equals("null")) ? null : new TreeNode(Integer.parseInt(strs[idx]));
            idx++;
            TreeNode right = (strs[idx].equals("null")) ? null : new TreeNode(Integer.parseInt(strs[idx]));
            idx++;
            if(left != null){
                q.add(left);
            }
            if(right != null){
                q.add(right);
            }
            top.left = left;
            top.right = right;
        }
        
        return start;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

 

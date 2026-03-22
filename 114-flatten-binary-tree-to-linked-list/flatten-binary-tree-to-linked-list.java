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
    public void flatten(TreeNode root) {

        if(root==null) return;
        
        Stack<TreeNode> st = new Stack<>();

        while(root!=null || (!st.isEmpty()) ){
            
            if(root.right!=null) st.push(root.right);
            root.right=root.left;
            root.left=null;
            
            if(root.right!=null) root=root.right;
            else{
                if(!st.isEmpty()) root.right=st.pop();
                root=root.right;
            }
            
        }
    }
}
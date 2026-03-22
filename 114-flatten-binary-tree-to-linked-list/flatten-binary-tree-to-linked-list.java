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



// Approach 2: Morris preorder approach
// Time: O(N)   Space: O(1)



// Approach 1: Used Stack to save right subtree and place left in place of right subtree and so on.
// Time: O(N)   Space: O(N)

class Solution {
    public void flatten(TreeNode root) {

        if(root==null) return;
        
        Stack<TreeNode> st = new Stack<>();

        while(root!=null || (!st.isEmpty()) ){
            
            if(root.right!=null) st.push(root.right);
            root.right=root.left;
            root.left=null;                        // IMP: you will forget it to do
            
            if(root.right!=null) root=root.right;
            else{
                if(!st.isEmpty()) root.right=st.pop();
                root=root.right;
            }
            
        }
    }
}

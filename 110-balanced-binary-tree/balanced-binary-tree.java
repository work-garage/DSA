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
    public boolean isBalanced(TreeNode root) {
        int i = helper(root);
        if(i>99999) return false;
        return true;
    }
    int helper(TreeNode node){
        if(node==null) return 0;
        int l = helper(node.left);
        int j = helper(node.right);
        if(!(l-j>=-1 && l-j<=1)) return 999999;

        return 1+Math.max(l,j);
    }
}

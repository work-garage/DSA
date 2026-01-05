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
    public int maxDepth(TreeNode root) {
        int height = 0;
        return helper(root, height, 0);
    }
    public int helper(TreeNode root, int height, int max) {
        if(root==null) return max;
        height++;
        if(height>max) max = height;
        int h1 = helper(root.left,height,max);
        if(h1>max) max = h1;
        int h2 = helper(root.right,height,max);
        if(h2>max) max = h2;
        return max;
    }
}
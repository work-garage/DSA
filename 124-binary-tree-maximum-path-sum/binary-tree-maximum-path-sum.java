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

    static int max=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;

        max = root.val;

        helper(root);
        return max;
    }

    public int helper(TreeNode root) {

        if(root==null) return 0;

        int l = helper(root.left);

        int j = helper(root.right);

        int s1 = root.val+l;
        int s2 = root.val+j;

        int s3 = Math.max(root.val,Math.max(s1,s2));

        int s = root.val+l+j;
        max = Math.max(max,Math.max(s,s3));

        return s3;
    }
}
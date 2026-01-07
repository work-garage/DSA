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
    long maxPrd;
    public int maxProduct(TreeNode root) {
        long sum = sum_of_all_nodes(root);
        helper(root,sum);
        return (int) (maxPrd % 1000000007 );
    }
    public long helper(TreeNode root, long sum) {
        if(root==null) return 0;

        long s1 = helper(root.left, sum);
        long s3 = sum - s1;
        long s2 = helper(root.right, sum);
        long s4 = sum - s2;

        maxPrd = Math.max(maxPrd, Math.max(s1*s3,s2*s4));

        return (root.val+s1+s2);
    }
    long sum_of_all_nodes(TreeNode root){
        if(root==null) return 0;

        long s1 = sum_of_all_nodes(root.left);
        long s2 = sum_of_all_nodes(root.right);

        return (root.val+s1+s2);
    }
}
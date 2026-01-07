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
    public long helper(TreeNode root, long sum) { //can also make sum as global var to prevent parameter
        if(root==null) return 0;

        long s1 = helper(root.left, sum);
        long s2 = helper(root.right, sum);

        long val = root.val+s1+s2;

        maxPrd = Math.max(maxPrd, val*(sum-(val)) );

        return val;
    }
    long sum_of_all_nodes(TreeNode root){
        if(root==null) return 0;

        long s1 = sum_of_all_nodes(root.left);
        long s2 = sum_of_all_nodes(root.right);

        return (root.val+s1+s2);
    }
}
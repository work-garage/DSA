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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = helper(root);
        return arr[1];
    }

    int[] helper(TreeNode root){
        int[] a = {0,0};
        if(root==null) return a;

        int[] l = helper(root.left);

        int[] j = helper(root.right);

        int sum = l[0]+j[0];

        int[] height_max = new int[2];
        
        height_max[1] = Math.max(l[1],j[1]);

        if(sum>= Math.max(l[1],j[1]) ) height_max[1] = sum;
        height_max[0] = 1 + Math.max(l[0],j[0]);
        return height_max;
    }
}
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        int[] v = helper(p,q);
        if(v[0]!=v[1]) return false;
        return (!Arrays.equals(v,new int[]{-1,-1}));        //OR can do, v[0]==-1 && v[1]==-1
    }
    public int[] helper(TreeNode p, TreeNode q) {
        int[] v = {0,0};
        if(p==null && q==null) return v;
        if(p==null || q==null) return (new int[]{-1,-1});

        int[] v1 = helper(p.left, q.left);
        if(Arrays.equals(v1,new int[]{-1,-1})) return (new int[]{-1,-1});
        if(v1[0]!=v1[1]) return (new int[]{-1,-1});

        int[] v2 = helper(p.right,q.right);
        if(Arrays.equals(v2,new int[]{-1,-1})) return (new int[]{-1,-1});
        if(v2[0]!=v2[1]) return (new int[]{-1,-1});
        
        v[0] = p.val;
        v[1] = q.val;

        return v;
    }
}
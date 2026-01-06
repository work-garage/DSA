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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();     //queue in java
        if(root==null) return 0;
        q.add(root);
        int ansLevel = 0;
        int maxSum = Integer.MIN_VALUE;
                //in any Q if asks for max value and contains -ve elems,
                // Then take initial value as Integer.MIN_VALUE
        int times=1;
        int level = 1;

        while(!q.isEmpty()){
            int t=times;
            times = 0;
            int currSum = 0;
            for(int i=1; i<=t; i++){
                TreeNode n = q.remove();
                currSum+=n.val;
                if(n.left!=null){
                    q.add(n.left);
                    times++;
                }
                if(n.right!=null){
                    q.add(n.right);
                    times++;
                }
            }
            if(currSum>maxSum){
                maxSum = currSum;
                ansLevel = level;
            }
            level++;
        }
        return ansLevel;
    }
}
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
        int ansLevel = 1;
        int maxSum = root.val;      //1st node value
                //in any Q if asks for max value and contains -ve elems,
                // Then take initial value as first element or Integer.MIN_VALUE
        int level = 1;

        while(!q.isEmpty()){
            int currSum = 0;
            int currSize = q.size();
            for(int i=1; i<=currSize; i++){
                TreeNode n = q.remove();
                currSum+=n.val;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
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
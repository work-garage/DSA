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

    // Recursion:
    public TreeNode insertIntoBST(TreeNode root, int val) {
       TreeNode upd = dfs(root, val);
        if (upd != null) {
            return upd;
        }
        return root;
    }

    private TreeNode dfs(TreeNode curr, int val) {

        if (curr == null) {
            return new TreeNode(val);
        }

        if (val < curr.val) {
            TreeNode left = dfs(curr.left, val);
            if (left != null) {
                curr.left = left;
            }
        } else {
            TreeNode right = dfs(curr.right, val);
            if (right != null) {
                curr.right = right;
            }
        }
        return null;
    }




    // My Approach(Iteration) of adding elem in last, when null is found
    // But, form an unbalanced BST

    // public TreeNode insertIntoBST(TreeNode root, int val) {

    //     if(root==null) return new TreeNode(val);
        
    //     TreeNode curr = root;

    //     while(true){

    //         if(curr.val<val){

    //             if(curr.right!=null) curr=curr.right;
    //             else break;                             //break off loop before going to null
    //         }
    //         else{   //curr.val>val
    //             if(curr.left!=null) curr=curr.left;
    //             else break;                             //break off loop before going to null
    //         }
    //     }
        
    //     if(curr.val>val) curr.left = new TreeNode(val); //add given elem in place of null in last level
    //     else curr.right = new TreeNode(val);

    //     return root;
    // }
}

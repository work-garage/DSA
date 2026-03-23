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

    // search in BST: O(log N) if balanced bst
    //                O(N)     if unbalanced bst


    //Standard soln
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null) return null;

        if(root.val==val) return root;
        else if(root.val>val) return searchBST(root.left,val);          //you'll forget to write return
        else return searchBST(root.right,val);                          //you'll forget to write return

    }

    //OR

    //my soln, same approach

    // public TreeNode searchBST(TreeNode root, int val) {

    //     if(root==null) return null;

    //     if(root.val==val) return root;
    //     else if(root.val>val) root=root.left;
    //     else root=root.right;

    //     TreeNode t = searchBST(root,val);
    //     if(t!=null) return t;
    //     else return null;
    // }
}
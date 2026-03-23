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

    // Optimised Approach:

    // There are 3 main cases:
    
    // Leaf Node: Just delete it.
    // One Child: Replace node with its only child.
    // Two Children: Join right subtree to inorder predecessor (rightmost of left subtree) or Join left subtree to inorder successor (leftmost of right subtree). We’ll use predecessor here.

    // Time Complexity: O(h) — height of the tree
    // Space Complexity: O(1) — iterative traversal, no extra space

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // If root itself is the node to delete
        if (root.val == key) {
            return helper(root);
        }

        TreeNode dummy = root;

        while (root != null) {

            if (root.val > key) {
                // Go left
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                // Go right
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return dummy;
    }

    // Handles deletion logic
    public TreeNode helper(TreeNode root) {

        // Case 1: No left child
        if (root.left == null) {
            return root.right;
        }

        // Case 2: No right child
        else if (root.right == null) {
            return root.left;
        }

        // Case 3: Both children exist
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);

            // Attach right subtree to rightmost node of left subtree
            lastRight.right = rightChild;

            return root.left;
        }
    }

    // Find the rightmost node in a subtree
    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}







// my Approach Code
// Not a good choice + not complete

// public TreeNode deleteNode(TreeNode root, int val) {

//     if(root==null) return root;

//     TreeNode curr=root;
//     TreeNode preCurr;               //default val?

//     while(curr!=null){

//         if(curr==null) return root;

//         if(curr.val==val){
//             // Case 1
//             if(curr.left==null && curr.right==null){
//                 curr=preCurr;
//                 if(curr.left.val==val) curr.left=null;
//                 else curr.right=null;
//                 break;
//             }

//             // Case 2) i)
//             else if(curr.left!=null){
//                 if(preCurr.right.val==val) preCurr.right=curr.left;
//                 else preCurr.left=curr.left;
//             }
//             // Case 2) ii)
//             else if(curr.left!=null){
//                 if(preCurr.right.val==val) preCurr.right=curr.left;
//                 else preCurr.left=curr.left;
//             }

//             // Case 3) //using left subtree, rightmost elem (inorder predecessor)
//             else{
                
//             }
//         }
//         else if(curr.val>val){
//             preCurr=curr;
//             curr=curr.left;
//         }
//         else{
//             preCurr=curr;
//             curr=curr.right;
//         }
//     }

//     return root;
// }

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

// class Solution {


//     // Recursion:
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         return dfs(root, val);
//     }

//     private TreeNode dfs(TreeNode curr, int val) {

//         if (curr == null) {
//             return new TreeNode(val);   // insert here
//         }

//         if (val < curr.val) {
//             curr.left = dfs(curr.left, val);
//         } else {
//             curr.right = dfs(curr.right, val);
//         }

//         return curr;   // return updated subtree
//     }



//     // My Approach(Iteration) of adding elem in last, when null is found
//     // But, form an unbalanced BST

//     // public TreeNode insertIntoBST(TreeNode root, int val) {

//     //     if(root==null) return new TreeNode(val);
//     //     TreeNode curr = root;

//     //     while(true){
//     //         if(curr.val<val){

//     //             if(curr.right!=null) curr=curr.right;
//     //             else break;                             //break off loop before going to null
//     //         }
//     //         else{   //curr.val>val
//     //             if(curr.left!=null) curr=curr.left;
//     //             else break;                             //break off loop before going to null
//     //         }
//     //     }
        
//     //     if(curr.val>val) curr.left = new TreeNode(val); //add given elem in place of null in last level
//     //     else curr.right = new TreeNode(val);
    
//     //     return root;
//     // }

// }






// Another Approach: like given in example 1 Another accepted tree approach
//         It says: take given val as root, now insert given tree according to root, which is another acceptable solution

class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Step 1: Create new root
        TreeNode newRoot = new TreeNode(val);

        // Step 2: Insert old tree into new root
        insertTree(newRoot, root);

        return newRoot;
    }

    // Insert entire tree into another BST
    private void insertTree(TreeNode root, TreeNode node) {
        if (node == null) return;

        insert(root, node.val);

        insertTree(root, node.left);
        insertTree(root, node.right);
    }

    // Normal BST insert
    private void insert(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) root.left = new TreeNode(val);
            else insert(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else insert(root.right, val);
        }
    }
}

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



// Approach 2: Morris preorder approach
// Time: O(N)   Space: O(1)

// Steps:
// Start from the root node.
// If the current node has a left child:
//     Find the rightmost node of the left subtree.
//     Attach that node’s right to the current node’s right subtree.
//     Move the left subtree to the right and set left = null.
// Move to the right child and repeat.





// Approach 1: Used Stack to save right subtree and place left in place of right subtree and so on.
// Time: O(N)   Space: O(N)

class Solution {

    public void flatten(TreeNode root) {

        if(root==null) return;
        
        Stack<TreeNode> st = new Stack<>();

        while(root!=null || (!st.isEmpty()) ){
            
            if(root.right!=null) st.push(root.right);
            root.right=root.left;
            root.left=null;                        // IMP: you will forget it to do
            
            if(root.right!=null) root=root.right;
            else{
                if(!st.isEmpty()) root.right=st.pop();
                root=root.right;
            }
            
        }
    }

}


// OR


// Approach: Do Normal Preorder traversal using recursion and make like LL

// public void flatten(TreeNode root) {
//     if (root == null) return;
//     List<TreeNode> nodes = new ArrayList<>();
//     preorder(root, nodes);

//     for (int i = 0; i < nodes.size() - 1; i++) {
//         nodes.get(i).left = null;
//         nodes.get(i).right = nodes.get(i + 1);
//     }
// }

// private void preorder(TreeNode node, List<TreeNode> nodes) {
//     if (node == null) return;
//     nodes.add(node);
//     preorder(node.left, nodes);
//     preorder(node.right, nodes);
// }

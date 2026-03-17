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



// Approach: O( (log N)^2 )

// class Solution {
    
// }







class Solution {

    // Approach: Using DFS: Compute tree height. using height, count total nodes till height-1 level, count nodes in last level using dfs.

    // ans = total till h-1 + nodes in last level

    // DFS: It runs in O(n) time (single traversal) and O(h) recursion stack (h = height).

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        // I wanted a variable which can be serve value outside of recursion
        // Can't use Integer(wrapper) as they are immutable, so Used single element array
        int[] height = new int[1]; // holds the maximum depth found
        int[] lastLevelNodesCnt = new int[1]; // count of nodes at the deepest level

        // traverse once: update height[0] and lastLevelNodesCnt[0]
        helper(root, 1, height, lastLevelNodesCnt);

        // compute nodes in all levels except the last: sum_{i=0}^{height-2} 2^i
        int nodesInHeightMinus1 = 0;
        int pow = 1; // 2^0 initially
        for (int i = 0; i < height[0] - 1; i++) {
            nodesInHeightMinus1 += pow;
            pow *= 2;
        }

        return nodesInHeightMinus1 + lastLevelNodesCnt[0];
    }

    // Traverses tree, tracking depth and counting nodes on the deepest level seen.
    // currHeight starts at 1 for root.
    void helper(TreeNode root, int currHeight, int[] height, int[] lastLevelNodesCnt) {
        if (root == null) return;

        if(root.left==null && currHeight>=height[0]) height[0]=currHeight;

        if(root.left==null && root.right==null && currHeight==height[0]) lastLevelNodesCnt[0]+=1;

        helper(root.left, currHeight + 1, height, lastLevelNodesCnt);
        helper(root.right, currHeight + 1, height, lastLevelNodesCnt);
    }
}
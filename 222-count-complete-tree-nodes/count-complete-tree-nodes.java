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


// How the << Operator Works:


// The syntax for the left shift operator is operand1 << operand2. 
//     operand1: The integer value whose bits are to be shifted.
//     operand2: The number of positions to shift the bits to the left. 
// When the bits are shifted:
//     The leftmost bits that are shifted beyond the capacity of the data type are discarded.
//     The newly vacated positions on the right side are always filled with 0s. 
// This operation is equivalent to multiplying the original number by 2 raised to the power of the number of positions shifted (i.e., operand1 * 2^operand2). This makes it a very efficient way to perform fast multiplication by powers of 2. 
// [
//     Final Effect:
//     so, n<<x effects to:  n is multiplied by 2, x number of times.
//     example: n=3  x=3   3<<3 means: 3*2*2*2=24
// ]

// IMP: So, when in need to x time multiply by 2: can use << operator




// Approach 3(Optimised): it find height of tree from left and right side: by going extreme left and right.
// if left height == right height(last level full): return (1<<height - 1) nodes
// else:recursively select left and right child tree of it, and do the same again.

// Optimised:   O( (log N)^2 )  which is less than O(N)

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left==right) return (1<<left)-1;

        return countNodes(root.left) + countNodes(root.right) + 1; // +1 is root of them
    }

    int leftHeight(TreeNode root){

        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }

    int rightHeight(TreeNode root){

        int height=0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}






// class Solution {

//     // my Approach 1: Using DFS: Compute tree height. using height, count total nodes till height-1 level, count nodes in last level using dfs.

//     // ans = total till h-1 + nodes in last level

//     // DFS: It runs in O(n) time (single traversal) and O(h) recursion stack (h = height).

//     public int countNodes(TreeNode root) {
//         if (root == null) return 0;

//         // I wanted a variable which can be serve value outside of recursion
//         // Can't use Integer(wrapper) as they are immutable, so Used single element array
//         int[] height = new int[1]; // holds the maximum depth found
//         int[] lastLevelNodesCnt = new int[1]; // count of nodes at the deepest level

//         // traverse once: update height[0] and lastLevelNodesCnt[0]
//         helper(root, 1, height, lastLevelNodesCnt);

//         // compute nodes in all levels except the last: sum_{i=0}^{height-2} 2^i
//         int nodesInHeightMinus1 = 0;
//         int pow = 1; // 2^0 initially
//         for (int i = 0; i < height[0] - 1; i++) {
//             nodesInHeightMinus1 += pow;
//             pow *= 2;
//         }

//         return nodesInHeightMinus1 + lastLevelNodesCnt[0];
//     }

//     // Traverses tree, tracking depth and counting nodes on the deepest level seen.
//     // currHeight starts at 1 for root.
//     void helper(TreeNode root, int currHeight, int[] height, int[] lastLevelNodesCnt) {
//         if (root == null) return;

//         if(root.left==null && currHeight>=height[0]) height[0]=currHeight;

//         if(root.left==null && root.right==null && currHeight==height[0]) lastLevelNodesCnt[0]+=1;

//         helper(root.left, currHeight + 1, height, lastLevelNodesCnt);
//         helper(root.right, currHeight + 1, height, lastLevelNodesCnt);
//     }
// }







// Approach 2(Unique) Approach : count null children (N+1), then return (totalNulls - 1) → real nodes; e.g. tree [1,2,3] has 4 nulls → 4‑1 = 3 nodes

// Time  O(N)   Space O(N)
// class Solution {
//     public int countNodes(TreeNode root) {
//       return LookForNull(root)-1;  
//     } 
//     public int LookForNull(TreeNode root){
//             if(root == null) return 1;
//           int left =  LookForNull(root.left);
//           int right = LookForNull(root.right);
//           return left+right;
//     }
// }

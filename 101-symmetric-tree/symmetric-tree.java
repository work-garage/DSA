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



// More Clean approach: this is same as Symmetric Binary Tree Q approach
// Simultaneous checking Approach using recursion(dfs)

class Solution {
    // DFS(recursion) with simultaneous checking
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val){    // OR could write: return node1.val == node2.val 
                                        // && isMirror(node1.left, node2.right) 
                                        // && isMirror(node1.right, node2.left);
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        
        return false;       // values not equal
    }
}





// VS




// using BFS( Doubly Ended Queue (Deque) ) approach

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root.left==null && root.right==null) return true;
//         if(root.left==null || root.right==null) return false;
//         if(root.left.val!=root.right.val) return false;

//         Deque<TreeNode> deq = new LinkedList<>();
//         deq.addFirst(root.left);
//         deq.addFirst(root.right);

//         while(!deq.isEmpty()){
//             TreeNode n1 = deq.removeFirst();
//             TreeNode n2 = deq.removeLast();

//             if(n1!=null && n2!=null){
//                 if(n1.val!=n2.val) return false;
//             }

//             if(n1==null && n2==null) continue;

//             if(n1==null || n2==null) return false;

//             if(n1.left==null && n1.right==null){
//                 if(n2.left!=null && n2.right!=null){
//                     deq.addLast(n2.right);
//                     deq.addLast(n2.left);
//                 }
//                 continue;
//             }

//             if(n2.left==null && n2.right==null){
//                 if(n1.left!=null && n1.right!=null){
//                     deq.addFirst(n1.left);
//                     deq.addFirst(n1.right);
//                 }
//                 continue;
//             }

//             deq.addFirst(n1.left);
//             deq.addFirst(n1.right);

//             deq.addLast(n2.right);
//             deq.addLast(n2.left);
//         }
//         return true;
//     }
// }


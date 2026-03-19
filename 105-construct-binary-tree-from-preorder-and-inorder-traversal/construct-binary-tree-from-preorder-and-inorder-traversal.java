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




// Approach 2(Same approach, but optimized way)(Very Very IMP):
// (Imp)-if we use hashmap for getting index in inorder, we can Optimize O(N) to find idx in inorder to optimize from O(1). But still if too much collision in worst its O(log N). But we generally consider it as O(1).

// -instead of Arrays.copyOfRange make new array and takes worst of O(N), So to optimize to O(1), we can keep the same inorder array and pass 2 range pointers.

// (Imp)-instead of Queue, keep pointer preIdx on preorder array.



// Time complexity: O(n)     Space complexity: O(n)
// class Solution {
//     private int preIdx = 0;
//     private Map<Integer, Integer> inMap;

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         inMap = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             inMap.put(inorder[i], i);
//         }
//         return build(preorder, 0, inorder.length - 1);
//     }

//     private TreeNode build(int[] preorder, int inL, int inR) {
//         if (inL > inR) return null;

//         int rootVal = preorder[preIdx++];
//         TreeNode root = new TreeNode(rootVal);

//         int idx = inMap.get(rootVal);

//         root.left = build(preorder, inL, idx - 1);
//         root.right = build(preorder, idx + 1, inR);

//         return root;
//     }
// }




// Approach 1: Recursion approach, we take root node preorder and then left of root node of inorder are left tree ele, right of root node elems of inorder are right tree elem. So, recursively so on.
// Time complexity: O(n^2)     Space complexity: O(n^2)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> preorderQueue = new ArrayDeque<>();
        for (int val : preorder) {
            preorderQueue.offer(val);
        }

        return build(preorderQueue, inorder);        
    }

    private TreeNode build(Deque<Integer> preorder, int[] inorder) {
        if (inorder.length > 0) {
            int idx = indexOf(inorder, preorder.poll());
            TreeNode root = new TreeNode(inorder[idx]);

            root.left = build(preorder, Arrays.copyOfRange(inorder, 0, idx));
            root.right = build(preorder, Arrays.copyOfRange(inorder, idx + 1, inorder.length));
            /// Note(very IMP): Arrays.copyOfRange takes worst of O(N).
            // So to optimize to O(1), we can keep the same inorder array and pass range pointers like:
            // inL = left boundary
            // inR = right boundary
            // instead of creation new array using Arrays.copyOfRange

            return root;
        }
        return null;
    }

    private int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // shouldn't happen with valid input
    }
}
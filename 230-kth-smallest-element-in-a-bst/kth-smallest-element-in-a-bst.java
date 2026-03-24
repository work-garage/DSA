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

    // Approach: The smallest to largest sequence follows a Inorder traversal

    public int kthSmallest(TreeNode root, int k) {

        int[] a = new int[1];
        a[0]=0;

        return helper(root,a,k);

        // if(lt.size()<=0) return lt.get(lt.size()-1);
        // else return root.val;
    }

    int helper(TreeNode node, int[] a, int k){
        if(node==null || a[0]==k) return -1;

        int n = helper(node.left,a,k);
        if(a[0]==k) return n;

        a[0]=a[0]+1;
        if(a[0]==k) return node.val;

        int m = helper(node.right,a,k);
        if(a[0]==k) return m;

        return -1;      // only bcz: eooro: error: missing return statement
    }
}





// class Solution {

//     // Approach: The smallest to largest sequence follows a Inorder traversal

//     public int kthSmallest(TreeNode root, int k) {

//         List<Integer> lt = new ArrayList<>();

//         helper(root,lt,k);

//         return lt.get(lt.size()-1);

//         // if(lt.size()<=0) return lt.get(lt.size()-1);
//         // else return root.val;
//     }

//     void helper(TreeNode node, List<Integer> lt, int k){
//         if(node==null || lt.size()==k) return;

//         helper(node.left,lt,k);
//         if(lt.size()==k) return;

//         lt.add(node.val);
//         if(lt.size()==k) return;

//         helper(node.right,lt,k);
//         if(lt.size()==k) return;
//     }
// }

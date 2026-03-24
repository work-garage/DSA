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
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> lt = new ArrayList<>();

        helper(root,lt,k);

        return lt.get(lt.size()-1);

        // if(lt.size()<=0) return lt.get(lt.size()-1);
        // else return root.val;
    }

    void helper(TreeNode node, List<Integer> lt, int k){
        if(node==null || lt.size()==k) return;

        helper(node.left,lt,k);
        if(lt.size()==k) return;

        lt.add(node.val);
        if(lt.size()==k) return;

        helper(node.right,lt,k);
        if(lt.size()==k) return;
    }
}

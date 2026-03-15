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
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        
        helper(0, 0, root, "", ans);
        
        return ans;
    }

    void helper(int l, int r, TreeNode curr, String al, List<String> ans){
        
        if(curr==null) return;
        
        int n = al.length();
        if(n!=0) al = al + "->";
        Integer s = curr.val;
        al = al + s.toString();
        
        if(curr.left==null && curr.right==null){
            ans.add( al ); // IMP, Do not do: ans.add( al ); This does NOT copy the list.
                                            // Instead, it stores a reference to the same list object
            al = al.substring(0,n);
            return;
        }
        
        helper(l+1, r-1, curr.left, al, ans);
        
        helper(l+1, r+1, curr.right, al, ans);
        
        al = al.substring(0,n);
        
    }
}

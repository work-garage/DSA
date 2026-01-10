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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lt = new ArrayList<>();

        if(root==null) return lt;

        Queue<TreeNode> q = new ArrayDeque<>();
        Stack<TreeNode> st = new Stack<>();
        int x = 0;

        q.add(root);
        while(!q.isEmpty()){
            
            List<Integer> temp = new ArrayList<>();

            while(!q.isEmpty()){
                TreeNode e = q.remove();
                temp.add(e.val);
                
                if(x%2==0){
                    if(e.left!=null) st.push(e.left);
                    if(e.right!=null) st.push(e.right);
                }
                else{
                    if(e.right!=null) st.push(e.right);
                    if(e.left!=null) st.push(e.left);
                }
            }

            lt.add(new ArrayList<>(temp));
            x++;

            while(!st.isEmpty()){
                q.add(st.pop());
            }
            
        }
        return lt;
    }
}
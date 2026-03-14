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

// Approach 2: use Queue(bfs), so that only less level nodes occur first and
// their never existand column get saved for top view.


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        if (root == null) return new ArrayList<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();   // simple BFS queue for nodes
        Queue<Integer> row = new ArrayDeque<>(); // parallel queue for row of q Nodes
        
        q.add(root);
        row.add(0);
        
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            int l = row.remove();
            
            // keep your simple rule: add Last-seen element for a column
            tm.put(l, node.val);
            
            if (node.left != null) {
                q.add(node.left);
                row.add(l + 1);
            }
            if (node.right != null) {
                q.add(node.right);
                row.add(l + 1);
            }
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        for (int n : tm.values()) al.add(n);
        return al;
    }
}



    // Approach 1


    // Doing DFS(recursion) and saving in TreeMap<Integer, TreeMap<Integer,Integer>> tm
    // based on: first, column wise then row wise.
    // If same column elem found with less row, replace it with less row element -> thats top elem

    // public List<Integer> rightSideView(TreeNode root){
        
    //     TreeMap<Integer, TreeMap<Integer,Integer>> tm = new TreeMap<>();
        
    //     helper(0, 0, root, tm);
        
    //     ArrayList<Integer> al = new ArrayList<>();
        
    //     for(TreeMap<Integer,Integer> l: tm.values() ){
            
    //         al.add( l.get(l.firstKey()) );
    //     }
        
    //     return al;
    // }
    
    // void helper(int l, int r, TreeNode curr, TreeMap<Integer, TreeMap<Integer,Integer>> tm){
        
    //     if(curr==null) return;
        
    //     if(!tm.containsKey(r)){
            
    //         TreeMap<Integer,Integer> v = new TreeMap<>();
    //         v.put(l, curr.val);
    //         tm.put(r,v);
    //     }
    //     else{
    //         TreeMap<Integer,Integer> t = tm.get(r);
    //         if( l < t.firstKey() ){ // firstKey() returns the only existing row(l) of column(r)
    //                                 // This is very IMP and useful as we need not to find existing l for r in TreeMap 
                
    //             TreeMap<Integer,Integer> v = new TreeMap<>();
    //             v.put(l, curr.val);
    //             tm.put(r,v);
    //         }
            
    //     }
        
    //     helper(l+1, r-1, curr.left, tm);
        
    //     helper(l+1, r+1, curr.right, tm);
    // }
    
    
    
    
    // Instead of 2 Queue, we can make Pair class also in approach 2
    
    //Queue<Pair> q = new ArrayDeque<>();
    
    // class Pair {
    // Node node;
    // int col;

    // Pair(Node node, int col) {
    //     this.node = node;
    //     this.col = col;
    // }

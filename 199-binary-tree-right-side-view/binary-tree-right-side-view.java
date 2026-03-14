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





// Approach 4: DFS optimised
// Complexity: O(n) time, O(h) extra space for recursion (h = tree height).
// my DFS Approach 1 has problem that: TreeMap makes time complexity as O(N*LogN)

// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         dfs(root, 0, res);
//         return res;
//     }

//     private void dfs(TreeNode node, int depth, List<Integer> res) {
//         if (node == null) return;
//         // if first time visiting this depth, this node is the rightmost
//         if (depth == res.size()) {
//             res.add(node.val);
//         }
//         // visit right first so the first node at a depth is the rightmost
//         dfs(node.right, depth + 1, res);
//         dfs(node.left, depth + 1, res);
//     }
// }







// Approach 3: BFS optimised (external soln: more clean and optimised)
// my BFS Approach 2 has problem that: TreeMap makes time complexity as O(NLogN)

// Approach	                        Time Complexity   	                Space Complexity
// Level BFS(Approach 3)                O(n)	                        O(w + h) → O(n)
// BFS + TreeMap (Approach 2)	    O(n log h) (worst O(n log n))	    O(w + h) → O(n)

// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> list=new LinkedList<>();
//        if(root==null) return list;
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//         int size=q.size();
//              for(int i=0;i<size;i++){
//             TreeNode node=q.poll();
//             if(node.left!=null) q.add(node.left);
//             if(node.right!=null) q.add(node.right);
//         if(i==size-1){
//             list.add(node.val);
//            }
//         }
        
//        }
//        return list;
//     }
// }







// Approach 2: use Queue(bfs), so that only less level nodes occur first and
// their never existand column get saved for top view.


// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
        
//         TreeMap<Integer, Integer> tm = new TreeMap<>();
//         if (root == null) return new ArrayList<>();
        
//         Queue<TreeNode> q = new ArrayDeque<>();   // simple BFS queue for nodes
//         Queue<Integer> row = new ArrayDeque<>(); // parallel queue for row of q Nodes
        
//         q.add(root);
//         row.add(0);
        
//         while (!q.isEmpty()) {
//             TreeNode node = q.remove();
//             int l = row.remove();
            
//             // keep your simple rule: add Last-seen element for a column
//             tm.put(l, node.val);
            
//             if (node.left != null) {
//                 q.add(node.left);
//                 row.add(l + 1);
//             }
//             if (node.right != null) {
//                 q.add(node.right);
//                 row.add(l + 1);
//             }
//         }
        
//         ArrayList<Integer> al = new ArrayList<>();
//         for (int n : tm.values()) al.add(n);
//         return al;
//     }
// }








// Approach 1: my DFS + TreeMap


// Doing DFS(recursion) and saving in TreeMap<Integer, TreeMap<Integer,Integer>> tm
// based on: first, column wise then row wise.
// If same column elem found with less row, replace it with less row element -> thats top elem

class Solution {
    public List<Integer> rightSideView(TreeNode root){
        
        TreeMap<Integer, TreeMap<Integer,Integer>> tm = new TreeMap<>();
        
        helper(0, 0, root, tm);
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(TreeMap<Integer,Integer> l: tm.values() ){
            
            al.add( l.get(l.firstKey()) );
        }
        
        return al;
    }
    
    void helper(int l, int r, TreeNode curr, TreeMap<Integer, TreeMap<Integer,Integer>> tm){
        
        if(curr==null) return;
        
        // if(!tm.containsKey(l)){
            
        //     TreeMap<Integer,Integer> v = new TreeMap<>();
        //     v.put(r, curr.val);
        //     tm.put(l,v);
        // }
        // else{
        //     TreeMap<Integer,Integer> t = tm.get(l);
        //     if( r >= t.firstKey() ){ // firstKey() returns the only existing row(l) of column(r)
        //                             // This is very IMP and useful as we need not to find existing l for r in TreeMap 
                
        //         TreeMap<Integer,Integer> v = new TreeMap<>();
        //         v.put(r, curr.val);
        //         tm.put(l,v);
        //     }
        // }

        TreeMap<Integer,Integer> v = new TreeMap<>();
        v.put(r, curr.val);
        tm.put(l,v);
        
        helper(l+1, r-1, curr.left, tm);
        
        helper(l+1, r+1, curr.right, tm);
    }
}





    






// Instead of 2 Queue, we can make Pair class also in approach 2

//Queue<Pair> q = new ArrayDeque<>();

// class Pair {
// Node node;
// int col;

// Pair(Node node, int col) {
//     this.node = node;
//     this.col = col;
// }

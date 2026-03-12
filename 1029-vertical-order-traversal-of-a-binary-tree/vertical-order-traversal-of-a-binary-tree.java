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

    // My Approach: collect elem using Recursion(DFS)
    // and save them using keys in TreeMap: Adding keys to TreeMap (which sorts all according to keys)
    // In: TreeMap<Integer,TreeMap<Integer,List<Integer>>>
    // First TreeMap key is: r(column)
    // Second TreeMap key is: l(row)
    // Integer key stores all nodes value having same column,row. In last, we will sort these based on value.

    // But just not sorting 5,6: [[4],[2],[1,6,5],[3],[7]]

    // My Approach: collect elem using Recursion(DFS)
    // and save them using keys in TreeMap: Adding keys to TreeMap (which sorts all according to keys)
    // In: TreeMap<Integer,TreeMap<Integer,List<Integer>>>
    // First TreeMap key is: r(column)
    // Second TreeMap key is: l(row)
    // Integer key stores all nodes value having same column,row. In last, we will sort these based on value.

    // If you only save accoding to r(column), then it will not sort values correctly having same (l,r)
    //            eg 5,6 in: [[4],[2],[1,6,5],[3],[7]] in tree: [1,2,3,4,6,5,7]

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> tmAns = new TreeMap<>();
        // collect into tmAns: column -> (row -> list of values)
        helper(root, 0, 0, tmAns);

        List<List<Integer>> ls = new ArrayList<>();
        // build result from tmAns
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> colEntry : tmAns.entrySet()) {
            List<Integer> colList = new ArrayList<>();
            TreeMap<Integer, List<Integer>> rows = colEntry.getValue();

            for (Map.Entry<Integer, List<Integer>> rowEntry : rows.entrySet()) {
                List<Integer> vals = rowEntry.getValue();
                // sort values that share same (column,row)
                Collections.sort(vals);
                colList.addAll(vals);
            }

            ls.add(colList);
        }
        return ls;
    }

    void helper(TreeNode root, int l, int r, TreeMap<Integer, TreeMap<Integer, List<Integer>>> hm){
        if(root==null) return;

        // ensure column map exists
        if (!hm.containsKey(r)) {
            hm.put(r, new TreeMap<Integer, List<Integer>>());
        }
        TreeMap<Integer, List<Integer>> rows = hm.get(r);

        // ensure row list exists
        if (!rows.containsKey(l)) {
            rows.put(l, new ArrayList<Integer>());
        }
        rows.get(l).add(root.val);

        helper(root.left, l+1, r-1, hm);
        helper(root.right, l+1, r+1, hm);
    }
}

// /*
// Instead of TreeMap(keeps keys sorted), we can also use HashMap with below code:
// Appoach: Sort the keys array and iterate with sorted keys
// Integer[] keys = hash.keySet().toArray(new Integer[0]);
// Arrays.sort(keys);
// for (Integer k : keys) {
//     System.out.println(k + " -> " + hash.get(k));
// }

// Which approach is more Efficient?

// both approaches are O(n log n) for building a sorted view once, but which is more efficient in practice depends on what you need:

// One single sorted iteration (one-off): HashMap + sort keys is usually faster and uses fewer CPU operations overall.

// Many sorted iterations, frequent inserts, or range queries: TreeMap is better because it keeps keys ordered incrementally and lets you iterate in O(n) every time without re-sorting.

// Memory tradeoffs: HashMap + keys[] temporarily needs an extra O(n) array; TreeMap permanently stores tree nodes (more per-entry overhead).

// */






//VS







// Approach: Collect all nodes first using DFS, then Sort by col, then row, then value using (nodes.sort OR Collections.sort OR PriorityQueue)


// import java.util.*;

// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<int[]> nodes = new ArrayList<>();
        
//         // Step 1: DFS to collect all (col, row, val)
//         dfs(root, 0, 0, nodes);

//         // Step 2: Sort by col, then row, then value:  for: List<int[]>
//         nodes.sort((a, b) -> {
//             if (a[0] != b[0]) return Integer.compare(a[0], b[0]);     // col
//             if (a[1] != b[1]) return Integer.compare(a[1], b[1]);     // row
//             return Integer.compare(a[2], b[2]);                       // value
//         });

//         /*   We can also use this 2nd way of sorting
//         // sort by col, then row, then value
//         Collections.sort(nodes, (a, b) -> {
//             if (a[0] != b[0]) return Integer.compare(a[0], b[0]);    // col
//             if (a[1] != b[1]) return Integer.compare(a[1], b[1]);    // row
//             return Integer.compare(a[2], b[2]);                      // value
//         });
//         */
        
//         /*  We can also use this 3rd way of sorting with priority Queue
//             Min-heap: col -> row -> value
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a, b) -> {
//                 if (a[0] != b[0]) return a[0] - b[0]; // column
//                 if (a[1] != b[1]) return a[1] - b[1]; // row
//                 return a[2] - b[2];                   // value
//             }
//         );
//         pq is a global min-heap that will store every node as an int[3] = {col, row, val}.

//         Comparator orders first by column (ascending), then row (ascending), then node value (ascending).
//         This enforces the exact required total order when we poll.
//         */


//         List<List<Integer>> result = new ArrayList<>();
//         int prevCol = Integer.MIN_VALUE;

//         // Step 3: Group by column
//         for (int[] node : nodes) {
//             int col = node[0], val = node[2];
//             if (col != prevCol) {
//                 result.add(new ArrayList<>());
//                 prevCol = col;
//             }
//             result.get(result.size() - 1).add(val);                 //IMP: result.get(result.size() - 1)
//         }

//         return result;
//     }

//     // DFS helper to collect column, row, and value
//     private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
//         if (node == null) return;
//         nodes.add(new int[]{col, row, node.val});
//         dfs(node.left, row + 1, col - 1, nodes);   // Left child
//         dfs(node.right, row + 1, col + 1, nodes);  // Right child
//     }
// }
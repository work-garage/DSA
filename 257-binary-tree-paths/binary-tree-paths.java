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



// This is more Clean code and used StringBuilder, which is good (Ignore fact, it has used global variable(we can chage it))
// DFS(recursion)
// time: O(N)  space: O(h)

class Solution {
    List<String> li=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return li;
    }
    public void dfs(TreeNode root){
        int len = sb.length();
        if(root.left==null && root.right==null){
            sb.append(root.val);
            li.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append(root.val+"->");
        if(root.left!=null){
            dfs(root.left);
        }
        if(root.right!=null){
            dfs(root.right);
        }
        sb.setLength(len);
        }
}




// This is my Solution
// DFS(recursion)

// class Solution {
//     public List<String> binaryTreePaths(TreeNode root) {

//         List<String> ans = new ArrayList<>();
        
//         helper(root, "", ans);    // you don't need to pass l,r in dfs until needed: helper(0,0,root, "", ans); 
        
//         return ans;
//     }

//     void helper(TreeNode curr, String al, List<String> ans){
        
//         if(curr==null) return;
        
//         int n = al.length();
//         if(n!=0) al = al + "->";
//         Integer s = curr.val;
//         al = al + s.toString();
        
//         if(curr.left==null && curr.right==null){
//             ans.add( al ); // IMP, Do not do: ans.add( al ); This does NOT copy the list.
//                                             // Instead, it stores a reference to the same list object
//             al = al.substring(0,n);
//             return;
//         }
        
//         helper(curr.left, al, ans);
        
//         helper(curr.right, al, ans);
        
//         al = al.substring(0,n);
        
//     }
// }





// TIME and Space Complexity(GPT)




// 1) StringBuilder + backtracking approach (your first snippet)
// Time complexity

// You visit each node exactly once → baseline O(n) visits.

// At each non-leaf you do constant-time append/setLength operations on the StringBuilder (amortized O(1) for each append/setLength).

// At each leaf you call sb.toString() which copies the whole current path into a new String. Copying a path of length O(h) costs O(h).

// So total time = O(n) (visits + append/restore) plus the cost of copying each leaf’s path: O(sum of path-lengths-for-all-leaves).
// Compactly: Time = O(n + sum_over_leaves(depth_of_leaf)).

// In big-O worst case we can upper-bound this by O(n · h).

// If tree is skewed, h = n, worst-case time O(n^2).

// If tree is balanced, h = O(log n), time O(n log n).

// Space complexity (auxiliary, excluding output)

// Recursion stack depth O(h).

// One StringBuilder of size O(h) (holds current path).

// Temporary sb.toString() for a leaf produces a copy of size O(h) but that becomes part of the output list (counted in output size). The extra transient memory for copying is O(h).

// So auxiliary space = O(h).

// Space complexity (including output)

// You must store the result list containing all path-strings. That cost is L_total (sum of lengths of all path strings). So total space = O(h + L_total). In worst case L_total can be large (see below).

// 2) Immutable-String concatenation approach (your commented helper)
// Time complexity

// Each recursive step does al = al + ... which in Java creates a new String by copying the characters of al and the new addition.

// For a single root→leaf path of length L, the cost to build all intermediate strings along that path is 1 + 2 + ... + L = O(L^2) (because each step copies an increasingly long string).

// Summing across all leaves gives a larger overhead than the StringBuilder variant. A safe, simple worst-case bound is O(n · h) for reasonable analyses, but practically this allocation/copy behavior often results in worse constants and often an O(n²) worst-case time (skewed tree) and in many balanced cases will be O(n log n) up to a hidden factor because of repeated copying.

// To be conservative and practical: Worst-case Time = O(n²) (skewed tree) and typically worse than the StringBuilder approach by a factor related to the average path length because of repeated string copying.

// (Short takeaway: the immutable-string approach does much more copying during recursion than the StringBuilder approach, so it is slower — often asymptotically in the same ballpark for simple bounds, but with worse constants and often worse practical behavior. Use StringBuilder for backtracking.)

// Space complexity (auxiliary, excluding output)

// Because every recursive call keeps its own al string reference until the recursive call returns, the stack holds strings of lengths 0, 1, 2, ..., h (roughly). The sum of these lengths is O(h^2) in the worst case (a single deep path). So the simultaneous memory used by the stack for those strings can be O(h^2) worst-case.

// Plus recursion stack frames themselves O(h).

// Space complexity (including output)

// Again you must store L_total for the final result. So total memory usage could be O(h^2 + L_total) worst-case.

// Compact comparison table
// Aspect	StringBuilder (backtracking)	Immutable string concat
// Time (worst)	O(n·h) → worst O(n^2) (skewed), typical balanced O(n log n)	O(n^2) worst; typically worse than StringBuilder because each recursion copies strings repeatedly
// Auxiliary space (stack + temp)	O(h)	O(h^2) worst-case (due to many strings on stack)
// Total space including output	O(h + L_total)	O(h^2 + L_total)
// Practical recommendation	✅ Better: lower copying, good for large trees	❌ Avoid for deep/large trees — causes many allocations and slows program
// Concrete examples to make it obvious

// Skewed tree (chain) of n nodes:

// h = n.

// StringBuilder: time ≈ O(n^2) (because each leaf copying can be up to length n — though there is only one leaf, so still O(n) for copies; but constructing intermediate results across recursion can accumulate in other trees — overall safe worst-case O(n^2)). Aux space O(n).

// String concat: time O(n^2) or worse due to triangular copying along the chain; aux space O(n^2) (many strings of increasing lengths on the stack).

// Balanced tree (~complete):

// h = O(log n).

// StringBuilder: time O(n log n), aux O(log n).

// String concat: also roughly O(n log n) in big-O sense but with much higher constants and allocation overhead; aux up to O((log n)^2).
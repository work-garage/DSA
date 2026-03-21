/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */




// Approach: 
// serialize to eg. "1 2 3 n n 4 5 n n n n "
// deserialize: I assign left and right child for each not-null node, and add the not-null children to the queue, waiting to be handled later.

public class Codec {
    // eg. "1 2 3 n n 4 5 n n n n "
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }


    // bfs(queue) to deserialize also: create root elem, then assign its left,right and put new elems in queue
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}






// My Approach(have to fix)

// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {

//         //compute maxHeight of BT

//         StringBuilder s = new StringBuilder();

//         Queue<TreeNode> q = new ArrayDeque<>();

//         q.add(root);
        
//         while(!q.isEmpty()){

//             TreeNode t = q.remove();

//             if(t.left==null && currHeight<maxHeight+1){
//                 q.add(null);
//             }
//             else q.add(t.left);

//             if(t.right==null && currHeight<maxHeight+1){
//                 q.add(null);
//             }
//             else q.add(t.right);

//             if(t==null) s.append("N");
//             else s.append( ""+t.val );
//         }

//         return s.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String s) {
//         // "1 2 3 N N 4 5 N N N N"

//         TreeNode root = new TreeNode();

//         helper(0,root,s);

//         return root;
//     }

//     void helper(int i, TreeNode node, String s){

//         if(i<0 || i>=s.length()) return;

//         if(s.charAt(i)=='N'){
//             node=null;
//             return;
//         }

//         node.val = s.charAt(i);

//         node.left = new TreeNode();
//         node.right = new TreeNode();

//         helper(2*i+1, node.left, s);
//         helper(2*i+2, node.right, s);

//         // node.left = helper(2*i+1, node, s);
//         // node.right = helper(2*i+2, node, s);
//     }
// }




// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    static int dfs(TreeNode node, int maxSoFar){
        if(node == null) return 0;
        int c = 0;
        if(node.val >= maxSoFar){
            c = 1;
            maxSoFar = node.val;
        }
        c += dfs(node.left, maxSoFar);
        c += dfs(node.right, maxSoFar);
        return c;
    }
}

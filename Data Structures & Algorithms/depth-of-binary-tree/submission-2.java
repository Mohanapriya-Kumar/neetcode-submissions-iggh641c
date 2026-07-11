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
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    private int depth(TreeNode node){
        if(node == null) return 0;
        int leftMax = depth(node.left);
        int rightMax = depth(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}

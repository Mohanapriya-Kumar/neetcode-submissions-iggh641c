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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return d;
    }
    private int depth(TreeNode node){
        if(node == null) return 0;
        int leftMax = depth(node.left);
        int rightMax = depth(node.right);
        d = Math.max(d, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}

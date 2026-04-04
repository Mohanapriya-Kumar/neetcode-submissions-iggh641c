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
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return d;
        
    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        int leftMax = depth(root.left);
        int rightMax = depth(root.right);
        d = Math.max(d, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}

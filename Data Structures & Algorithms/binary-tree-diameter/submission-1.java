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
        int maxL = depth(root.left);
        int maxR = depth(root.right);
        d = Math.max(d, maxL+maxR);
        return Math.max(maxL, maxR) + 1;
    }
}

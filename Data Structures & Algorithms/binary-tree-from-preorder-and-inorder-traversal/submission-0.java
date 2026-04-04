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
    private int preidx = 0, inidx = 0; //should be 0 only in the start not for each recursion
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }
    private TreeNode dfs(int[] preorder, int[] inorder,int lim) {
        
        if(preidx >= preorder.length){
            return null;
        } 
        if(inorder[inidx] == lim){ //as soon as lim reached no need to wait till >
            inidx++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[preidx++]);
        node.left = dfs(preorder, inorder, node.val);
        node.right = dfs(preorder, inorder, lim);
        return node;
    }
}

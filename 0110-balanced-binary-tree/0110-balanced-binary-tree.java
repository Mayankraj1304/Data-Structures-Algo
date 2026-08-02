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
    public boolean isBalanced(TreeNode root) {
        return find(root) != -1;
    }

    private int find(TreeNode node) {
        if (node == null) return 0; // Fix 1: Null nodes have height 0

        int lh = find(node.left);
        if (lh == -1) return -1; // Fix 2: Early return if left is unbalanced

        int rh = find(node.right);
        if (rh == -1) return -1; // Fix 2: Early return if right is unbalanced

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }
}
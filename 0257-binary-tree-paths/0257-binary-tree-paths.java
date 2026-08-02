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
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            findPaths(root, "", result);
        }
        return result;
    }

    private void findPaths(TreeNode node, String path, List<String> result) {
        // Append current node's value to the path
        path += node.val;

        // Base case: If it's a leaf node, add the complete path to results
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Recursive step: Traverse left and right subtrees with "->" added
        if (node.left != null) {
            findPaths(node.left, path + "->", result);
        }
        if (node.right != null) {
            findPaths(node.right, path + "->", result);
        }
    }
}

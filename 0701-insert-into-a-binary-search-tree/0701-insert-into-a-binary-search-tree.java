class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Base case: create and return the new node when hitting an empty slot
        if (root == null) {
            return new TreeNode(val);
        }

        // Traverse left and re-link the left subtree
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        // Traverse right and re-link the right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the modified root node back up the call stack
        return root;
    }
}

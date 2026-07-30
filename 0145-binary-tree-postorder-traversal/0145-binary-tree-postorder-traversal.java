import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);   // 1. Traverse Left
        helper(root.right, result);  // 2. Traverse Right
        result.add(root.val);        // 3. Visit Root (Last)
    }
}
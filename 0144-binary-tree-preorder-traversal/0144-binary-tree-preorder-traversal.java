import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);             // 1. Visit Root
        helper(root.left, result);        // 2. Traverse Left
        helper(root.right, result);       // 3. Traverse Right
    }
}
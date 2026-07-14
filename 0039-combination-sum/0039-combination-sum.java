import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(candidates, target, 0, 0, path, result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int target,
        int start,
        int sum,
        List<Integer> path,
        List<List<Integer>> result
    ) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);

            backtrack(candidates, target, i, sum + candidates[i], path, result);

            path.remove(path.size() - 1);
        }
    }
}
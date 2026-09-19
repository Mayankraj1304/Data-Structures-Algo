import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 1. Skip elements that are already part of the current permutation path
            if (used[i]) {
                continue;
            }
            // 2. Skip duplicate elements to avoid generating duplicate permutations
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, answer);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
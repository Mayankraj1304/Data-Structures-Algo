import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(0, nums, path, answer);
        return answer;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtrack(i + 1, nums, path, answer);
            path.remove(path.size() - 1);
        }
    }
}

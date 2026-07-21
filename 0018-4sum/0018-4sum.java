import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // 1. Sort the array to easily manage duplicates and two-pointer traversal
        Arrays.sort(nums);
        int n = nums.length;

        // First loop for the first element
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Pruning / Optimization:
            // Minimal possible sum with nums[i] is larger than target -> no valid quadruplets
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // Maximal possible sum with nums[i] is smaller than target -> nums[i] is too small
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            // Second loop for the second element
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Pruning / Optimization:
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                // Two-pointer search for the remaining two elements
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to prevent integer overflow during summation
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move pointers and skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base Case: If we have considered all elements, add the current subset to the result
        if (index == nums.length) {
            result.add(new ArrayList<>(current)); // Make a deep copy of the current subset
            return;
        }

        // Decision 1: Include the current element nums[index]
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        // Decision 2: Exclude the current element nums[index] (Backtrack)
        current.remove(current.size() - 1);
        generateSubsets(index + 1, nums, current, result);
    }
}
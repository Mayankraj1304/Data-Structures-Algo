class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Place each number in its correct position if possible
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            // Check if nums[i] is within the range [1, n] and not already in its correct spot
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                // Swap nums[i] and nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        
        // Step 2: Find the first index where the value doesn't match index + 1
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        
        // Step 3: If all 1 to n are present, the answer is n + 1
        return n + 1;
    }
}
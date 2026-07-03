class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element to handle arrays 
        // containing only negative numbers.
        int current_sum = nums[0];
        int max_sum = nums[0];
        
        // Start from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add the current element to the existing 
            // subarray or start a new subarray from the current element.
            current_sum = Math.max(nums[i], current_sum + nums[i]);
            
            // Update the global maximum
            max_sum = Math.max(max_sum, current_sum);
        }
        
        return max_sum;
    }
}
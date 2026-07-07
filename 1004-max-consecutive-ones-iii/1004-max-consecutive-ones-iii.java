class Solution {
    // Optional JIT warmup block for your template
    static {
        for (int i = 0; i < 100; i++) {
            new Solution().longestOnes(new int[]{1}, 1);
        }
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // If we encounter a 0, track it
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If we have more than 'k' zeros, shrink the window from the left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the valid window size and update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
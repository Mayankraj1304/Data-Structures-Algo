 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
                // Track the highest consecutive sequence seen so far
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                // We hit a 0, so reset the current consecutive streak
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        // Change 1: Use long to handle cases where Integer.MIN_VALUE is in the array
        long large = Long.MIN_VALUE, sec_large = Long.MIN_VALUE, third = Long.MIN_VALUE;
        int count = 0; // Tracks how many distinct maximums we successfully record

        if (nums.length < 2) {
            return nums[0];
        }

        // Removed the strict nums.length > 2 check because an array of length 2 
        // still needs to run through to find the absolute maximum.
        for (int i = 0; i < nums.length; i++) {
            // Change 2: Skip duplicates entirely so they don't shift down
            if (nums[i] == large || nums[i] == sec_large || nums[i] == third) {
                continue;
            }

            if (nums[i] > large) {
                third = sec_large;
                sec_large = large;
                large = nums[i];
                count++;
            } else if (nums[i] > sec_large && nums[i] < large) {
                third = sec_large;
                sec_large = nums[i];
                count++;
            } else if (nums[i] > third && nums[i] < sec_large) { // Change 3: Protect against duplicate shifting here
                third = nums[i];
                count++;
            }
        }
        
        // Change 4: If we didn't collect at least 3 distinct values, return the absolute max
        if (count < 3) {
            return (int) large;
        }
        
        return (int) third;
    }
}
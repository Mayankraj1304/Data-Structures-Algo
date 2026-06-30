class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        // k represents the index of the last placed unique element
        int k = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Look for the next element that is strictly greater than our current unique element
                if (nums[j] > nums[k]) {
                    k++;             // Move to the next slot
                    nums[k] = nums[j]; // Place the unique element there
                    i = j - 1;       // Jump 'i' forward to skip the duplicates we just bypassed
                    break;
                }
            }
        }
        
        // Total unique elements is index k + 1
        return k + 1;
    }
}
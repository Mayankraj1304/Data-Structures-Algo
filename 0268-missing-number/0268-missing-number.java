class Solution {
    public int missingNumber(int[] nums) {
        int freq[] = new int[nums.length + 1];
        
        // Count the frequencies
        for (int num : nums) {
            freq[num]++;
        }
        
        // Corrected Loop: Iterate through indices, not values
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                return i; // Found the missing index!
            }
        }
        
        return -1; // Fallback
    }
}
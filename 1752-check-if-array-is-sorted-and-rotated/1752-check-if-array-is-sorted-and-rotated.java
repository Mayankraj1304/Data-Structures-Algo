class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Use modulo (%) to easily check the wrap-around (last element vs first element)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            
            // If we find more than one drop, it's impossible for it to be sorted and rotated
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[nums.length + 1];
        
        // Count frequencies of each number
        for (int num : nums) {
            freq[num]++;
        }
        
        // Check from 1 to n (skip index 0)
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                result.add(i); // Add the index 'i' itself, not nums[i]
            }
        }
        
        return result;
    }
}
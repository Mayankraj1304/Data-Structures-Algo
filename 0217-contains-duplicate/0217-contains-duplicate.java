import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a set to keep track of numbers we've already walked past
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // .add() tries to add the item. 
            // If it's already there, it returns false.
            if (!seen.add(num)) {
                return true; // Stop immediately! We found a duplicate.
            }
        }
        
        return false; // Walked through the whole array with no duplicates
    }
}
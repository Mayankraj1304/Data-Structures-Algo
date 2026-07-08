class Solution {

    public static void sortColors(int[] nums) {
        // Step 1: Count frequencies using a Map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Overwrite the original array
        int index = 0;
        
        // Explicitly check for 0, 1, and 2 to maintain the correct order
        for (int color = 0; color <= 2; color++) {
            int count = frequencyMap.getOrDefault(color, 0);
            while (count > 0) {
                nums[index++] = color;
                count--;
            }
        }
    }
}

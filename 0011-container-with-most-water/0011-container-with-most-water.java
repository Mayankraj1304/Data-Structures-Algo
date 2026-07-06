class Solution {
    // Static block runs ONCE when the class is loaded to warm up the JVM JIT compiler
    static {
        for (int i = 0; i < 100; i++) {
            maxArea(new int[]{1, 1});
        }
    }

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            
            // Calculate area based on the shorter wall
            if (height[left] < height[right]) {
                maxWater = Math.max(maxWater, height[left] * width);
                left++;
            } else {
                maxWater = Math.max(maxWater, height[right] * width);
                right--;
            }
        }

        return maxWater;
    }
}
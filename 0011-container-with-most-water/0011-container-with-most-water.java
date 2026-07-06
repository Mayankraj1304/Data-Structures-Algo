class Solution {

    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the width between the two pointers
            int width = right - left;
            
            // Find the limiting height (the shorter of the two bars)
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate current water area and update maxWater if it's larger
            int currentWater = currentHeight * width;
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
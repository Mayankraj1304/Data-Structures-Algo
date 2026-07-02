import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // 1. Declare result array OUTSIDE if blocks so it's visible at return
        // Max possible size is the length of the smaller array
        int[] tempArr = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0; // Index for tempArr
        
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        
        // 2. Use a single while loop with two pointers
        while (i < nums1.length && j < nums2.length) {
            // Skip duplicates in nums1 to ensure unique results
            if (i > 0 && nums1[i] == nums1[i-1]) {
                i++;
                continue;
            }
            
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // Match found
                tempArr[idx] = nums1[i];
                idx++;
                i++;
                j++;
            }
        }
        
        // 3. Return only the filled portion of the array
        return Arrays.copyOf(tempArr, idx);
    }
}   
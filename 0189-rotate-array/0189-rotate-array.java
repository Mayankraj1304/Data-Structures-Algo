class Solution {
    public void rev(int left, int right, int arr[]) {
        int temp;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        // 1. Shrink k to a valid index within the array bounds
        k = k % nums.length; 
        
        // 2. Perform the 3-step reversal unconditionally
        rev(0, nums.length - 1, nums);
        rev(0, k - 1, nums);
        rev(k, nums.length - 1, nums);
    }
}
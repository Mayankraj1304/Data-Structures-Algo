class Solution {
    static {
    for (int i = 0; i < 100; i++) {
        findMaxAverage(new int[1], 1);
    }
}
    public static double findMaxAverage(int[] arr, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            if (right >= k) {
                sum -= arr[right - k];
            }
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return (double)maxSum/k;
    }

}
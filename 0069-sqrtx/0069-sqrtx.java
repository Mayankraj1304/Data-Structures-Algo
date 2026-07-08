class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // CRITICAL: Cast 'mid' to long BEFORE the multiplication happens
            long sqr = (long) mid * mid;
            long sqr1 = (long) (mid + 1) * (mid + 1);
            
            if (sqr <= x && sqr1 > x) {
                return mid;
            } else if (sqr > x) {
                right = mid - 1;
            } else {
                // Fixes the infinite loop: if mid is too small, move left up
                left = mid + 1;
            }
        }
        return 0;
    }
}
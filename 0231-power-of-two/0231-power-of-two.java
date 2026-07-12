class Solution {
    public boolean isPowerOfTwo(int n) {
        // Base case 1: Numbers less than or equal to 0 are not powers of two
        if (n <= 0) {
            return false;
        }
        // Base case 2: 2^0 is 1
        if (n == 1) {
            return true;
        }
        // If it's odd, it can't be a power of two
        if (n % 2 != 0) {
            return false;
        }
        
        // Recursive step: Divide by 2 and check again
        return isPowerOfTwo(n / 2);
    }
}
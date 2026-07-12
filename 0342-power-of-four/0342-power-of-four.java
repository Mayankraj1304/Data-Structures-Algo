class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        // Base case 2: 3^0 is 1
        if (n == 1) {
            return true;
        }
        // If it's not divisible by 3, it can't be a power of 3
        if (n % 4 != 0) {
            return false;
        }
        
        // Recursive step: divide by 3 and check again
        return isPowerOfFour(n / 4);
    }
}
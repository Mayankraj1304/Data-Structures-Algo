class Solution {
    public int divide(int dividend, int divisor) {
        // Handle 32-bit integer overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to avoid overflow when abs(MIN_VALUE) is taken
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Since both a and b are negative, 'a <= b' means |a| >= |b|
        while (a <= b) {
            int tempDivisor = b;
            int multiple = 1;

            // Double the divisor as much as possible without overflowing
            // (tempDivisor >= Integer.MIN_VALUE / 2 prevents overflow on left shift)
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            a -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
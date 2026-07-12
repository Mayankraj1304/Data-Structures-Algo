class Solution {
    public double myPow(double x, int n) {
        // Use a long to prevent integer overflow when dealing with Integer.MIN_VALUE
        long N = n; 
        
        // Handle negative exponents: x^(-n) = (1/x)^n
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        // Base case: x^0 is always 1
        if (n == 0) {
            return 1.0;
        }
        
        // Recursively compute x^(n/2)
        double half = fastPow(x, n / 2);
        
        // If n is even: x^n = x^(n/2) * x^(n/2)
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd: x^n = x^(n/2) * x^(n/2) * x
        else {
            return half * half * x;
        }
    }
}
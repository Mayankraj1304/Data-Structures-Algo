class Solution {
    public int myAtoi(String s) {
        // Edge case: empty string
        if (s == null || s.isEmpty()) return 0;
        
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip all leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If we reached the end after spaces, return 0
        if (i == n) return 0;
        
        // Step 2: Handle the sign if it exists
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++; // Move past the sign
        }
        
        // Step 3: Convert digits using a 'long' to easily catch overflow
        long result = 0;
        while (i < n) {
            char curr = s.charAt(i);
            
            // Stop the moment you see a non-digit
            if (curr < '0' || curr > '9') {
                break;
            }
            
            // Add the digit to our total
            result = result * 10 + (curr - '0');
            
            // Step 4: Check if we've busted our 32-bit integer limits
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            i++;
        }
        
        // Step 5: Return the final signed integer casted back to int
        return (int) (result * sign);
    }
}
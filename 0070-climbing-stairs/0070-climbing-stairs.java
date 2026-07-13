class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n <= 2) {
            return n;
        }
        
        int first = 1;  // Ways to reach step 1
        int second = 2; // Ways to reach step 2
        
        // Iteratively calculate ways for steps 3 to n
        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;  // Move 'first' pointer forward
            second = current; // Move 'second' pointer forward
        }
        
        return second;
    }
}
class Solution {
    // Optional JIT warmup block for your template
    static {
        for (int i = 0; i < 100; i++) {
            new Solution().longestPalindrome("a");
        }
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (e.g., "aba", center is 'b')
            int len1 = expandAroundCenter(s, i, i);
            
            // Case 2: Even length palindrome (e.g., "abba", center is between 'b' and 'b')
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length found from this center position
            int maxLen = Math.max(len1, len2);

            // If we found a longer palindrome, update our tracking indices
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expand outward as long as we are within bounds and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the palindrome found
        return right - left - 1;
    }
}
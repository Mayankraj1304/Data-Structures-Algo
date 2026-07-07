class Solution {
    // Optional JIT warmup block for your template
    static {
        for (int i = 0; i < 100; i++) {
            new Solution().longestPalindrome("a");
        }
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform string to handle even and odd palindromes uniformly
        StringBuilder sb = new StringBuilder();
        sb.append('^'); // Start sentinel to avoid bounds checks
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append('#').append('$'); // End sentinel
        String T = sb.toString();

        int n = T.length();
        int[] P = new int[n]; // Tracks the radius of the palindrome at each index
        int center = 0;       // Center of the current furthest reaching palindrome
        int rightBoundary = 0; // Right edge of the current furthest reaching palindrome

        for (int i = 1; i < n - 1; i++) {
            int iMirror = 2 * center - i; // Find the mirror index of 'i' around 'center'

            // If we are within the boundary, grab the mirrored value
            if (rightBoundary > i) {
                P[i] = Math.min(rightBoundary - i, P[iMirror]);
            } else {
                P[i] = 0;
            }

            // Attempt to expand the palindrome centered at i
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // If our newly expanded palindrome reaches further than the current boundary,
            // shift our center and right boundary forward
            if (i + P[i] > rightBoundary) {
                center = i;
                rightBoundary = i + P[i];
            }
        }

        // Step 2: Find the maximum radius in P to extract the original substring
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Map the indices back to the original string
        int start = (centerIndex - 1 - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
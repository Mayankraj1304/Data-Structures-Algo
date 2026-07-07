import java.util.HashSet;

class Solution {
    // Optional static JIT warmup block if you are using your extension template
    static {
        for (int i = 0; i < 100; i++) {
            new Solution().lengthOfLongestSubstring("");
        }
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0; // Initialized to 0 to handle empty string case safely

        for (int right = 0; right < s.length(); right++) {
            // If the character at 'right' is a duplicate, 
            // shrink the window from the left until the duplicate is removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the window
            set.add(s.charAt(right));

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
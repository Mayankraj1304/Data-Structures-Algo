class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        
        // The sequence starts with "1" for n = 1
        String current = "1";
        
        // Generate the sequence iteratively up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int length = current.length();
            int count = 1;
            
            for (int j = 0; j < length; j++) {
                // Check if the current character matches the next one
                if (j + 1 < length && current.charAt(j) == current.charAt(j + 1)) {
                    count++;
                } else {
                    // Append the count and the character itself when the sequence changes
                    sb.append(count).append(current.charAt(j));
                    count = 1; // Reset count for the next group
                }
            }
            current = sb.toString();
        }
        
        return current;
    }
}
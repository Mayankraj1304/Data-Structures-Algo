class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        # dp[i][j] will be True if s[:i] matches p[:j]
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        
        # Base case: empty string matches empty pattern
        dp[0][0] = True
        
        # Base case: patterns like a*, a*b*, a*b*c* can match an empty string
        for j in range(2, n + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]
                
        # Fill the DP table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                char_s = s[i - 1]
                char_p = p[j - 1]
                
                if char_p == '.' or char_p == char_s:
                    # Current characters match
                    dp[i][j] = dp[i - 1][j - 1]
                elif char_p == '*':
                    # Case 1: Match 0 occurrences of the preceding element
                    match_zero = dp[i][j - 2]
                    
                    # Case 2: Match 1 or more occurrences of the preceding element
                    prev_char_p = p[j - 2]
                    match_one_or_more = (prev_char_p == '.' or prev_char_p == char_s) and dp[i - 1][j]
                    
                    dp[i][j] = match_zero or match_one_or_more
                    
        return dp[m][n]
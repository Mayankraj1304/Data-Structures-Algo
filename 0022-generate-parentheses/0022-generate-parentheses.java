import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int n, int open, int close, StringBuilder sb, List<String> result) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');

            backtrack(n, open + 1, close, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');

            backtrack(n, open, close + 1, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
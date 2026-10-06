import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as a base boundary for valid substring length calculations
        stack.push(-1);
        
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // Store the index of matching opening parenthesis
                stack.push(i);
            } else {
                // Pop the last unmatched '(' index or previous boundary
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If empty, this closing parenthesis is unmatched.
                    // Set current index as the new base boundary.
                    stack.push(i);
                } else {
                    // Current valid length is current index minus top boundary index
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
}
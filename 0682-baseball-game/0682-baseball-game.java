import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scoreStack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                // Record a new score that is the sum of the last two scores
                int top = scoreStack.pop();
                int newScore = top + scoreStack.peek();
                scoreStack.push(top); // Put the first one back
                scoreStack.push(newScore); // Push the new sum
            } else if (op.equals("D")) {
                // Record a new score that is double the last score
                scoreStack.push(2 * scoreStack.peek());
            } else if (op.equals("C")) {
                // Invalidate and remove the last score
                scoreStack.pop();
            } else {
                // It's an integer string, parse it and record it
                scoreStack.push(Integer.parseInt(op));
            }
        }
        
        // Sum up all the scores left in the stack
        int totalSum = 0;
        for (int score : scoreStack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}
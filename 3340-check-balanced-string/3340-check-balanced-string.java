class Solution {
    public boolean isBalanced(String num) {
        int evenSum = 0;
        int oddSum = 0;
        
        for (int i = 0; i < num.length(); i++) {
            // Convert character digit to its integer value
            int digit = num.charAt(i) - '0'; 
            
            if (i % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }
        
        return evenSum == oddSum;
    }
}

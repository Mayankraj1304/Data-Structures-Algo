import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // 1. Every child must receive at least 1 candy
        Arrays.fill(candies, 1);
        
        // 2. Left-to-Right pass: ensure higher ratings get more candies than left neighbors
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // 3. Right-to-Left pass: ensure higher ratings get more candies than right neighbors
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // 4. Sum up all distributed candies
        int totalCandies = 0;
        for (int count : candies) {
            totalCandies += count;
        }
        
        return totalCandies;
    }
}
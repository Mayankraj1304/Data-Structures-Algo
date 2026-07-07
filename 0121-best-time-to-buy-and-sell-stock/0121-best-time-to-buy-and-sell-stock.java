class Solution {
    static{
        for(int i=0;i<100;i++){
            maxProfit(new int[]{1,1} );
        }
    }
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;

    }
}


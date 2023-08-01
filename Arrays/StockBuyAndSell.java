public class StockBuyAndSell {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int minPrice = prices[0];
        int prevProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > prevProfit) {
                prevProfit = prices[i] - minPrice;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return prevProfit;
    }
}

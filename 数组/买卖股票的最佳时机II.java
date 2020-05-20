public class 买卖股票的最佳时机II {
    class Solution {
        public int maxProfit(int[] prices) {
            int i =0;
            int valley, peak;
            int maxProfit = 0;
            while(i < prices.length - 1){
                while(i < prices.length - 1 && prices[i] >= prices[i+1])
                    i++;
                valley = prices[i];
                while(i < prices.length - 1 && prices[i] <= prices[i+1])
                    i++;
                peak = prices[i];
                maxProfit += peak - valley;
            }
            return maxProfit;
        }
    }

}

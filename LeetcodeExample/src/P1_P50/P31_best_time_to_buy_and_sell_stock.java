package P1_P50;

public class P31_best_time_to_buy_and_sell_stock {

	public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n ==0){
            return 0;
        }
        int []result = new int[n];
        int min = prices[0];
        result[0] = 0;
        for (int i=1;i<n;i++){
            if (prices[i] >= min){
                result[i] = prices[i] - min;
            }
            else {
                result[i] = 0;
                min = prices[i];
            }
        }
        int maxProfit = 0;
        for (int i=1;i<n;i++){
            if (result[i] > maxProfit){
                maxProfit = result[i];
            }
        }
        return maxProfit;
    }
}

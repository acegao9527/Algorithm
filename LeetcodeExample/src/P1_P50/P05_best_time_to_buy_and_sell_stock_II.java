package P1_P50;

public class P05_best_time_to_buy_and_sell_stock_II {

    public int maxProfit(int[] prices) {
        
        if (prices.length <=1){
            return 0;
        }
        int result=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                result+= prices[i+1]-prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

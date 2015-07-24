package P101_P150;

public class P106_best_time_to_buy_and_sell_stock_III {

	public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len ==0){
            return 0;
        }
        int[] mProL = new int [len];
        int[] mProR = new int [len];
        for (int i = 0;i<len;i++) {
            mProL[i] = mProR[i] = 0;
        }
        int minL = prices[0],maxR = prices[len-1];
        for (int i = 1;i<len;i++){
            if(prices[i] >=minL){
                mProL[i] = Math.max(prices[i]-minL,mProL[i-1]);
            }
            else {
                mProL[i] = mProL[i-1];
                minL = prices[i];
            }
            if(prices[len-1-i] <=maxR) {
                mProR[len-1-i] = Math.max(maxR-prices[len-1-i],mProR[len-i]);
            }
            else {
                mProR[len-1-i] = mProR[len-i];
                maxR = prices[len-1-i];
            }
        }
        int result = mProL[len-1];
        for (int i = 0;i<len-1;i++) {
            if (mProL[i]+mProR[i+1]>result){
                result = mProL[i]+mProR[i+1];
            }
        }
        return result;
    }
}

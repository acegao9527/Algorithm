package P1_P50;

import java.text.*;
import java.util.*;

public class P05_best_time_to_buy_and_sell_stock_II {

    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "Sep 17, 2013";
        try{
            Date date = new SimpleDateFormat("MMMM d, yy", Locale.ENGLISH).parse(str);
            System.out.println(date);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }
}

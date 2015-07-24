package P1_P50;
import java.util.ArrayList;


public class P30_grey_code {

	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n <= 0){
            result.add(0);
            return result;
        }
        ArrayList<Integer> subresult = grayCode(n-1);
        result.addAll(subresult);
        for (int i = subresult.size()-1;i>=0;i--){
            result.add(subresult.get(i)+(int)Math.pow(2,n-1));
        }
        return result;
    }
}

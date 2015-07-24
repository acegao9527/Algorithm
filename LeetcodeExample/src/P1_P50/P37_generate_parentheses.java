package P1_P50;
import java.util.ArrayList;


public class P37_generate_parentheses {

	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        String temp = "";
        generateString(result,temp,n,n);
        return result;
    }
    public void generateString(ArrayList<String> result, String pic, int left, int right){
        if (right <left){
            return;
        }
        if (left==0&&right == 0){
            result.add(pic);
            return;
        }
        if(left <0){
            return;
        }
        if(left ==0){
            generateString(result,pic+")",left,right-1);
            return;
        }
        generateString(result,pic+"(",left-1,right);
        generateString(result,pic+")",left,right-1);
    }
}

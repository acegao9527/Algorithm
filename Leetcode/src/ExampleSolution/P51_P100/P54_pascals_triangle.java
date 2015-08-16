package ExampleSolution.P51_P100;
import java.util.ArrayList;


public class P54_pascals_triangle {

	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0){
            return result;
        }
        for (int i = 0;i<numRows;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0;j<=i;j++){
                if(j==0||j==i){
                    temp.add(1);
                }
                else {
                    temp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		generate(3);
	}
}

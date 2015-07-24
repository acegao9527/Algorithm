package P51_P100;

import java.util.ArrayList;

public class P55_pascals_Triangle_II {

	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int [] temp = new int [rowIndex+1];
        temp[0]=1;
        for (int i = 1;i<=rowIndex;i++){
            temp[i]=1;
            for(int j=i-1;j>0;j--){
                temp[j] += temp[j-1];
            }
        }
        for (int i=0;i<=rowIndex;i++){
            result.add(temp[i]);
        }
        return result;
    }
}

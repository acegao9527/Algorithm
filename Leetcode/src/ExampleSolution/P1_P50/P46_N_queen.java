package ExampleSolution.P1_P50;

import java.util.ArrayList;

public class P46_N_queen {

	public ArrayList<String[]> solveNQueens(int n) {
        String[] temp = new String[n];
        for (int i = 0;i<n;i++){
            String sample = "";
            for (int j=0;j<n;j++){
                if (j==i){
                    sample+= "Q";
                }
                else {
                    sample+= ".";
                }
            }
            temp[i]=sample;
        }
        ArrayList<String[]> result = new ArrayList<String[]>();
        int position[] = new int[n];
        generateNQueens(result,temp, position,1,n);
        return result;
    }
    public void generateNQueens(ArrayList<String[]> result,String[] temp,int[] position,int insertN,int n) {
        for (int i=0;i<n;i++){
            position[insertN-1] = i;
            boolean satis = true;
            for (int j=0;j<insertN-1;j++){
                if(insertN-1-j==position[insertN-1]-position[j]||insertN-1-j==position[j]-position[insertN-1]||
                    position[insertN-1]==position[j]){
                    satis = false;
                    continue;
                }
            }
            if(satis){
                if(insertN == n){
                    String [] a = new String[n];
                    for(int k=0;k<n;k++){
                        a[k] = temp[position[k]];
                    }
                    result.add(a);
                    return;
                }
                else {
                    generateNQueens(result,temp, position,insertN+1,n);
                }
            }
        }
    }
    
}

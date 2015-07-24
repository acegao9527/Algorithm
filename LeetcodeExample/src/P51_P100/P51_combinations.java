package P51_P100;

import java.util.ArrayList;

public class P51_combinations {

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] temp = new int[k];
        generateCombine(result,temp,0,n,k,1);
        return result;
    }
    public static void generateCombine(ArrayList<ArrayList<Integer>> result,int[] temp,int index, int n,int k,int num) {
        if(index==k){
        	ArrayList<Integer> t = new ArrayList<Integer>();
        	for(int l=0;l<index;l++){
        		t.add(temp[l]);
        	}
        	result.add(t);
        	return;
        }
    	for (int i=num;i<=n;i++){
            temp[index]=i;
            generateCombine(result,temp,index+1,n,k,i+1);
        }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

    	combine(4,2);
	}
}

package ExampleSolution.P1_P50;

public class P47_N_queen_II {

	public static int result;
	public static int totalNQueens(int n) {
        int position[] = new int[n];
        generateNQueens( position,1,n);
        return result;
    }
    public static void generateNQueens(int[] position,int insertN,int n) {
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
                    result++;
                    return;
                }
                else {
                    generateNQueens( position,insertN+1,n);
                }
            }
        }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(totalNQueens(1));
	}
}

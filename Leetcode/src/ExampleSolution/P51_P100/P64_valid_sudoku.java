package ExampleSolution.P51_P100;

import java.util.HashMap;


public class P64_valid_sudoku {

	public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        if(m==0) {
            return false;
        }
        int n = board[0].length;
        if(m!=9||n!=9){
            return false;
        }
        HashMap<String,Character> checkBox = new HashMap<String,Character>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]!='.'){
                	String temp = "";
                    for (int k=0;k<m;k++){
                        if(k!=i&&board[k][j]==board[i][j]){
                            return false;
                        }
                        if(k!=j&&board[i][k]==board[i][j]){
                            return false;
                        }
                    }
                    temp += (i/3*3+j/3);
                    temp += board[i][j];
                    if(checkBox.containsKey(temp)){
                    	return false;
                    }
                    else {
                    	checkBox.put(temp, board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}

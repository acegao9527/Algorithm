package P101_P150;

public class P130_word_search {

	public boolean exist(char[][] board, String word) {
        if (word==null)
            return true;
        int m = board.length;
        if(m==0)
            return false;
        int n = board[0].length;
        boolean[][] canCheck = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                canCheck[i][j] = true;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    canCheck[i][j] = false;
                    if (word.length()<=1)
                        return true;
                    if(checkExist(board, canCheck, i, j, word.substring(1)))
                        return true;
                    canCheck[i][j] = true;
                }
            }
        return false;
    }
    public boolean checkExist(char[][] board, boolean[][] canCheck, int a, int b,String word){
        if(word == null)
            return true;
        if(a-1>=0&&canCheck[a-1][b]&&board[a-1][b]==word.charAt(0)){
            canCheck[a-1][b] = false;
            if (word.length()<=1)
                return true;
            if(checkExist(board, canCheck, a-1, b, word.substring(1)))
                return true;
            canCheck[a-1][b] = true;
        }
        if(b-1>=0&&canCheck[a][b-1]&&board[a][b-1]==word.charAt(0)){
            canCheck[a][b-1] = false;
            if (word.length()<=1)
                return true;
            if(checkExist(board, canCheck, a, b-1, word.substring(1)))
                return true;
            canCheck[a][b-1] = true;
        }
        if(a+1<board.length&&canCheck[a+1][b]&&board[a+1][b]==word.charAt(0)){
            canCheck[a+1][b] = false;
            if (word.length()<=1)
                return true;
            if(checkExist(board, canCheck, a+1, b, word.substring(1)))
                return true;
            canCheck[a+1][b] = true;
        }
        if(b+1<board[0].length&&canCheck[a][b+1]&&board[a][b+1]==word.charAt(0)){
            canCheck[a][b+1] = false;
            if (word.length()<=1)
                return true;
            if(checkExist(board, canCheck, a, b+1, word.substring(1)))
                return true;
            canCheck[a][b+1] = true; 
        }
        return false;
    }
}

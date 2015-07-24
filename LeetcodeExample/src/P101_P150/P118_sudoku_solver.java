package P101_P150;

public class P118_sudoku_solver {

	public void solveSudoku(char[][] board) {
        solveProblem(board);
    }
    public boolean isValid(char[][] board, int x, int y) {
        if (x>8||x<0||y>8||y<0)
            return false;
        for (int i=0;i<9;i++){
            if (i!=x&&board[i][y]==board[x][y])
                return false;
            if (i!=y&&board[x][i]==board[x][y])
                return false;
        }
        for (int i=3*(x/3);i<3*(x/3+1);i++){
            for (int j=3*(y/3);j<3*(y/3+1);j++) {
                if (i!=x&&j!=y&&board[i][j]==board[x][y])
                    return false;
            }
        }
        return true;
    }
    public boolean solveProblem(char[][] board){
        for (int i=0;i<9;i++)
            for (int j=0;j<9;j++){
                if (board[i][j]=='.'){
                    for (int t=1;t<=9;t++){
                        board[i][j] = (char)('0'+t);
                        if (isValid(board, i, j)&&solveProblem(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        return true;
    }
}

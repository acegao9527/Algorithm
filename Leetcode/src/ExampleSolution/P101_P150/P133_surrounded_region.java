package ExampleSolution.P101_P150;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class P133_surrounded_region {

	public void solve(char[][] board) {
        int m = board.length;
        if(m==0)
            return;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            change(board, i, 0);
            change(board, i, n-1);
        }
        for(int i = 1;i<n-1;i++){
            change(board, 0, i);
            change(board, m-1, i);
        }
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    public void change(char[][] board, int a, int b) {
        if(a<0||a>=board.length||b<0||b>=board[0].length)
            return;
        if (board[a][b] == 'O'){
            Queue<Point> cur = new LinkedList<Point>();
            Queue<Point> next = new LinkedList<Point>();
            cur.add(new Point(a,b));
            board[a][b] = 'Y';
            while(!cur.isEmpty()){
                while(!cur.isEmpty()){
                    Point p = cur.poll();
                    board[p.x][p.y] = 'Y';
                    if(p.x-1>=0&&board[p.x-1][p.y] == 'O'){
                        board[p.x-1][p.y] = 'Y';
                        next.add(new Point(p.x-1,p.y));
                    }
                    if(p.x+1<board.length&&board[p.x+1][p.y] == 'O'){
                        board[p.x+1][p.y] = 'Y';
                        next.add(new Point(p.x+1,p.y));
                    }
                    if(p.y-1>=0&&board[p.x][p.y-1] == 'O'){
                        board[p.x][p.y-1] = 'Y';
                        next.add(new Point(p.x,p.y-1));
                    }
                    if(p.y+1<board[0].length&&board[p.x][p.y+1] == 'O'){
                        board[p.x][p.y+1] = 'Y';
                        next.add(new Point(p.x,p.y+1));
                    }
                }
                cur.addAll(next);
                next.clear();
            }
        }
    }
}

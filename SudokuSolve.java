public class sudokuSolver {
    public boolean isSafe(char board[][], int row, int col, int number) {
        //row check
        for (int i=0; i<board.length; i++) {
            if (board[i][col]==(char)(number+'0')) {
                return false;
            }
        //column check
            if (board[row][col]==(char)(number + '0')) {
                return false;
            }
        }
        //grid check
            int nr = (row/3)*3;
            int nc = (col/3)*3;
            for (int i=nr; i<nr+3;i++) {
                for(int j=nc; j<nc+3;j++) {
                    if(board[i][j]==(char)(number+'0')) {
                        return false;
                    }
                }
            }
            return true;
        }
    public boolean helper (char board[][], int row, int col) {
        int ncol=0;
        int nrow=0;
        if(row!=board.length-1) {
            nrow=row;
            ncol=col+1;
        }
        else {
             nrow=row+1;
             col=0;
        }
        if( board[row][col]!='.') {
            if(helper(board, nrow, ncol))
            return true;
        }
        else {
            for(int i=1;i<=9; i++) {
                if ( isSafe(board,row,col,i) ) {
                    board[row][col] = (char)(i+'0');
                    if(helper(board, nrow, ncol)) {
                        return true;
                    }
                        else {
                            board[row][col] = '.';
                        }

                    }
                }

            }
            return false;
        }

    public void solveSudoku(char board[][]) {
        helper(board,0,0);

    }
}

    

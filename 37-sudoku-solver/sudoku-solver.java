class Solution {

    public void solveSudoku(char[][] board) {
        sudoku(0, 0, board);
    }

    boolean sudoku(int i, int j, char[][] board){

        if(i==9){                   //if(i==8  && j==8) is less good
            return true;
        }

        if(j==9){                            //to prevent j exceeds 8
            return sudoku(i+1, 0, board);
        }

        //where ever needed to call recursion call like:
        //  if true, we want to finish, if not go further => then use 1) if(sudoku(i, j+1, board)) return true;
        //      OR    
        //  if true, we want to finish, if not then also finish => then use 2) return sudoku(i, j+1, board);

        if(board[i][j]!='.'){ return sudoku(i, j+1, board); }
        else{
            for(int v = 1; v<=9; v++){
                if(isValid(v, i, j, board) ){
                    board[i][j]= (char) ('0'+v);       //place on board      //

                    if(sudoku(i, j+1, board)) return true;

                    board[i][j]='.';                //remove from board
                }
            }   
            return false;
        }
    }

    boolean isValid(int v, int i, int j, char[][] board){
        for(int k=0; k<9; k++){
            if(board[i][k]== (char) ('0'+v)) return false;
            if(board[k][j]== (char) ('0'+v)) return false;
            if(board[(3*(i/3)) + k/3 ][ (3*(j/3)) + k%3 ]== (char) ('0'+v)) return false;
        }
        return true;
    }
}




import java.util.ArrayList;
import java.util.List;



public class SolveNQueenprob {
    public boolean isSafe(int row ,int col,char board[][]){
        //vertically
        for(int i=0;i<board.length;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        //horizontal
        for(int j=0;j<board.length;j++){
            if(board[j][col]=='Q'){
                return false;
            }
        }
        //upper left
        int r=row;
        for(int c=col;c>=0 && r>=0;r--,c--){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //upper right
        r=row;
        for(int c=col;c<board.length && r>=0;c++,r--){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //bottom left
        r=row;
        for(int c=col;c>=0 && r<board.length;c--,r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //bottom right
        r=row;
        for(int c=col;c<board.length && r<board.length;c++,r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        return true;
    }
    public void saveBoard(char board[][],List<List<String>>allBoard){
        String row="";
        List<String>newBoard=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            row="";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='Q')
                    row +='Q';
                else
                    row +='.';
                }
                newBoard.add(row);
            }
            allBoard.add(newBoard);
    }
    public void helper(char board[][],List<List<String>>allBoard,int col){
        if(col==board.length){
            saveBoard(board,allBoard);
            return;
        }
            for(int row=0;row<board.length;row++){
                if(isSafe(row,col,board)){
                    board[row][col]='Q';
                        helper(board, allBoard, col+1);
                        board[row][col]='.';
            }
        }
    }
    List<List<String>>solveNQueen(int n){
    List<List<String>>allBoard= new ArrayList<>();
    char board[][]=new char[n][n];
    helper(board,allBoard,0);
    return allBoard;
    }
    public static void main(String[] args) {
        SolveNQueenprob p = new SolveNQueenprob();
        int n = 4;
        List<List<String>> allBoard = p.solveNQueen(n);
        System.out.println(allBoard);
    }
}
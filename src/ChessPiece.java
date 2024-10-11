public abstract class ChessPiece {

    String color;
    boolean hasMoved = false;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setHasMoved() {
        this.hasMoved = true;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                              int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean canMoveToPositionOnAStraightLine(ChessBoard chessBoard, int line, int column,
                                                    int toLine, int toColumn, int lineDiff, int colDiff) {

        if(lineDiff > 0 && colDiff == 0) //moves vertically
        {
            for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++)
            {
                if (chessBoard.board[i][column] != null) return false;
            }
            return  true;
        }
        else if(lineDiff == 0 && colDiff > 0) //moves horizontally
        {
            for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++)
            {
                if (chessBoard.board[line][i] != null) return false;
            }
            return true;
        }
        return false;
    }

    protected boolean canMoveToPositionDiagonally (ChessBoard chessBoard, int line, int column,
    int toLine, int toColumn, int lineDiff, int colDiff){

            if (lineDiff == colDiff){
            if (toLine - line == toColumn - column) {
                var j = Math.min(column, toColumn)+ 1;
                for(int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++)
                {
                    if (chessBoard.board[i][j] != null) return false;
                    j++;
                }
                return true;
            }
            else{
                var j = Math.max(column, toColumn) - 1;
                for(int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++)
                {
                    if (chessBoard.board[i][j] != null) return false;
                    j--;
                }
                return true;
            }
        }

        return false;
    }

}

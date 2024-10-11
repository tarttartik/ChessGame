public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                     int toLine, int toColumn) {

        var colDiff = Math.abs(toColumn-column);
        var lineDiff = Math.abs(toLine - line);
       if (!canMoveToPositionOnAStraightLine(chessBoard, line, column, toLine, toColumn, lineDiff, colDiff))
           return canMoveToPositionDiagonally(chessBoard, line, column, toLine, toColumn, lineDiff, colDiff);
       else return true;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}


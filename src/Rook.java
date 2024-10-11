public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                     int toLine, int toColumn) {

       return canMoveToPositionOnAStraightLine(chessBoard,line,column,
        toLine, toColumn, Math.abs(toLine - line), Math.abs(toColumn-column));
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

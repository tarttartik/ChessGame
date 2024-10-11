public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                     int toLine, int toColumn) {
        return canMoveToPositionDiagonally(chessBoard, line, column, toLine, toColumn,
                Math.abs(toLine - line), Math.abs(toColumn-column));
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

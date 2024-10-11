public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                     int toLine, int toColumn) {

        var colDiff = Math.abs(toColumn-column);
        var lineDiff = Math.abs(toLine - line);

        return ((colDiff == 2 && lineDiff == 1) || (lineDiff == 2 && colDiff == 1));
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

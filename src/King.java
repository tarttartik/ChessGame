public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                     int toLine, int toColumn) {

        var colDiff = Math.abs(toColumn-column);
        var lineDiff = Math.abs(toLine - line);

        return (lineDiff <= 1 && colDiff <= 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for(int i = 0; i < 8; i ++) {
            for(int j = 0; j < 8; j ++) {
                var piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(color)
                        && piece.canMoveToPosition(board, i, j, line, column)) return true;
            }
        }
        return false;
    }
}

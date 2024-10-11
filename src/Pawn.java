public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column,
                                     int toLine, int toColumn) {
        var allowedSteps = hasMoved ? 1 : 2;
        var stepsForward = color.equals("White") ? toLine-line : line - toLine;

        if (stepsForward <= allowedSteps && toColumn-column == 0) return true;

        //check attack possibility
        var prey = chessBoard.board[toLine][toColumn];
        return (Math.abs(column - toColumn) == 1 && stepsForward == 1 && prey != null && !prey.getColor().equals(color));
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

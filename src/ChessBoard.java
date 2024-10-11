public class ChessBoard {

    public ChessPiece[][] board = new  ChessPiece[8][8];

    private String nowPlayer;

    public ChessBoard(String nowPlayer)
    {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine, startColumn, endLine, endColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                board[endLine][endColumn].setHasMoved(); // set true to hasMoved of the moved piece
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int startLine, int startColumn, int endLine, int endColumn) {

        //check current position
        if(Math.min(startColumn, startLine) < 0 || Math.max(startColumn, startLine) > 7) return false;
        //check potential position
        if(startLine == endLine && startColumn == endColumn) return false;
        if (Math.min(endColumn, endLine) < 0 || Math.max(endColumn, endLine) > 7) return false;
        return (board[endLine][endColumn] == null || !board[endLine][endColumn].getColor().equals(nowPlayer));
    }

    public boolean castling(int column){

        int kingPos = 4;
        ChessPiece rook = null;
        ChessPiece king = null;
        int line = nowPlayer.equals("White") ? 0 : 7;

        king = board[line][kingPos];
        rook = board[line][column];

        //check if the pieces are valid
        if(king == null || !king.getColor().equals(nowPlayer) || !king.getSymbol().equals("K") ||
                rook == null || !rook.getSymbol().equals("R") || !rook.getColor().equals(nowPlayer)) return false;
        //check if the pieces can move
        if (king.hasMoved || rook.hasMoved || new King(nowPlayer).isUnderAttack(this, line, 4)) return false;

        for (int i = Math.min(kingPos, column) + 1; i < Math.max(kingPos, column); i++) {
            if (board[line][i] != null) return false;
        }

        if(column == 7) {
            board[line][6] = king;
            board[line][5] = rook;
        }
        else{
            board[line][2] = king;
            board[line][3] = rook;
        }

        board[line][kingPos] = null;
        board[line][column] = null;
        king.setHasMoved();
        rook.setHasMoved();

        this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

        return true;
    }

}

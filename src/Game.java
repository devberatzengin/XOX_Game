public class Game {
    private boolean isGameStart = false;
    private Player currentPlayer;
    private Player opponentPlayer;
    private Player player1;
    private Player player2;
    private Board board;

    public void startGame(Player player1, Player player2) {
        if (isGameStart) {
            System.out.println("Game is already started");
        } else {
            this.board = new Board();
            this.player1 = player1;
            this.player2 = player2;
            this.currentPlayer = player1;
            this.opponentPlayer = player2;
            this.isGameStart = true;
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            opponentPlayer = player1;
        } else {
            currentPlayer = player1;
            opponentPlayer = player2;
        }
    }

    public boolean checkWinner() {
        for (int k = 0; k < 3; k++) {
            if ((board.getCell(k, 0) == board.getCell(k, 1) && board.getCell(k, 1) == board.getCell(k, 2)) && board.getCell(k, 0) != '_') {
                System.out.println(currentPlayer.getName() + " wins!");
                return true;
            }
            if ((board.getCell(0, k) == board.getCell(1, k) && board.getCell(1, k) == board.getCell(2, k)) && board.getCell(0, k) != '_') {
                System.out.println(currentPlayer.getName() + " wins!");
                return true;
            }
        }
        if ((board.getCell(0, 0) == board.getCell(1, 1) && board.getCell(1, 1) == board.getCell(2, 2)) && board.getCell(0, 0) != '_') {
            System.out.println(currentPlayer.getName() + " wins!");
            return true;
        }
        if ((board.getCell(0, 2) == board.getCell(1, 1) && board.getCell(1, 1) == board.getCell(2, 0)) && board.getCell(0, 2) != '_') {
            System.out.println(currentPlayer.getName() + " wins!");
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j) == '_') {
                    return false;
                }
            }
        }
        System.out.println("\tDRAW\n\tGame is ended");
        return true;
    }

    public Board getBoard() {
        return board;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}

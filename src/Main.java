import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name, 'X');

        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name, 'O');

        Game game = new Game();
        game.startGame(player1, player2);

        boolean gameEnded = false;

        while (!gameEnded) {
            game.getBoard().displayBoard();
            System.out.println("\n" + game.getCurrentPlayer().getName() + "'s turn (" + game.getCurrentPlayer().getSymbol() + ")");

            System.out.print("Enter row (0, 1, or 2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0, 1, or 2): ");
            int col = scanner.nextInt();

            if (game.getCurrentPlayer().chooseMove(row, col, game.getBoard())) {
                if (game.checkWinner() || game.isBoardFull()) {
                    gameEnded = true;
                } else {
                    game.switchPlayer();
                }
            }
        }

        game.getBoard().displayBoard();
        scanner.close();
    }
}
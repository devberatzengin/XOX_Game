public class Player {

    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public boolean chooseMove(int row, int col, Board board) {
        return board.updateCell(row, col, this);
    }

    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
}

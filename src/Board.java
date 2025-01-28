public class Board {
    private Cell[][] cells;
    public Board() {
        cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            if (i > 0) System.out.println("---+---+---");
            for (int j = 0; j < 3; j++) {
                System.out.print((j > 0 ? " | " : "") + cells[i][j].getValue());
            }
            System.out.println();
        }
    }

    public boolean updateCell(int row, int col, Player player) {
        if (cells[row][col].getValue() != '_') {
            System.out.println("Cell is already occupied!");
            return false;
        }
        cells[row][col].setValue(player.getSymbol());
        return true;
    }

    public char getCell(int row, int col) {
        return cells[row][col].getValue();
    }
}

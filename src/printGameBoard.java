public class printGameBoard {

    public static void printBoard(char[][] gameBoard) {

        // create 2 loops
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
}

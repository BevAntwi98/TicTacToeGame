import java.util.Random;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws Exception {

        // 1) print game board
        // 2) create game loop
        // get input from user (1-9) then store it
        // get input from computer then store it and check winner
        // if a position is taken, alert user to enter another number
        // continue game until game ends

        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                               { '-', '+', '-', '+', '-' }, 
                               { ' ', '|', ' ', '|', ' ' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', ' ' } };
        printGameBoard.printBoard(gameBoard);

        // loops until game is over
        while (true) {
            // Scanner to get user input
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a number between 1-9");
            int playerNum = scan.nextInt();

            // checks to see if a player is trying to take a computer position
            while (Position.playerPos.contains(playerNum) || Position.computerPos.contains(playerNum)) {
                System.out.println("Position taken! try again");
                playerNum = scan.nextInt();
            }
            System.out.println(playerNum);
            // play piece for player and computer;
            Position.playerPiece(gameBoard, playerNum, "player");

            String result = Winner.checkWinner();
            if (result.length() > 0) {
                printGameBoard.printBoard(gameBoard);
                System.out.println(result);
                break;
            }

            // ------------------computer function-------------------------------
            // randomly allocates a place for the computer
            Random random = new Random();
            // computer playes 1-9 (unless player took one of those numbers)
            int computerPlayer = random.nextInt(9) + 1;
            while (Position.playerPos.contains(computerPlayer) || Position.computerPos.contains(computerPlayer)) {
                computerPlayer = random.nextInt(9) + 1;
            }
            Position.playerPiece(gameBoard, computerPlayer, "computer");
            printGameBoard.printBoard(gameBoard);
            result = Winner.checkWinner();

            if (result.length() > 0) {
                System.out.println(result);
                printGameBoard.printBoard(gameBoard);
                break;
            }

        }
    }
}

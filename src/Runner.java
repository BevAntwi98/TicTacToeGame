import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Runner {

    // global, every method can access these
    static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    static ArrayList<Integer> computerPos = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {

        // 1) print game board
        // 2) create game loop
        // get input from user (1-9) then store it
        // get input from computer then store it and check winner
        // if a position is taken, alert user to enter another number
        // continue game until game ends

        
        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
        printGameBoard.printBoard(gameBoard);

        // loops until game is over
        while (true) {
            // Scanner to get user input
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a number between 1-9");
            int playerNum = scan.nextInt();

            // checks to see if a player is trying to take a computer position
            while (playerPos.contains(playerNum) || computerPos.contains(playerNum)) {
                System.out.println("Position taken! try again");
                playerNum = scan.nextInt();
            }
            System.out.println(playerNum);
            // play piece for player and computer;
            playerPiece(gameBoard, playerNum, "player");

            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                // printBoard(gameBoard);
                break;
            }

            // randomly allocates a place for the computer
            Random random = new Random();

            // computer playes 1-9 (unless player took one of those numbers)
            int computerPlayer = random.nextInt(9) + 1;
            while (playerPos.contains(computerPlayer) || computerPos.contains(computerPlayer)) {
                computerPlayer = random.nextInt(9) + 1;
            }
            playerPiece(gameBoard, computerPlayer, "computer");
            printGameBoard.printBoard(gameBoard);
            result = checkWinner();

            if (result.length() > 0) {
                System.out.println(result);
                printGameBoard.printBoard(gameBoard);
                break;
            }

        }
    }

    public static void playerPiece(char[][] gameBoard, int position, String user) {

        // update empty space. if player prints 1, enter x into space no. on board

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPos.add(position);
        } else if (user.equals("computer")) {
            symbol = 'O';
            computerPos.add(position);
        }

        switch (position) {
        case 1:
            gameBoard[0][0] = symbol;
            break;
        case 2:
            gameBoard[0][2] = symbol;
            break;
        case 3:
            gameBoard[0][4] = symbol;
            break;
        case 4:
            gameBoard[2][0] = symbol;
            break;
        case 5:
            gameBoard[2][2] = symbol;
            break;
        case 6:
            gameBoard[2][4] = symbol;
            break;
        case 7:
            gameBoard[4][0] = symbol;
            break;
        case 8:
            gameBoard[4][2] = symbol;
            break;
        case 9:
            gameBoard[4][4] = symbol;
            break;
        default:
            break;

        }
    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List firstCol = Arrays.asList(1, 4, 7);
        List secondCol = Arrays.asList(2, 5, 8);
        List thirdCol = Arrays.asList(3, 6, 9);
        List diagonal_1 = Arrays.asList(1, 5, 9);
        List diagonal_2 = Arrays.asList(3, 5, 7);

        // adding the above lists into a loop
        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(firstCol);
        winningConditions.add(secondCol);
        winningConditions.add(thirdCol);
        winningConditions.add(diagonal_1);
        winningConditions.add(diagonal_2);

        for (List l : winningConditions) {
            if (playerPos.containsAll(l)) {
                return "Congrats! You won :)";
            } else if (computerPos.containsAll(l)) {
                return "Computer wins :(";
            } else if (playerPos.size() + computerPos.size() == 9) {
                return "It's a tie!";
            }

        }
        return "";
    }
}
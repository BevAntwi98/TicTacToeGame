import java.util.ArrayList;

public class Position {

    // global, every method can access these
    static ArrayList<Integer> playerPos = new ArrayList<Integer>();
    static ArrayList<Integer> computerPos = new ArrayList<Integer>();

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
}

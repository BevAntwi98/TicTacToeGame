import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {
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
            if (Position.playerPos.containsAll(l)) {
                return "Congrats! You won :)";
            } else if (Position.computerPos.containsAll(l)) {
                return "Computer wins :(";
            } else if (Position.playerPos.size() + Position.computerPos.size() == 9) {
                return "It's a tie!";
            }

        }
        return "";
    }
}


import java.util.Scanner;

public class TicTacToe {

    static char[] board = {'1','2','3','4','5','6','7','8','9'};

    static void displayBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWinner(char player) {
        int[][] wins = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] line : wins) {
            if (board[line[0]] == player &&
                board[line[1]] == player &&
                board[line[2]] == player) {
                return true;
            }
        }
        return false;
    }

    static boolean isDraw() {
        for (char cell : board) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }

    static void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("================================");
        System.out.println("       TIC-TAC-TOE GAME");
        System.out.println("================================");

        while (playAgain) {
            resetBoard();
            char player = 'X';
            boolean gameOver = false;

            while (!gameOver) {
                displayBoard();

                System.out.println("Player " + player + "'s turn");
                System.out.print("Choose a position (1-9): ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a number from 1 to 9.");
                    sc.next();
                    continue;
                }

                int position = sc.nextInt();

                if (position < 1 || position > 9) {
                    System.out.println("Invalid position! Try again.");
                    continue;
                }

                int index = position - 1;

                if (board[index] == 'X' || board[index] == 'O') {
                    System.out.println("That position is already taken!");
                    continue;
                }

                board[index] = player;

                if (checkWinner(player)) {
                    displayBoard();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isDraw()) {
                    displayBoard();
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            }

            System.out.print("Play another round? (y/n): ");
            playAgain = sc.next().equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing Tic-Tac-Toe!");
        sc.close();
    }
}

import java.util.Scanner;

public class XOX {
    static Scanner input = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static int turn = 0;

    public static void main(String[] args) {
        while (true) {
            printBoard();
            if (checkWin('X')) {
                System.out.println("Player X wins!");
                break;
            } else if (checkWin('O')) {
                System.out.println("Player O wins!");
                break;
            } else if (turn == 9) {
                System.out.println("It's a draw!");
                break;
            }

            System.out.print("Enter row and column: ");
            int row = input.nextInt() - 1;
            int col = input.nextInt() - 1;

            if (board[row][col] == ' ') {
                if (turn % 2 == 0) {
                    board[row][col] = 'X';
                } else {
                    board[row][col] = 'O';
                }
                turn++;
            } else {
                System.out.println("This cell is already filled. Try again.");
            }
        }
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    static void printBoard() {
        System.out.println(" 1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

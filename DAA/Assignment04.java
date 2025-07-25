import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment04 {
// Check if it's safe to place a queen at board[row][col]
public static boolean isSafe(char[][] board, int row, int col, int n) {
    // Check column
    for (int i = 0; i < row; i++)
        if (board[i][col] == 'Q')
            return false;

    // Check left diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 'Q')
            return false;

    // Check right diagonal
    for (int i = row, j = col; i >= 0 && j < n; i--, j++)
        if (board[i][j] == 'Q')
            return false;

    return true;
}

// Convert board to list of strings
public static List<String> constructBoard(char[][] board) {
    List<String> result = new ArrayList<>();
    for (char[] row : board) {
        result.add(new String(row));
    }
    return result;
}

// Backtracking function
public static void solve(List<List<String>> results, char[][] board, int row, int n) {
    if (row == n) {
        results.add(constructBoard(board));
        return;
    }

    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col, n)) {
            board[row][col] = 'Q';
            solve(results, board, row + 1, n);
            board[row][col] = '.';
        }
    }
}

// Print a board configuration
public static void printBoard(List<String> board) {
    for (String row : board) {
        System.out.println(row);
    }
    System.out.println();
}

// Main method
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the value of n: ");
    int n = sc.nextInt();

    if (n <= 0) {
        System.out.println("n must be a positive integer.");
        return;
    }

    System.out.print("Enter column index (0 to " + (n - 1) + ") to place the first queen in row 0: ");
    int firstQueenCol = sc.nextInt();

    if (firstQueenCol < 0 || firstQueenCol >= n) {
        System.out.println("Invalid column index.");
        return;
    }

    List<List<String>> results = new ArrayList<>();
    char[][] board = new char[n][n];

    // Initialize board with '.'
    for (char[] row : board) {
        Arrays.fill(row, '.');
    }

    // Place the first queen manually
    board[0][firstQueenCol] = 'Q';

    // Start solving from row 1
    solve(results, board, 1, n);

    // Print results
    if (results.isEmpty()) {
        System.out.println("No solutions found for n = " + n + " with first queen at column " + firstQueenCol);
    } else {
        System.out.println("Solutions:");
        for (List<String> solution : results) {
            printBoard(solution);
        }
    }

    sc.close();
}


}

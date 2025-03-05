import java.util.*;

public class NQueens {

    // Function to check if placing a queen is safe
    private static boolean isSafe(List<String> board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }
        
        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        
        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        
        return true;
    }

    // Function to print the board
    private static void printBoard(List<String> board) {
        for (String row : board) {
            System.out.println(row);
        }
        System.out.println();
    }

    // Backtracking function to solve N-Queens
    private static void solveNQueens(List<List<String>> res, List<String> board, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            printBoard(board);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));
                
                solveNQueens(res, board, row + 1, n);
                
                charArray[col] = '.'; // Backtrack
                board.set(row, new String(charArray));
            }
        }
    }

    // Optimized solution using Branch and Bound
    private static void solveNQueensOptimal(List<List<String>> res, List<String> board, int row, int n, 
                                            int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (leftRow[col] == 0 && upperDiagonal[row + col] == 0 && lowerDiagonal[n - 1 + col - row] == 0) {
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row, new String(charArray));
                
                leftRow[col] = 1;
                upperDiagonal[row + col] = 1;
                lowerDiagonal[n - 1 + col - row] = 1;
                
                solveNQueensOptimal(res, board, row + 1, n, leftRow, upperDiagonal, lowerDiagonal);
                
                charArray[col] = '.'; // Backtrack
                board.set(row, new String(charArray));
                leftRow[col] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();

        List<List<String>> res = new ArrayList<>();
        List<String> board = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(new String(row));
        }

        // Solve using backtracking
        solveNQueens(res, board, 0, n);
        
        System.out.println("All possible solutions for N-Queens problem using Backtracking:");
        for (List<String> solution : res) {
            printBoard(solution);
        }

        res.clear();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        
        // Solve using optimized branch and bound
        solveNQueensOptimal(res, board, 0, n, leftRow, upperDiagonal, lowerDiagonal);
        
        System.out.println("All possible solutions for N-Queens problem using Branch and Bound:");
        for (List<String> solution : res) {
            printBoard(solution);
        }
    }
}

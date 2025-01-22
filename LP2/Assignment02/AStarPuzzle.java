import java.util.*;

public class AStarPuzzle {

    private static final int N = 3;
    private static final int[] dRow = {1, 0, -1, 0};
    private static final int[] dCol = {0, -1, 0, 1};
    

    // Print the matrix
    private static void printMatrix(int[][] mat, int g, int h) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("g: " + g + " h: " + h + " f: " + (g + h));
    }

    // Calculate the heuristic value (misplaced tiles)
    private static int calculateHeuristic(int[][] initial, int[][] goal) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Check if the position is valid
    private static boolean isSafe(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // Print the path from the root to the goal
    private static void printPath(Node node) {
        if (node == null) return;
        printPath(node.parent);
        printMatrix(node.mat, node.g, node.h);
        System.out.println();
    }

    // Solve the puzzle using A* algorithm
    public static void solve(int[][] start, int x, int y, int[][] goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> (n.g + n.h)));

        Node root = new Node(start, x, y, 0, null);
        root.h = calculateHeuristic(start, goal);
        pq.add(root);

        int moveCount = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.h == 0) {
                System.out.println("\n\nPuzzle solved in " + moveCount + " moves.");
                printPath(current);
                return;
            }

            moveCount++;

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dRow[i];
                int newY = current.y + dCol[i];

                if (isSafe(newX, newY)) {
                    int[][] newMat = new int[N][N];
                    for (int m = 0; m < N; m++) {
                        System.arraycopy(current.mat[m], 0, newMat[m], 0, N);
                    }

                    // Swap blank tile with the new position
                    int temp = newMat[current.x][current.y];
                    newMat[current.x][current.y] = newMat[newX][newY];
                    newMat[newX][newY] = temp;

                    Node child = new Node(newMat, newX, newY, current.g + 1, current);
                    child.h = calculateHeuristic(newMat, goal);
                    pq.add(child);
                }
            }
        }

        System.out.println("Puzzle cannot be solved.");
    }

}

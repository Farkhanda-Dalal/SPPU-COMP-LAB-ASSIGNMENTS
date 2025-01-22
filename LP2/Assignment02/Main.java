import java.util.*;
// Main class to run the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] start = new int[3][3];
        int[][] goal = new int[3][3];
        // AStarPuzzle a=new AStarPuzzle();

        System.out.println("Enter the start state: ");
        int x = -1, y = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                start[i][j] = scanner.nextInt();
                if (start[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("Enter the goal state: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                goal[i][j] = scanner.nextInt();
            }
        }

        AStarPuzzle.solve(start, x, y, goal);
        scanner.close();
    }
}


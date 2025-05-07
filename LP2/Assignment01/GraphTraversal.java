import java.util.Scanner;

public class GraphTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Edges (Multiple)");
            System.out.println("2. Print Graph");
            System.out.println("3. DFS");
            System.out.println("4. BFS");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter edges (u v). Type 'done' to stop:");
                    while (true) {
                        String input = scanner.next();
                        if (input.equals("done")) break;
                        int u = Integer.parseInt(input);
                        int v = scanner.nextInt();
                        graph.addEdge(u, v);
                        System.out.println("Edge added.");
                    }
                    break;
                case 2:
                    graph.printGraph();
                    break;
                case 3:
                    System.out.print("Start node for DFS: ");
                    int dfsStart = scanner.nextInt();
                    graph.dfs(dfsStart);
                    break;
                case 4:
                    System.out.print("Start node for BFS: ");
                    int bfsStart = scanner.nextInt();
                    graph.bfs(bfsStart);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}

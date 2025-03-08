public class GraphTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of cities: ");
        int nv = sc.nextInt();
        Graph g = new Graph(nv);

        while (true) {
            System.out.println("\n1. Add Nodes");
            System.out.println("2. Print Graph");
            System.out.println("3. BFS Traversal");
            System.out.println("4. DFS Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    g.initMap(sc);
                    break;
                case 2:
                    System.out.println("Graph:");
                    g.displayGraph();
                    break;
                case 3:
                    System.out.print("Enter source city: ");
                    String srcBfs = sc.next();
                    int srcIdBfs = g.getIndex(srcBfs);
                    if (srcIdBfs != -1)
                        g.BFS(srcIdBfs);
                    else
                        System.out.println("City not found!");
                    break;
                case 4:
                    System.out.print("Enter source city: ");
                    String srcDfs = sc.next();
                    int srcIdDfs = g.getIndex(srcDfs);
                    if (srcIdDfs != -1)
                        g.DFS(srcIdDfs);
                    else
                        System.out.println("City not found!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}

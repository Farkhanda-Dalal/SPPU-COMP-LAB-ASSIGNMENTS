import java.util.*;

public class Graph {
    // Adjacency list to store the graph
    private Map<String, List<String>> adjacencyList = new HashMap<>();
    
    // Method to add an edge to the graph
    public void addEdge(String node1, String node2) {
        adjacencyList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        adjacencyList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    // Method to print the graph
    public void printGraph() {
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (String neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Depth First Search (DFS) - Recursive
    public void depthSearch(String key, String startNode) {
        Set<String> visited = new HashSet<>();
        depthSearchImpl(startNode, key, visited, 0);
    }

    // Helper method for DFS
    private boolean depthSearchImpl(String node, String key, Set<String> visited, int level) {
        System.out.println("[DFS] Visited " + node + " , level = " + level);
        if (node.equals(key)) {
            System.out.println(key + " found in the graph!");
            return true;
        }

        visited.add(node);
        List<String> neighbors = adjacencyList.getOrDefault(node, new ArrayList<>());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                boolean found = depthSearchImpl(neighbor, key, visited, level + 1);
                if (found) return true;
            }
        }
        return false;
    }

    // Breadth First Search (BFS) - Recursive
    public void breadthSearch(String key, String startNode) {
        Set<String> visited = new HashSet<>();
        Queue<String> frontier = new LinkedList<>();
        Queue<Integer> frontierLevels = new LinkedList<>();
        
        frontier.add(startNode);
        frontierLevels.add(0);
        breadthSearchImpl(frontier, frontierLevels, key, visited);
    }

    // Helper method for Recursive BFS
    private void breadthSearchImpl(Queue<String> frontier, Queue<Integer> frontierLevels, String key, Set<String> visited) {
        if (frontier.isEmpty()) {
            return; // Base case: if the frontier is empty, stop
        }

        String node = frontier.poll(); // Dequeue a node
        int level = frontierLevels.poll(); // Get its level
        System.out.println("[BFS] Visited " + node + " , level = " + level);

        if (node.equals(key)) {
            System.out.println(key + " found in the graph!");
            return; // Stop if the key is found
        }

        visited.add(node); // Mark this node as visited
        List<String> neighbors = adjacencyList.getOrDefault(node, new ArrayList<>());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                frontier.add(neighbor); // Enqueue the neighbor
                frontierLevels.add(level + 1); // Enqueue the neighbor's level
            }
        }

        // Recursive call to process the next node in the frontier
        breadthSearchImpl(frontier, frontierLevels, key, visited);
    }

    // Method to take user input
    public static String input(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        
        // Taking input for adding edges
        System.out.println("Enter node-pairs:");
        while (true) {
            String node1 = input("Node 1");
            String node2 = input("Node 2");
            if (node1.equals("-") && node2.equals("-")) {
                break;
            }
            graph.addEdge(node1, node2);
            System.out.println("[Edge from " + node1 + " to " + node2 + " added]");
        }

        // Taking input for DFS and BFS searches
        String key = input("Enter key: ");
        String startNode = input("Enter start node: ");
        
        graph.depthSearch(key, startNode);
        graph.breadthSearch(key, startNode);
        
        // Print the graph structure
        graph.printGraph();
    }
}

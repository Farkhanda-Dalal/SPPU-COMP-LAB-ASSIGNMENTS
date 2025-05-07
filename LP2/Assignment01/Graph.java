import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void printGraph() {
        System.out.println("Graph Representation (Adjacency List):");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> levelMap = new HashMap<>();
        List<Integer> traversalOrder = new ArrayList<>();

        System.out.print("DFS Traversal: ");
        dfsRecursive(start, visited, 0, levelMap, traversalOrder);
        System.out.println();

        for (int node : traversalOrder) {
            System.out.println(node + " at level " + levelMap.get(node));
        }
    }

    private void dfsRecursive(int node, Set<Integer> visited, int level, Map<Integer, Integer> levelMap, List<Integer> traversalOrder) {
        visited.add(node);
        traversalOrder.add(node);
        System.out.print(node + " ");
        levelMap.put(node, level);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, level + 1, levelMap, traversalOrder);
            }
        }
    }
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> levelMap = new HashMap<>();
        List<Integer> traversalOrder = new ArrayList<>();
    
        queue.offer(start);
        visited.add(start);
        levelMap.put(start, 0);
    
        System.out.print("BFS Traversal: ");
        bfsRecursive(queue, visited, levelMap, traversalOrder);
    
        System.out.println();
        for (int node : traversalOrder) {
            System.out.println(node + " at level " + levelMap.get(node));
        }
    }
    
    private void bfsRecursive(Queue<Integer> queue, Set<Integer> visited,
                              Map<Integer, Integer> levelMap, List<Integer> traversalOrder) {
        if (queue.isEmpty()) return;
    
        int node = queue.poll();
        traversalOrder.add(node);
        System.out.print(node + " ");
        int currentLevel = levelMap.get(node);
    
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                queue.offer(neighbor);
                visited.add(neighbor);
                levelMap.put(neighbor, currentLevel + 1);
            }
        }
    
        // Recurse with the updated queue
        bfsRecursive(queue, visited, levelMap, traversalOrder);
    }
    
}

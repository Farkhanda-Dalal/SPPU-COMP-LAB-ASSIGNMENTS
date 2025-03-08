
class Graph {
    String[] cities;
    Node[] adjList;
    int nv;

    public Graph(int n) {
        this.nv = n;
        adjList = new Node[n];
        cities = new String[n]; // to store the names of the cities
    }

    // get Id(index of the city)
    int getIndex(String city) {
        for (int i = 0; i < nv; i++) {
            if (cities[i].equals(city))
                return i;
        }
        return -1;
    }

    // add an edge (link between cities)
    void addEdge(int s, int d) {
        Node newNode = new Node(d);
        newNode.next = adjList[s];
        adjList[s] = newNode;

        newNode = new Node(s);
        newNode.next = adjList[d];
        adjList[d] = newNode;
    }

    // Display Graph
    void displayGraph() {
        for (int i = 0; i < nv; i++) {
            System.out.print(cities[i] + " -> ");
            Node temp = adjList[i];
            while (temp != null) {
                System.out.print(cities[temp.dest] + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Initialize Map / Network
    void initMap(Scanner sc) {
        for (int i = 0; i < nv; i++) {
            System.out.print("Enter the city no " + (i + 1) + ": ");
            cities[i] = sc.next();
        }

        for (int i = 0; i < nv; i++) {
            System.out.println("Enter number of cities connected to " + cities[i] + ": ");
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                System.out.print("Enter connected city: ");
                String des = sc.next();
                int srcId = getIndex(cities[i]);
                int desId = getIndex(des);

                if (srcId == -1 || desId == -1) {
                    System.out.println("Unknown City!");
                    continue;
                }
                addEdge(srcId, desId);
            }
        }
    }

    // BFS - Breadth First Search
    void BFS(int src) {
        boolean[] visited = new boolean[nv];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(cities[curr] + " ");
            Node temp = adjList[curr];
            while (temp != null) {
                int neighbor = temp.dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
                temp = temp.next;
            }
        }
        System.out.println();
    }

    // DFS - Depth First Search
    void DFS(int src) {
        boolean[] visited = new boolean[nv];
        Stack<Integer> stack = new Stack<>();

        stack.push(src);
        visited[src] = true;

        System.out.println("DFS Traversal:");
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            System.out.print(cities[curr] + " ");
            Node temp = adjList[curr];
            while (temp != null) {
                int neighbor = temp.dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
                temp = temp.next;
            }
        }
        System.out.println();
    }
}

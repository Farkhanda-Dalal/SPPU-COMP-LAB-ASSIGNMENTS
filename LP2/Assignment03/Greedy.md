# Greedy Algorithms

## What is a Greedy Algorithm?
A **Greedy Algorithm** is an approach to solving optimization problems by making the locally optimal choice at each step with the hope of finding the global optimum. This method does not always guarantee the best solution, but it works well for many problems, especially when the problem exhibits the **Greedy Choice Property** and **Optimal Substructure**.

### Characteristics of Greedy Algorithms:
1. **Greedy Choice Property**: A global optimum can be arrived at by choosing a local optimum.
2. **Optimal Substructure**: An optimal solution to the problem contains optimal solutions to its subproblems.

## How Greedy Algorithm Works
1. Start with an initial solution.
2. Select the best possible choice at the moment.
3. Repeat step 2 until the solution is complete.
4. Ensure the selected choices lead to an optimal solution.

## Applications of Greedy Algorithm in the Given Program

### 1. **Minimum Spanning Tree (Prim's Algorithm)**
A **Minimum Spanning Tree (MST)** is a subset of the edges in a weighted graph that connects all vertices while minimizing the total edge weight. **Prim's Algorithm** is a greedy algorithm that constructs the MST by always selecting the smallest edge that expands the tree.

#### **How Prim's Algorithm Works:**
1. Initialize a priority queue (min-heap) to select the minimum weight edge.
2. Start from any vertex and mark it as part of the MST.
3. Add the smallest edge connecting the MST to a new vertex.
4. Repeat until all vertices are included in the MST.

#### **Implementation in the Program:**
- The `Graph` class represents the graph using an adjacency list.
- The `primsMST(int start)` function applies Prim's Algorithm:
  - Uses a **priority queue** to pick the smallest edge.
  - Maintains an array to track **parent nodes** and **minimum edge weights**.
  - Iterates through all edges greedily, ensuring a minimal spanning tree is formed.

### **2. Selection Sort**
**Selection Sort** is a simple greedy sorting algorithm that repeatedly selects the smallest element from the unsorted part and places it at the beginning.

#### **How Selection Sort Works:**
1. Find the smallest element in the array.
2. Swap it with the first element of the unsorted part.
3. Move to the next position and repeat.
4. Continue until the entire array is sorted.

#### **Implementation in the Program:**
- The `Sorting` class has a `selectionSort(int[] arr)` function that:
  - Iterates through the array.
  - Finds the minimum element in the remaining unsorted part.
  - Swaps it with the first element of the unsorted section.
  - Prints the sorted array.

## Conclusion
Greedy algorithms provide an efficient and intuitive approach to solving many optimization problems. In this program:
- **Prim's Algorithm** is used to construct the **Minimum Spanning Tree (MST)**, ensuring minimal total edge weight.
- **Selection Sort** follows a greedy approach by always selecting the smallest element and placing it in the correct position.

While greedy algorithms do not always guarantee an optimal solution, they are powerful when the problem structure supports them, as demonstrated in this program.

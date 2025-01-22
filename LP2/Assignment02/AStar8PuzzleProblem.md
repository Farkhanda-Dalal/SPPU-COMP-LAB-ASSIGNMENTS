Explanation of Code
Data Structures
2D Arrays (int[][]):

Used to represent the current state of the puzzle (start), the desired final state (goal), and intermediate states.
Node Class:

Represents a state of the puzzle. Each node contains:
mat: Current 2D array representing the puzzle state.
g: Cost to reach this node (number of moves).
h: Heuristic cost (misplaced tiles count).
x, y: Coordinates of the blank tile (0).
parent: Reference to the parent node (used to trace the solution path).
Priority Queue (PriorityQueue<Node>):

A min-heap ordered by the f value (f = g + h).
Ensures that the node with the lowest cost is expanded first.
Functions
calculateHeuristic:

Calculates the heuristic value (h) for a node.
Uses the misplaced tiles heuristic: counts how many tiles are not in their correct positions, excluding the blank tile.
isSafe:

Checks if a move is within the grid boundaries.
printMatrix:

Prints the puzzle matrix along with g, h, and f values for debugging or visualization.
printPath:

Recursively traces and prints the path from the root node (start state) to the current node.
solve:

Implements the A* algorithm:
Initializes the root node and adds it to the priority queue.
Expands nodes with the lowest f value.
Generates child nodes by moving the blank tile in all valid directions.
Stops when the goal state is reached or the queue is empty.
Algorithm (Pseudocode)
Input
start: Initial 3x3 matrix.
goal: Goal 3x3 matrix.
x, y: Coordinates of the blank tile (0) in the start state.
Output
Path from the start state to the goal state (if solvable) or a message indicating failure.
A Algorithm*
plaintext
Copy
Edit
1. Initialize a priority queue (min-heap).
2. Create the root node:
   - Set `g = 0` (cost so far).
   - Calculate `h` (heuristic value using misplaced tiles).
   - Set `parent = null`.
3. Add the root node to the priority queue.

4. While the queue is not empty:
   a. Remove the node with the lowest f = g + h from the queue.
   b. If `h == 0` for this node:
       - Goal state is reached. Print the path and exit.
   c. Otherwise:
       - Generate child nodes for all valid moves (up, down, left, right):
         i. Create a new matrix by swapping the blank tile with the target position.
         ii. Calculate `g` (increment by 1) and `h` (misplaced tiles).
         iii. Add the child node to the priority queue.
5. If the queue is empty and no solution is found, print "Puzzle cannot be solved."
Markdown File Structure
markdown
Copy
Edit
# 8-Puzzle Solver Using A* Algorithm

## Overview
This project implements the A* algorithm to solve the **8-puzzle problem**. The goal is to rearrange tiles on a 3x3 grid to match a predefined goal state using the minimum number of moves.

## Features
- Calculates the solution using the **A\*** algorithm.
- Uses the **misplaced tiles** heuristic.
- Displays the solution path from the start state to the goal state.

## Input and Output
### Input
1. **Start State**: 3x3 matrix representing the initial puzzle configuration.
2. **Goal State**: 3x3 matrix representing the target configuration.

Example:
Start State: 1 2 3 4 0 5 7 8 6

Goal State: 1 2 3 4 5 6 7 8 0

markdown
Copy
Edit

### Output
- Prints the solution path, including the `g`, `h`, and `f` values for each step.
- Displays the number of moves required to solve the puzzle.

Example:
Puzzle solved in 4 moves. 1 2 3 4 0 5 7 8 6 g: 0 h: 3 f: 3

1 2 3 4 5 0 7 8 6 g: 1 h: 2 f: 3 ...

markdown
Copy
Edit

## Approach
### A* Algorithm
- **Heuristic**: Misplaced tiles.
- **Priority Queue**: Ensures that the node with the lowest `f = g + h` is expanded first.

### Data Structures
- **Node**: Represents a state of the puzzle.
- **PriorityQueue**: Manages the open list of nodes to be expanded.

### Functions
1. `calculateHeuristic`: Computes heuristic cost (`h`).
2. `printPath`: Recursively prints the solution path.
3. `solve`: Implements the A* algorithm.

## How to Run
1. Compile the program using `javac`:
javac Main.java AStarPuzzle.java Node.java

markdown
Copy
Edit
2. Run the program:
java Main

csharp
Copy
Edit
3. Enter the start and goal states as prompted.

## Example Execution
Input:
Start State: 1 2 3 4 0 5 7 8 6

Goal State: 1 2 3 4 5 6 7 8 0

makefile
Copy
Edit

Output:
Puzzle solved in 4 moves. 1 2 3 ...

markdown
Copy
Edit

## Requirements
- Java 8 or higher.

## Files
- `Main.java`: Entry point for the program.
- `AStarPuzzle.java`: Implements the A* algorithm.
- `Node.java`: Defines the `Node` class for puzzle states.

## License
This project is licensed under the MIT License.
Let me know if you'd like the Markdown file directly!








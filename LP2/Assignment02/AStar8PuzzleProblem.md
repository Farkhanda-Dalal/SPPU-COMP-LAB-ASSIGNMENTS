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
Start State: </br>
1 2 3 </br>
4 0 5 </br>
6 7 8 </br>

Goal State: </br>
1 2 3 </br>
4 5 6 </br>
7 8 0 </br>

# Explanation of Code

## Data Structures Used:
### 1. 2D Arrays (int[][]):
Used to represent the current state of the puzzle (start), the desired final state (goal), and intermediate states.

### 2. Node Class:
Represents a state of the puzzle. </br>
Each node contains:
- mat: Current 2D array representing the puzzle state.
- g: Cost to reach this node (number of moves).
- h: Heuristic cost (misplaced tiles count).
- x, y: Coordinates of the blank tile (0).
- parent: Reference to the parent node (used to trace the solution path).

### 3. Priority Queue (PriorityQueue<Node>):
A min-heap ordered by the f value (f = g + h). </br>
Ensures that the node with the lowest cost is expanded first.

## Functions
### 1. calculateHeuristic:
- Calculates the heuristic value (h) for a node.
- Uses the misplaced tiles heuristic: counts how many tiles are not in their correct positions, excluding the blank tile.

### 2. isSafe:
Checks if a move is within the grid boundaries.

### 3. printMatrix:
Prints the puzzle matrix along with g, h, and f values for debugging or visualization.

### 4. printPath:
Recursively traces and prints the path from the root node (start state) to the current node.

### 5. solve:
Implements the A* algorithm:
- Initializes the root node and adds it to the priority queue.
- Expands nodes with the lowest f value.
- Generates child nodes by moving the blank tile in all valid directions.
- Stops when the goal state is reached or the queue is empty.

## Algorithm (Pseudocode)
### 1. Input
- start: Initial 3x3 matrix.
- goal: Goal 3x3 matrix.
- x, y: Coordinates of the blank tile (0) in the start state.
### 2. Output
Path from the start state to the goal state (if solvable) or a message indicating failure.
### 3. A Algorithm
```
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
```








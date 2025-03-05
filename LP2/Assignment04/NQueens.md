## **N-Queens Problem**  
The **N-Queens problem** is a classic combinatorial problem where we must place `N` queens on an `N × N` chessboard such that:  

- **No two queens attack each other** (i.e., no two queens share the same row, column, or diagonal).  
- The goal is to find all possible ways to place `N` queens on the board.

### **Example for `N = 4`**  
For `N = 4`, one valid solution is:

```
. Q . .
. . . Q
Q . . .
. . Q .
```

---

## **Approaches to Solve the N-Queens Problem**  
We mainly use **Backtracking** and an optimized **Branch and Bound** technique.

### **1. Backtracking Approach**  
#### **Concept**  
- Backtracking is a **brute-force** method that tries all possible placements of queens.  
- If we place a queen in a row, we recursively move to the next row and try placing another queen.
- If at any point, we cannot place a queen without a conflict, we **backtrack** (undo the previous step) and try another position.

#### **Steps:**  
1. Start from the first row.
2. Try placing a queen in each column of the current row.
3. Check if it is safe (not attacked by previous queens).
4. If safe, place the queen and move to the next row.
5. If placing a queen in a row leads to no solution, remove it (backtrack) and try the next column.
6. Repeat until all `N` queens are placed.

#### **Time Complexity:**  
- **O(N!)** (Factorial Time) – Because we explore all possible placements.

---

### **2. Branch and Bound Approach (Optimized)**  
#### **Concept**  
- The backtracking method repeatedly checks for safe positions using loops, making it inefficient.
- **Branch and Bound** improves this by maintaining three additional arrays:
  - **`leftRow`** → Tracks if a column already has a queen.
  - **`upperDiagonal`** → Tracks if the upper diagonal (`row + col`) is occupied.
  - **`lowerDiagonal`** → Tracks if the lower diagonal (`col - row + (N-1)`) is occupied.

#### **Optimizations**  
- Instead of checking for conflicts in all previous rows, we **precompute** which positions are safe using the three arrays.
- **Faster than backtracking** because lookup in these arrays is **O(1)** instead of checking multiple positions.

#### **Time Complexity:**  
- **O(N!)** (still factorial), but **constant-time checks** make it much faster in practice.

---

## **Comparison of Approaches**  
| **Approach**     | **Time Complexity** | **Space Complexity** | **Efficiency** |
|------------------|--------------------|----------------------|---------------|
| **Backtracking** | O(N!)              | O(N²) (storing board) | Slower |
| **Branch & Bound** | O(N!) | O(N) (uses arrays instead of board checks) | Faster |

---

## **When to Use Which?**  
- **Backtracking**: When `N` is small (e.g., `N ≤ 10`).
- **Branch & Bound**: When `N` is large (`N > 10`) since it reduces unnecessary computations.


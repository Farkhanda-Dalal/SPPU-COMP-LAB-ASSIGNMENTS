# N-Queens Problem: Backtracking and Branch & Bound Explanation

## Rules and Constraints
In the N-Queens problem, we need to place `N` queens on an `N × N` chessboard so that no two queens threaten each other. The constraints are:

1. **Column Constraint**: No two queens should be in the same column.
2. **Row Constraint**: Each row must have exactly one queen (handled by row-wise placement).
3. **Upper Diagonal Constraint**: No two queens should be on the same upper diagonal (↖ direction).
4. **Lower Diagonal Constraint**: No two queens should be on the same lower diagonal (↙ direction).

### How Constraints are Maintained:
- **Column Check**: We maintain an array `leftRow[n]` where `leftRow[col] = 1` means the column is occupied.
- **Upper Diagonal Check**: The index for an upper diagonal is calculated as `row + col`. We maintain an array `upperDiagonal[2 * n - 1]`.
- **Lower Diagonal Check**: The index for a lower diagonal is `n - 1 + col - row`. We maintain an array `lowerDiagonal[2 * n - 1]`.

## Solving with Backtracking (N = 4 Example)
### Step-by-Step Execution

### Step 1: Start at row 0
- Try placing at `(0,0)`, `(0,1)`, `(0,2)`, `(0,3)`. Choose `(0,1)`.

Board after placing `Q` at `(0,1)`:  
```
. Q . .
. . . .
. . . .
. . . .
```

### Step 2: Move to row 1
- Try `(1,0)`, `(1,1)`, `(1,2)`, `(1,3)`. Only `(1,3)` is safe.

Board:
```
. Q . .
. . . Q
. . . .
. . . .
```

### Step 3: Move to row 2
- Try `(2,0)`, `(2,1)`, `(2,2)`, `(2,3)`. Only `(2,0)` is safe.

Board:
```
. Q . .
. . . Q
Q . . .
. . . .
```

### Step 4: Move to row 3
- Try `(3,0)`, `(3,1)`, `(3,2)`, `(3,3)`. Only `(3,2)` is safe.

Final Board:
```
. Q . .
. . . Q
Q . . .
. . Q .
```

### Step 5: Backtracking to explore more solutions
- Backtrack from `(3,2)`, try other placements.
- No more valid placements in row 3, backtrack to row 2.
- Remove `(2,0)`, try next possible placement.
- New placement `(2,2)`.

Board:
```
. Q . .
. . . Q
. . Q .
. . . .
```

- Move to row 3, only `(3,0)` is safe.

Final Board:
```
. Q . .
. . . Q
. . Q .
Q . . .
```

---

## Optimized Branch & Bound Approach
Instead of checking all constraints repeatedly, we maintain three arrays:
- `leftRow[n]` → Keeps track of used columns.
- `upperDiagonal[2*n-1]` → Tracks upper diagonals.
- `lowerDiagonal[2*n-1]` → Tracks lower diagonals.

This reduces time complexity to `O(N!)`.

For N=4, using this method, the first solution follows the same path as above but with direct lookups reducing recursive calls.

---

This explanation details the correct execution with backtracking and optimized methods. Let me know if you need further refinements! 🚀


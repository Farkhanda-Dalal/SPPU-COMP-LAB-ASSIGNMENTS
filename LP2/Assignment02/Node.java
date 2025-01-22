public class Node{
    Node parent;
    int[][] mat;
    int g; // cost to reach this node
    int h; // heuristic cost
    int x, y; // coordinates of the blank tile

    public Node(int[][] mat, int x, int y, int g, Node parent) {
        this.parent = parent;
        this.mat = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, this.mat[i], 0, mat[i].length);
        }
        this.g = g;
        this.h = Integer.MAX_VALUE;
        this.x = x;
        this.y = y;
    }
}

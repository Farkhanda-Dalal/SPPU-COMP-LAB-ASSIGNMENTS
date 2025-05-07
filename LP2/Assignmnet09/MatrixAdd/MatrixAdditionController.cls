public class MatrixAdditionController {
    public String matrix1 { get; set; }
    public String matrix2 { get; set; }
    public String result { get; set; }

    public MatrixAdditionController() {
        matrix1 = '';
        matrix2 = '';
        result = '';
    }

    public void addMatrices() {
        try {
            List<List<Integer>> m1 = parseMatrix(matrix1);
            List<List<Integer>> m2 = parseMatrix(matrix2);

            if (m1.size() != m2.size() || m1[0].size() != m2[0].size()) {
                result = 'Error: Matrices must have the same dimensions.';
                return;
            }

            List<List<Integer>> resMatrix = new List<List<Integer>>();

            for (Integer i = 0; i < m1.size(); i++) {
                List<Integer> row = new List<Integer>();
                for (Integer j = 0; j < m1[i].size(); j++) {
                    row.add(m1[i][j] + m2[i][j]);
                }
                resMatrix.add(row);
            }

            // Convert result matrix to a displayable string
            List<String> resultRows = new List<String>();
            for (List<Integer> row : resMatrix) {
                resultRows.add(String.join(row, ', '));
            }

            result = String.join(resultRows, '\n');
        } catch (Exception e) {
            result = 'Error: Invalid input. Use comma for columns, semicolon for rows.';
        }
    }

    private List<List<Integer>> parseMatrix(String input) {
        List<List<Integer>> matrix = new List<List<Integer>>();
        List<String> rows = input.split(';');
        for (String row : rows) {
            List<Integer> intRow = new List<Integer>();
            for (String val : row.split(',')) {
                intRow.add(Integer.valueOf(val.trim()));
            }
            matrix.add(intRow);
        }
        return matrix;
    }
}

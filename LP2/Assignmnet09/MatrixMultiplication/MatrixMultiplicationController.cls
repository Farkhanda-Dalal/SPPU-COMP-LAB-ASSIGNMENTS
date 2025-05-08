public class MatrixMultiplicationController {
    public Integer rowsA { get; set; }
    public Integer colsA { get; set; }
    public Integer rowsB { get; set; }
    public Integer colsB { get; set; }
    
    public List<List<Decimal>> matrixA { get; set; }
    public List<List<Decimal>> matrixB { get; set; }
    public List<List<Decimal>> resultMatrix { get; set; }
    public String errorMessage { get; set; }

    public MatrixMultiplicationController() {
        rowsA = 2;
        colsA = 2;
        rowsB = 2;
        colsB = 2;
        initializeMatrices();
    }

    public void initializeMatrices() {
        matrixA = new List<List<Decimal>>();
        matrixB = new List<List<Decimal>>();
        resultMatrix = new List<List<Decimal>>();
        errorMessage = '';

        for (Integer i = 0; i < rowsA; i++) {
            List<Decimal> row = new List<Decimal>();
            for (Integer j = 0; j < colsA; j++) {
                row.add(0);
            }
            matrixA.add(row);
        }

        for (Integer i = 0; i < rowsB; i++) {
            List<Decimal> row = new List<Decimal>();
            for (Integer j = 0; j < colsB; j++) {
                row.add(0);
            }
            matrixB.add(row);
        }
    }

    public void multiplyMatrices() {
        resultMatrix.clear();
        errorMessage = '';

        if (colsA != rowsB) {
            errorMessage = 'Matrix A\'s columns must equal Matrix B\'s rows for multiplication.';
            return;
        }

        for (Integer i = 0; i < rowsA; i++) {
            List<Decimal> resultRow = new List<Decimal>();
            for (Integer j = 0; j < colsB; j++) {
                Decimal sum = 0;
                for (Integer k = 0; k < colsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                resultRow.add(sum);
            }
            resultMatrix.add(resultRow);
        }
    }
}

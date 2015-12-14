import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by HP on 04.12.2015.
 */
public class GaussNewtonDecomposition {

    private Matrix matrixL;
    private Matrix matrixU;
    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix matrixY;
    private Matrix matrixX;

    public Matrix getMatrixB() {
        return matrixB;
    }

    public Matrix getMatrixY() {
        return matrixY;
    }

    public Matrix getMatrixX() {
        return matrixX;
    }

    public Matrix getMatrixL() {
        return matrixL;
    }

    public Matrix getMatrixU() {
        return matrixU;
    }

    public Matrix getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(Matrix matrixA) {
        this.matrixA = matrixA;
    }

    public GaussNewtonDecomposition() {
        LUDecomposition();
        Ly();
        Ux();
    }

    /**
     * Rozkad macierzy A na LU przy pomocy metody elyminacji Gaussa.
     */
    public void LUDecomposition() {
        matrixA = new Matrix("InputMatrix/A.txt");
        matrixU = new Matrix("InputMatrix/A.txt");
        matrixL = new Matrix("InputMatrix/AA.txt");

        for (int t = 0; t < matrixA.getRowMax(); t++)
            matrixL.setElement(t, t, 1.0);

        int k, i, j;
        double l, u;
        for (k = 0; k < matrixA.getRowMax() - 1; k++) {
            for (i = k + 1; i < matrixA.getRowMax(); i++) {
                for (j = matrixA.getRowMax() - 1; j >= k; j--) {

                    l = matrixU.getElement(i, k) / matrixU.getElement(k, k);
                    if (l < 1.0E-15)
                        l = 0;
                    matrixL.setElement(i, k, l);

                    u = (matrixU.getElement(i, j) - matrixU.getElement(i, k) * matrixU.getElement(k, j) / matrixU.getElement(k, k));
                    if (u < 1.0E-15)
                        u = 0.0;
                    matrixU.setElement(i, j, u);
                }
            }
        }
        try {
            writeMatrix("MatrixResults\\matrixL.txt", matrixL);
            writeMatrix("MatrixResults\\matrixU.txt", matrixU);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Nie naleziono pliku: matrixL.txt lub matrixU.txt");
        }
    }

    /**
     * Obliczenie wektora Y;
     */
    public void Ly() {
        matrixY = new Matrix("InputMatrix/bb.txt");
        matrixB = new Matrix("InputMatrix/b.txt");
        double sum;

        for (int i = 0; i < matrixY.getRowMax(); i++) {
            sum = 0.0;
            for (int j = 0; j < i; j++) {
                sum = sum + matrixL.getElement(i, j) * matrixY.getElement(j, 0);
            }
            matrixY.setElement(i, 0, matrixB.getElement(i, 0) - sum);
        }
        try {
            writeMatrix("MatrixResults\\matrixY.txt", matrixY);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Nie naleziono pliku: matrixY.txt");
        }
    }

    /**
     * Obliczenie wektora X.
     */
    public void Ux() {
        matrixX = new Matrix("InputMatrix/bb.txt");
        double sum;

        for (int i = matrixX.getRowMax() - 1; i >= 0; i--) {
            sum = 0.0;
            for (int j = i + 1; j < matrixX.getRowMax(); j++) {
                sum = sum + matrixU.getElement(i, j) * matrixX.getElement(j, 0);
            }
            matrixX.setElement(i, 0, (matrixY.getElement(i, 0) - sum) / matrixU.getElement(i, i));
        }
        try {
            writeMatrix("MatrixResults\\matrixX.txt", matrixX);
        } catch (FileNotFoundException fnfe) {
            System.err.println("Nie naleziono pliku: matrixL.txt lub matrixU.txt");
        }
    }

    /**
     * Zapis macierzy do pliku.
     *
     * @param filename nazwa pliku
     * @param matrix   macierz którą chcemy zapisać.
     * @throws FileNotFoundException błąd w razie nie odnalezienia pliku.
     */
    private void writeMatrix(String filename, Matrix matrix) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(filename);
        for (int i = 0; i < matrix.getRowMax(); i++) {
            for (int j = 0; j < matrix.getColMax(); j++)
                printWriter.print(" " + matrix.getElement(i, j));
            printWriter.println();
        }
        printWriter.close();
    }
}

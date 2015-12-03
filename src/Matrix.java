import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by HP on 07.11.2015.
 */
public class Matrix {
    private Vector[] vector;
    private int rowMax;
    private int colMax;

    public Matrix(int rowSize){
        vector = new Vector[rowSize];
    }

    public Matrix(String vectorName){
        vector = Vector.readMatrix(vectorName);
        readColAndRow(vectorName);
    }

    public int getColMax() {
        return colMax;
    }

    public int getRowMax() {
        return rowMax;
    }

    public Vector[] getVector() {
        return vector;
    }

    /**
     * Metoda czyta z pliku liczbę kolumn i rzędów macierzy.
     * @param fileName ścieżka do pliku
     */
    void readColAndRow(String fileName){
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            rowMax = scanner.nextInt();
            colMax = scanner.nextInt();
        }catch (FileNotFoundException fnfe){
            System.err.println("Nie znaleziono pliku");
            System.exit(0);
        }
    }

    /**
     * Metoda pobiera wartość z wektora
     * @param row nr rzędu
     * @param col nr kolumny
     * @return wartość
     */
    public double getElement(int row, int col){
        double tmp = 0;
        try {
            tmp = this.vector[row].getTree().serach(vector[row].getTree().getRoot(), col);
        }catch (NullPointerException npe){
            System.out.print("");
        }catch (ArrayIndexOutOfBoundsException aiaobe){
            System.err.println("Podano element ("+row +","+col+") z macierzy ("+rowMax+","+colMax+")");
            System.exit(0);
        }
        return tmp;
    }

    /**
     * Metoda ustawia nową wartość we wskazanym miejscu w wektorze
     * @param row nr rzędu
     * @param col nr kolumny
     * @param value nowa wartość
     */
    public void setElement(int row, int col, double value) {
        vector[row] = new Vector();
        vector[row].getTree().insert(vector[row].getTree().getRoot(),col,value);
        }

    /**
     * Czyta z pliku i wypisuje na wyjście macierz.
     * @param fileName ścieżka do pliku
     */
    public void readMatrix(String fileName){
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(Integer.parseInt(scanner.next())+" "+ Integer.parseInt(scanner.next()));
            while (scanner.hasNext()){
                System.out.println(Integer.parseInt(scanner.next())+" "+ Integer.parseInt(scanner.next())+ " "+ Double.parseDouble(scanner.next()));
            }
        }catch (FileNotFoundException fnfe){
            System.err.println("Nie znaleziono pliku");
        }
    }

    /**
     * Metoda dodająca do siebie dwie macierze
     * @param matrix macierz B
     * @return wynik dodawania macierzy
     */
     public Matrix add(Matrix matrix){
         if(matrix.rowMax != this.rowMax){
             System.err.println("Dodawanie niemożliwe, różna długość macierzy");
             System.exit(0);
         }
        Matrix matrix3 = new Matrix(rowMax);
        for (int i = 0; i < rowMax; i++){
            for (int j = 0; j<colMax;j++){
                double tmp = matrix.getElement(i,j) + this.getElement(i,j);
                System.out.print(" "+tmp);
                if(tmp != 0) {
                    matrix3.setElement(i, j, tmp);
                }
            }
            System.out.println();
        }
        return matrix3;
    }

    /**
     * Metoda mnożąca dwie macierze przez siebie.
     * @param matrix macierz B
     * @return wynik mnożenia macierzy
     */
    public Matrix multiply(Matrix matrix){
        if((matrix.rowMax != this.colMax) || (this.rowMax != matrix.colMax)){
            System.err.println("Mnożenie niemożliwe, niewłaściwa długość macierzy");
            System.exit(0);
        }
        Matrix matrix3 = new Matrix(rowMax);
        double tmp = 0;

        for(int k = 0; k <rowMax;k++) {
            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < colMax; j++) {
                    tmp = tmp + (matrix.getElement(k, j) * this.getElement(j, i));
                }
                System.out.print(" "+tmp);
                if(tmp !=0) {
                    matrix3.setElement(k, i, tmp);
                }
                tmp = 0;
            }
            System.out.println();
        }
        return matrix3;
    }

}

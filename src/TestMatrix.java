/**
 * Created by HP on 08.11.2015.
 */
public class TestMatrix {
    public static void main(String[] args) {

        Matrix matrixA = new Matrix("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\GaussDecomposition\\src/A.txt");
        Matrix matrixB = new Matrix("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\GaussDecomposition\\src/B.txt");
        Matrix matrixC = null;

        System.out.println("Stara wartość "+matrixA.getElement(5, 5));
        matrixA.setElement(5, 5, 9.9);
        System.out.println("Nowa wartość "+matrixA.getElement(5, 5));

    }

}

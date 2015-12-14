/**
 * Created by HP on 08.11.2015.
 */
public class TestMatrix {
    public static void main(String[] args) {

        Matrix matrixA = new Matrix("InputMatrix/b.txt");
        Matrix matrixB = new Matrix("InputMatrix/b.txt");
        Matrix matrixC = null;

//        System.out.println("Stara wartość "+matrixA.getElement(2, 2));
//        matrixA.setElement(1, 1, 9.9);
//        System.out.println("Nowa wartość "+matrixA.getElement(2, 2));

//        System.out.println(matrixB.getElement(1,1));
//
//        matrixA.print();
//          System.out.println(matrixA.getElement(0,0)/matrixA.getElement(0,1));
//        matrixA.add(matrixA);

        matrixA.print();
    }

}

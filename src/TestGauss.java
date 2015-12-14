/**
 * Created by HP on 06.12.2015.
 */
public class TestGauss {
    public static void main(String[] args) {
        GaussNewtonDecomposition and = new GaussNewtonDecomposition();

        System.out.println("A=");
        and.getMatrixA().print();

        System.out.println("B=");
        and.getMatrixB().print();

        System.out.println("U=");
        and.getMatrixU().print();

        System.out.println("L=");
        and.getMatrixL().print();

        System.out.println("Y=");
        and.getMatrixY().print();

        System.out.println("X=");
        and.getMatrixX().print();

    }
}

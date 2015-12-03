/**
 * Created by HP on 07.11.2015.
 */
public class TestVector {


    public static void main(String[] args) {
        Vector[] vector = Vector.readMatrix("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\GaussDecomposition\\src/123.txt");

        for (int i = 0; i < 10; i++) {
//            vector[i].getTree().get(vector[i].getTree().getRoot());

            try {
                System.out.print("kolumna: "+i+" ");
                vector[i].getTree().get(vector[i].getTree().getRoot());
            } catch (NullPointerException npe) {

            }
            System.out.println();
        }

    }
}

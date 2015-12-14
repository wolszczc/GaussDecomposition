/**
 * Created by HP on 07.11.2015.
 */
public class TestVector {


    public static void main(String[] args) {
        Vector[] vector = Vector.readMatrix("C:\\Users\\HP\\Desktop\\Programowanie\\Inteljji\\GaussDecomposition\\src/A.txt");

        for (int i = 0; i < 3; i++) {
//            vector[i].getTree().get(vector[i].getTree().getRoot());

            try {
               // System.out.print("kolumna: "+i+" ");
                vector[i].getTree().get(vector[i].getTree().getRoot());
                System.out.println(vector[i].getTree().serach(vector[i].getTree().getRoot(),i ));
            } catch (NullPointerException npe) {

            } catch (ArrayIndexOutOfBoundsException aiaobe){

            }
            System.out.println();
        }

    }
}

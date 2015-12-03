import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by HP on 07.11.2015.
 */
public class Vector {

    private Tree tree = null;

    public Vector(){
        tree = new Tree();
    }

    public Tree getTree() {
        return tree;
    }

    /**
     * Metoda czytająca wartości macierzy z pliku.
     * @param fileName ścieżka do pliku
     * @return tablice wartość
     */
    public static Vector[] readMatrix(String fileName){
        Vector[] vector = null;
        File file = new File(fileName);
        int rowMax = 0;
        int columnMax = 0;
        int a = 0;

        try{
            Scanner scanner = new Scanner(file);
            rowMax = scanner.nextInt();
            columnMax = scanner.nextInt();
            vector = new Vector[rowMax];
            while(scanner.hasNext()){
                a = Integer.parseInt(scanner.next());
                try {
                    vector[a].getTree().getRoot();
                }catch (NullPointerException npe){
                    vector[a] = new Vector();
                }
                vector[a].tree.insert(vector[a].getTree().getRoot(), Integer.parseInt(scanner.next()), Double.parseDouble(scanner.next()));
            }
        }catch(FileNotFoundException fnfe){
            System.err.println("Nie znaleziono pliku");
            System.exit(0);
        }catch (ArrayIndexOutOfBoundsException aiaobe){
            System.err.println("Element spoza zakresu: "+rowMax+" < "+a  );
            System.exit(0);
        }
        return vector;
    }

    /**
     * Metoda dodająca wartość do drzewa we wskazanym wektorze.
     * @param index nr indeksu
     * @param value vartość
     * @return wektor
     */
    public Vector addToVector(int index , double value){
        Vector vector = new Vector();
        vector.tree.insert(vector.tree.getRoot(),index,value);
        return vector;
    }
}

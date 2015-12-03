/**
 * Created by HP on 19.10.2015.
 */
public class Tree {

    private Node root;
    private Node parent;

    /**
     * Klasa tworząca węzeł
     */
    public class Node {

        private Node left;
        private Node right;
        private Node parent;
        private Item item;

        public Node(int index, double value){
            item = new Item(index, value);
            left = null;
            right = null;
            parent = null;
        }

        /**
         * Klasa przechowująca wartości i numer indeksu.
         */
        public class Item{

            private double value;
            private int index;
            private int deep;

            public Item(int index, double value){
                this.index = index;
                this.value = value;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }
        }

        public Item getItem() {
            return item;
        }
    }

    public Node getRoot(){
        return root;
    }

    /**
     * Dodawaine wartości do drzewa.
     * @param node wskażnik do węzła.
     * @param index dodawana wartość.
     * @return wskażnik do dziecka node.
     */
    public Node insert(Node node, int index, double value){
        if(root == null) {
            root = new Node(index, value);
            node = root;
            root.item.deep = 1;
        }
        else{
            Node actual = node;
            if(actual != null) {
                parent = actual;
                actual = (actual.item.index > index)? insert(actual.left, index, value) : insert(actual.right, index, value);
            }
            if (parent != null) {
                if (parent.item.index > index) {
                    parent.left = new Node(index, value);
                    parent.left.parent = parent;
                    parent.left.item.deep = parent.item.deep + 1;
                } else if (parent.item.index < index) {
                    parent.right = new Node(index, value);
                    parent.right.parent = parent;
                    parent.right.item.deep = parent.item.deep + 1;
                }
            }
        }
        return node;
    }


    /**
     * Metoda szuka podanej wartości w drzewie.
     * @param index szukany index.
     * @return wskażnik na strukture.
     */
    private Node serachNode(Node node, int index){
        if(node != null && node.item.index != index)
            node = (node.item.value > index)? serachNode(node.left, index) : serachNode(node.right, index);
        else if(node != null && node.item.index == index)
            return node;
        else if(node == null) {
//            System.out.println("Nie znaleziono podanej wartości");
            return null;
        }
        return node;
    }

    /**
     * Metoda szuka podanej warrości w drzewe.
     * @param node wskażnik na strukturę.
     * @param index szukany index.
     * @return wartość w podanym indekise.
     */
    public double serach(Node node, int index){
        Node tmp = serachNode(node, index);
        if(tmp != null)
            return tmp.item.value;
        else
            return 0.0;
    }

    /**
     * Metoda drukuje wartości z drzewa.
     * @param node korzeń drzewa.
     */
    public void get(Node node){
        if(node != null){
            get(node.left);
            System.out.println("Wartość: "+node.item.value+"  rząd: "+node.item.index + "  głębokość: " +node.item.deep);
            get(node.right);
        }
    }

}

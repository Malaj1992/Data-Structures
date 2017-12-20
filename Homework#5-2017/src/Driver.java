// created by Angjelin Malaj, 05/01/2017
import java.util.Vector;

public class Driver implements DriverInterface{
    Vector<TreeItem<Integer, String>> kv;
    @Override
    public Vector<TreeItem<Integer, String>> getVectorOfTreeItems() {

        TreeItem<String, Integer> c = null;

        kv = new Vector <TreeItem<Integer,String>>();
        for (int i = 0; i< 131071; i++){
            int a = (int) ((int)i+10 * (Math.round(Math.random() * 1000)));
            kv.add(new TreeItem<Integer, String>(a, "String "+a));

        }

        return kv;
    }

    @Override
    public BinarySearchTree<Integer, String> createAndPopulateBST(Vector<TreeItem<Integer, String>> treeItems) {
        BinarySearchTree<Integer, String> ca = new BinarySearchTree<>();
        for(int i = 0; i< treeItems.size();i++){
            ca.insert(treeItems.elementAt(i));

        }

        return ca;
    }
    public static void main(String [] args){

        Driver driver = new Driver();
        Vector<TreeItem<Integer,String>> v;
        v = driver.getVectorOfTreeItems();
        BinarySearchTree<Integer,String> bst = driver.createAndPopulateBST(v);
        System.out.println(bst.isBalanced());

    }
}


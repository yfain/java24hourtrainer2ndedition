import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class TestVariousCollections {

    /**
     * @param args
     */
    public static void main(String[] args) {

        HashSet sss = new HashSet();
        sss.add("Mary");
        sss.add("Mary");

        ArrayList aaa = new ArrayList();

        aaa.add("Mary");
        aaa.add("Mary");

        Vector bbb = new Vector();

        Map map = new HashMap();
        map.put("customer", new Customer("John", "Smith"));
        map.put("order", new Order());

    }

}

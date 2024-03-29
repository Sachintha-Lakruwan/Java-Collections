import java.util.TreeMap;
import java.util.Random;

public class TreeMapTest {
    public static void main(String[] args){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++){
            String value = "value" + i;
            treeMap.put(i, value );
        }

        long addTime = 0;
        long checkingTime = 0;
        long removingTime = 0;
        long clearingTime = 0;

        for (int i = 100000; i < 100100; i++){
            long start = System.nanoTime();
            treeMap.put(i, "value" );
            long end = System.nanoTime();
            addTime += (end - start);
        }

        for (int i = 0; i < 100; i++){
            String value = "value" + (random.nextInt(99999)+50000);
            long start = System.nanoTime();
            boolean a = treeMap.containsValue(value);
            long end = System.nanoTime();
            checkingTime += (end - start);
        }

        for (int i = 0; i < 100; i++){
            Integer value = random.nextInt(99999)+50000;
            long start = System.nanoTime();
            treeMap.remove(value);
            long end = System.nanoTime();
            removingTime += (end - start);
        }

        for (int i = 0; i < 100; i++){
            long start = System.nanoTime();
            treeMap.clear();
            long end = System.nanoTime();
            clearingTime += (end - start);

            for (int j = 0; j < 100000; j++){
                String value = "value" + j;
                treeMap.put(j, value );
            }
        }

        System.out.println("Add an element -> "+ addTime/100 + " nanoseconds");
        System.out.println("Find an element -> "+ checkingTime/100 + " nanoseconds");
        System.out.println("Remove an element -> "+ removingTime/100 + " nanoseconds");
        System.out.println("Clear all the elements -> "+ clearingTime/100 + " nanoseconds");
    }
}

import utils.CacheableUtils;
import utils.api.CacheableMap;

/**
 * подумал, сделал за 1.5 часа, тесты не успел
 */

public class EntryPoint {
    public static void main(final String[] args) {
        for (final String strategy : new String[]{"LRU", "LFU"}) {

            final CacheableMap map = CacheableUtils.getMapByMaxLengthAndStrategy(666, strategy);

            if (map != null) {
                for (int i = 0; i < 13000; i++) {
                    map.add(i, i * i);
                }

                for (int i = 0; i < 13000; i++) {
                    map.add(i, i * i);
                }

                for (int i = 0; i < 13000; i++) {
                    map.add(i, i * i);
                }

                System.out.println("Strategy = " + map.getType().getDescription());
                //Null потому что LRU
                System.out.println("Result = " + map.get(13) + "\n");
                //Not Null потому что LRU
                System.out.println("Result = " + map.get(12999) + "\n");
            }
        }
    }
}

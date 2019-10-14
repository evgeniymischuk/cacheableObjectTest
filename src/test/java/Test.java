import utils.CacheUtils;
import utils.api.CacheMap;
import utils.enums.StrategyType;

public class Test {

    public static void main(final String[] args) {
        final StrategyType[] types = new StrategyType[]{StrategyType.LRU, StrategyType.LFU};
        for (final StrategyType t : types) {

            final CacheMap<Integer, Integer> map = CacheUtils.getMapByMaxLengthAndStrategy(1000, t);

            for (int i = 0; i < 1000; i++) {
                map.add(i, i);
                map.get(i);
                map.get(i);
                map.get(i);
                map.get(i);
                map.get(i);
            }

            for (int i = 0; i < 100; i++) {
                map.add(i, i);
            }

            System.out.println("Strategy = " + map.getType());
            // in LFU display, in LRU not
            System.out.println("Result = " + (map.get(6) != null) + "\n");
        }
    }


}

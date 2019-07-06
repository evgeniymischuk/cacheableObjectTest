import utils.CacheableUtils;
import utils.api.CacheableMap;
import utils.enums.StrategyType;

public class CacheableMain {
    public static void main(final String[] args) {
        final StrategyType[] types = new StrategyType[]{StrategyType.LFU, StrategyType.LRU};
        for (final StrategyType t : types) {

            final CacheableMap map = CacheableUtils.getMapByMaxLengthAndStrategy(666, t);

            for (int i = 0; i < 666; i++) {
                map.add(i, i);
                map.get(i);
                map.get(i);
                map.get(i);
                map.get(i);
                map.get(i);
            }
            for (int i = 0; i < 666_666; i++) {
                map.add(i, i);
            }
            System.out.println("Strategy = " + map.getType());
            // in LFU display, in LRU not
            System.out.println("Result = " + (map.get(6) != null) + "\n");
        }
    }
}
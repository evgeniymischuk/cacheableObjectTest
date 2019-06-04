package utils;

import utils.api.CacheableMap;
import utils.enums.StrategyType;
import utils.strategies.LeastFrequentlyUsedStrategy;
import utils.strategies.LeastRecentlyUsedStrategy;

public class CacheableUtils {

    public static CacheableMap getMapByMaxLengthAndStrategy(final int maxLength, final String name) {

        if (name != null && !name.isBlank()) {
            if (name.equals(StrategyType.LFU.name()) || name.equals(StrategyType.LFU.getDescription())) {
                return new LeastFrequentlyUsedStrategy(maxLength);
            } else if (name.equals(StrategyType.LRU.name()) || name.equals(StrategyType.LRU.getDescription())) {
                return new LeastRecentlyUsedStrategy(maxLength);
            }
        }

        return null;
    }

    public static CacheableMap getMapByMaxLengthAndStrategy(final int maxLength, final StrategyType type) {

        if (type != null) {
            if (type == StrategyType.LFU) {
                return new LeastFrequentlyUsedStrategy(maxLength);
            } else if (type == StrategyType.LRU) {
                return new LeastRecentlyUsedStrategy(maxLength);
            }
        }

        return null;
    }
}
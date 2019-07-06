package utils;

import utils.api.CacheableMap;
import utils.enums.StrategyType;
import utils.strategies.EmptyStrategy;
import utils.strategies.LeastFrequentlyUsedStrategy;
import utils.strategies.LeastRecentlyUsedStrategy;

public class CacheableUtils {

    public static CacheableMap getMapByMaxLengthAndStrategy(final int maxLength, final StrategyType type) {

        if (maxLength > 0 && type != null) {
            switch (type) {
                case LFU:
                    return new LeastFrequentlyUsedStrategy(maxLength);
                case LRU:
                    return new LeastRecentlyUsedStrategy(maxLength);
            }
        }

        return new EmptyStrategy();
    }
}
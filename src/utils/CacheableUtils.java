package utils;

import utils.api.CacheableMap;
import utils.enums.StrategyType;
import utils.strategies.EmptyMap;
import utils.strategies.LFUMap;
import utils.strategies.LRUMap;

public class CacheableUtils {

    public static CacheableMap getMapByMaxLengthAndStrategy(final int maxLength, final StrategyType type) {

        if (maxLength > 0 && type != null) {
            switch (type) {
                case LFU:
                    return new LFUMap(maxLength);
                case LRU:
                    return new LRUMap(maxLength);
            }
        }

        return new EmptyMap();
    }
}
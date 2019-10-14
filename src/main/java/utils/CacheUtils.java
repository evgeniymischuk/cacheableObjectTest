package utils;

import utils.api.CacheMap;
import utils.enums.StrategyType;
import utils.strategies.EmptyMap;
import utils.strategies.LFUMap;
import utils.strategies.LRUMap;

public class CacheUtils {

    public static <K, V> CacheMap<K, V> getMapByMaxLengthAndStrategy(
            final int maxLength,
            final StrategyType type
    ) {
        CacheMap<K, V> cacheMap;

        if (maxLength > 0 && type != null) {
            switch (type) {
                case LFU:
                    cacheMap = new LFUMap<>(maxLength);
                    break;
                case LRU:
                    cacheMap = new LRUMap<>(maxLength);
                    break;
                default:
                    cacheMap = new EmptyMap<>();
                    break;
            }
        } else {
            cacheMap = new EmptyMap<>();
        }

        return cacheMap;
    }
}
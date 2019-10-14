package utils.api;

import utils.enums.StrategyType;

public interface CacheMap<K, V> {

    V get(K key);

    boolean add(K key, V value);

    int getMaxSize();

    StrategyType getType();
}

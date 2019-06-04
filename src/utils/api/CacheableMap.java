package utils.api;

import utils.enums.StrategyType;

public interface CacheableMap<K, V> {

    V get(K key);

    boolean add(K key, V value);

    boolean replaceIrrelevantObjectByStrategy(K key, V value);

    void afterFoundActionByStrategy(CacheableObject o);

    int getMaxSize();

    StrategyType getType();
}

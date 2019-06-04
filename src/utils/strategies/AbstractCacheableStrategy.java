package utils.strategies;

import utils.api.CacheableMap;
import utils.api.CacheableObject;
import utils.custom.LfuCacheableObjectImpl;
import utils.enums.StrategyType;


public abstract class AbstractCacheableStrategy<K, V> implements CacheableMap<K, V> {

    private final int maxSize;
    private final StrategyType type;
    protected CacheableObject<K, V>[] objects;
    protected int seqNum;

    protected AbstractCacheableStrategy(final int maxSize, final StrategyType type) {
        this.maxSize = maxSize;
        this.type = type;
    }

    public final int getMaxSize() {
        return maxSize;
    }

    public final StrategyType getType() {
        return type;
    }

    public V get(K key) {
        for (CacheableObject o : objects) {
            if (o != null && o.getHashKey() == key.hashCode()) {
                //for example
                System.out.println("key = " + o.getKey() + "\nInvokeCount = " + o.getInvokeCount());
                //
                afterFoundActionByStrategy(o);
                return (V) o.getValue();
            }
        }
        return null;
    }

    public boolean add(final K key, final V value) {
        if (seqNum >= getMaxSize()) {
            return replaceIrrelevantObjectByStrategy(key, value);
        } else {
            for (final CacheableObject o : objects) {
                if (o != null && o.getHashKey() == key.hashCode()) {
                    o.setValue(value);

                    return true;
                }
            }
            objects[seqNum] = new LfuCacheableObjectImpl<>(key, value, seqNum++);
        }

        return true;
    }
}
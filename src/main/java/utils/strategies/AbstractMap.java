package utils.strategies;

import utils.api.CacheMap;
import utils.api.CacheObject;
import utils.custom.CacheObjectImpl;
import utils.enums.StrategyType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class AbstractMap<K, V> implements CacheMap<K, V> {

    private final int maxSize;
    private final StrategyType type;
    private List<CacheObject<K, V>> objects;
    private int countInsert = 0;

    protected AbstractMap(final int maxSize, final StrategyType type) {
        this.maxSize = maxSize;
        this.type = type;
        this.objects = new ArrayList<>(maxSize);
    }

    public final int getMaxSize() {
        return maxSize;
    }

    public final StrategyType getType() {
        return type;
    }

    public V get(K key) {
        for (CacheObject<K, V> o : objects) {
            if (o != null && o.getHashKey() == key.hashCode()) {
                afterFoundGetActionByStrategy(o);
                return o.getValue();
            }
        }
        return null;
    }

    public boolean add(final K key, final V value) {
        if (countInsert >= getMaxSize()) {
            return replaceIrrelevantObjectByStrategy(key, value);
        } else {
            for (final CacheObject<K, V> o : objects) {
                if (o != null && o.getHashKey() == key.hashCode()) {
                    afterFoundAddActionByStrategy(o, value);
                    return true;
                }
            }
            objects.add(new CacheObjectImpl<>(key, value, new Date().getTime()));
            countInsert++;
        }

        return true;
    }

    public List<CacheObject<K, V>> getObjects() {
        return objects;
    }

    protected abstract void afterFoundGetActionByStrategy(final CacheObject o);

    protected void afterFoundAddActionByStrategy(final CacheObject<K, V> o, V newValue) {
        o.setValue(newValue);
    }

    protected abstract boolean replaceIrrelevantObjectByStrategy(final K key, final V value);
}

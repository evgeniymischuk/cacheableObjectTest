package utils.strategies;

import utils.api.CacheObject;
import utils.enums.StrategyType;

import java.util.Date;

public class LRUMap<K, V> extends AbstractMap<K, V> {

    public LRUMap(final int maxSize) {
        super(maxSize, StrategyType.LRU);
    }

    @Override
    public boolean replaceIrrelevantObjectByStrategy(final K key, final V value) {
        CacheObject<K, V> replaceObject = getObjects().get(0);

        for (final CacheObject<K, V> o : getObjects()) {
            if (o.getTimeInvoke() < replaceObject.getTimeInvoke()) {
                replaceObject = o;
            }
        }

        replaceObject.setKey(key);
        replaceObject.setValue(value);

        return true;
    }

    @Override
    protected void afterFoundGetActionByStrategy(final CacheObject o) {
        o.setTimeInvoke(new Date().getTime());
    }
}

package utils.strategies;

import utils.api.CacheObject;
import utils.enums.StrategyType;

public class LFUMap<K, V> extends AbstractMap<K, V> {

    public LFUMap(final int maxSize) {
        super(maxSize, StrategyType.LFU);
    }

    @Override
    public boolean replaceIrrelevantObjectByStrategy(final K key, final V value) {
        CacheObject<K, V> replaceObject = getObjects().get(0);

        for (final CacheObject<K, V> o : getObjects()) {
            if (o.getInvokeCount() < replaceObject.getInvokeCount()) {
                replaceObject = o;
            }
        }

        replaceObject.setKey(key);
        replaceObject.setValue(value);

        return true;
    }

    @Override
    public void afterFoundGetActionByStrategy(final CacheObject o) {
        o.incrementInvoke();
    }
}

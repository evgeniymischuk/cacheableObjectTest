package utils.strategies;

import utils.api.CacheableObject;
import utils.custom.CacheableObjectImpl;
import utils.enums.StrategyType;

public class LFUMap<K, V> extends AbstractMap<K, V> {

    public LFUMap(final int maxSize) {
        super(maxSize, StrategyType.LFU);
        this.objects = new CacheableObjectImpl[maxSize];
    }

    @Override
    public boolean replaceIrrelevantObjectByStrategy(final K key, final V value) {
        CacheableObject minObjectUsed = objects[0];
        int minInvokeCount = minObjectUsed.getInvokeCount();

        for (final CacheableObject o : objects) {
            final int objectCount = o.getInvokeCount();

            if (objectCount < minInvokeCount) {
                minInvokeCount = objectCount;
                minObjectUsed = o;
            }
        }

        minObjectUsed.setKey(key);
        minObjectUsed.setValue(value);
        minObjectUsed.setSeqNum(seqNum++);

        return true;
    }

    @Override
    public void afterFoundActionByStrategy(final CacheableObject o) {
        o.incrementInvoke();
    }
}

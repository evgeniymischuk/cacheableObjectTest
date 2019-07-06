package utils.strategies;

import utils.api.CacheableObject;
import utils.custom.CacheableObjectImpl;
import utils.enums.StrategyType;

public class LeastRecentlyUsedStrategy<K, V> extends AbstractCacheableStrategy<K, V> {

    public LeastRecentlyUsedStrategy(final int maxSize) {
        super(maxSize, StrategyType.LRU);
        this.objects = new CacheableObjectImpl[maxSize];
    }

    @Override
    public boolean replaceIrrelevantObjectByStrategy(final K key, final V value) {
        final int firstResult = seqNum - getMaxSize();

        for (final CacheableObject o : objects) {
            if (o.getSeqNum() == firstResult) {
                o.setKey(key);
                o.setValue(value);
                o.setSeqNum(seqNum++);
                return true;
            }
        }

        return false;
    }
}

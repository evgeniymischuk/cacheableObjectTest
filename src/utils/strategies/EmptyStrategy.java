package utils.strategies;

import utils.custom.CacheableObjectImpl;

public class EmptyStrategy<K, V> extends AbstractCacheableStrategy<K, V> {

    public EmptyStrategy() {
        super(0, null);
        this.objects = new CacheableObjectImpl[0];
    }
}

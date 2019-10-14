package utils.strategies;

import utils.api.CacheObject;

public class EmptyMap<K, V> extends AbstractMap<K, V> {

    public EmptyMap() {
        super(0, null);
    }

    @Override
    protected void afterFoundGetActionByStrategy(CacheObject o) {

    }

    @Override
    protected boolean replaceIrrelevantObjectByStrategy(K key, V value) {
        return false;
    }
}

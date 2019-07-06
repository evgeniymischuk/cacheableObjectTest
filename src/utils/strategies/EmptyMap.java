package utils.strategies;

import utils.custom.CacheableObjectImpl;

public class EmptyMap<K, V> extends AbstractMap<K, V> {

    public EmptyMap() {
        super(0, null);
        this.objects = new CacheableObjectImpl[0];
    }
}

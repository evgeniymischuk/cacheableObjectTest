package utils.custom;

public class LfuCacheableObjectImpl<K, V> extends CacheableObjectImpl<K, V> {

    private int invokeCount;

    public LfuCacheableObjectImpl(final K key, final V value, final int seqNum) {
        super(key, value, seqNum);
        this.invokeCount = 1;
    }

    public void incrementInvoke() {
        invokeCount++;
    }

    public int getInvokeCount() {
        return invokeCount;
    }

}

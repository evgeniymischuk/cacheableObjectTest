package utils.custom;

import utils.api.CacheObject;

public class CacheObjectImpl<K, V> implements CacheObject<K, V> {

    private int hashKey;
    private K key;
    private V value;
    private int invokeCount;
    private long timeInvoke;

    public CacheObjectImpl(final K key,
                           final V value,
                           final long timeInvoke
    ) {
        this.hashKey = key.hashCode();
        this.key = key;
        this.value = value;
        this.invokeCount = 1;
        this.timeInvoke = timeInvoke;
    }

    public int getHashKey() {
        return hashKey;
    }

    public void setHashKey(int hashKey) {
        this.hashKey = hashKey;
    }

    public K getKey() {
        return key;
    }

    public void setKey(final K key) {
        this.key = key;
        this.hashKey = key.hashCode();
    }

    public V getValue() {
        return value;
    }

    public void setValue(final V value) {
        this.value = value;
    }

    public void incrementInvoke() {
        invokeCount++;
    }

    public int getInvokeCount() {
        return invokeCount;
    }

    public void setInvokeCount(int invokeCount) {
        this.invokeCount = invokeCount;
    }

    public long getTimeInvoke() {
        return timeInvoke;
    }

    public void setTimeInvoke(long timeInvoke) {
        this.timeInvoke = timeInvoke;
    }
}

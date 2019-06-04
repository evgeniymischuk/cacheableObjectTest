package utils.custom;

import utils.api.CacheableObject;

public class CacheableObjectImpl<K, V> implements CacheableObject<K, V> {

    private int hashKey;
    private K key;
    private V value;
    private int seqNum;

    public CacheableObjectImpl(final K key, final V value, final int seqNum) {
        this.hashKey = key.hashCode();
        this.key = key;
        this.value = value;
        this.seqNum = seqNum;
    }

    public int getHashKey() {
        return hashKey;
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

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(final int seqNum) {
        this.seqNum = seqNum;
    }

    @Override
    public int getInvokeCount() {
        return 0;
    }

    @Override
    public void incrementInvoke() {
        // stub
    }
}

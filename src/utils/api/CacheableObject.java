package utils.api;

public interface CacheableObject<K, V> {
    int getHashKey();

    K getKey();

    void setKey(K key);

    V getValue();

    void setValue(V value);

    int getSeqNum();

    void setSeqNum(int seqNum);

    int getInvokeCount();

    void incrementInvoke();
}

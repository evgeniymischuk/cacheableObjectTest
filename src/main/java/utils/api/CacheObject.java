package utils.api;

public interface CacheObject<K, V> {
    int getHashKey();

    K getKey();

    void setKey(K key);

    V getValue();

    void setValue(V value);

    int getInvokeCount();

    void incrementInvoke();

    long getTimeInvoke();

    void setTimeInvoke(long timeInvoke);
}

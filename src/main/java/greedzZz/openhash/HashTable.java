package greedzZz.openhash;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K, V> {
    private final ArrayList<HashNode<K, V>> bucketArray;
    private final int numBuckets;
    private int size;

    public HashTable() {
        bucketArray = new ArrayList<>();
        numBuckets = 13;
        size = 0;
        for (int i = 0; i < numBuckets; i++) bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public int bucketSize() {
        return numBuckets;
    }

    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) break;
            prev = head;
            head = head.next;
        }
        if (head == null) return null;
        size--;
        if (prev != null) prev.next = head.next;
        else bucketArray.set(bucketIndex, head.next);
        return head.value;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
    }
}

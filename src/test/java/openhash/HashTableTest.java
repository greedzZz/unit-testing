package openhash;

import greedzZz.openhash.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    HashTable<String, Integer> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    void checkAdd() {
        assertEquals(0, hashTable.size());
        hashTable.add("a", 1);
        assertEquals(1, hashTable.size());
        hashTable.add("b", 2);
        assertEquals(2, hashTable.size());
    }

    @Test
    void checkAddUpdate() {
        hashTable.add("a", 1);
        assertEquals(1, hashTable.size());
        hashTable.add("a", 2);
        assertEquals(1, hashTable.size());
    }

    @Test
    void checkRemove() {
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        assertEquals(2, hashTable.size());
        assertEquals(2, hashTable.remove("b"));
        assertEquals(1, hashTable.size());
        assertEquals(1, hashTable.remove("a"));
        assertEquals(0, hashTable.size());
    }

    @Test
    void checkRemoveNull() {
        assertNull(hashTable.remove("a"));
    }

    @Test
    void checkGet() {
        assertNull(hashTable.get("a"));
        hashTable.add("a", 1);
        assertEquals(1, hashTable.get("a"));
    }

    @Test
    void checkGetNull() {
        assertNull(hashTable.get("a"));
    }

    @Test
    void checkGetAfterUpdate() {
        hashTable.add("a", 1);
        assertEquals(1, hashTable.get("a"));
        hashTable.add("a", 2);
        assertEquals(2, hashTable.get("a"));
    }

    @Test
    void checkGetAfterDelete() {
        hashTable.add("a", 1);
        assertEquals(1, hashTable.get("a"));
        hashTable.remove("a");
        assertNull(hashTable.get("a"));
    }

    @Test
    void checkOpenHash() {
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        hashTable.add("d", 4);
        hashTable.add("e", 5);
        hashTable.add("f", 6);
        hashTable.add("g", 7);
        hashTable.add("h", 8);
        hashTable.add("i", 9);
        hashTable.add("j", 10);
        hashTable.add("k", 11);
        hashTable.add("l", 12);
        hashTable.add("m", 13);
        assertEquals(13, hashTable.size());
        assertEquals(13, hashTable.bucketSize());
        hashTable.add("n", 14);
        assertEquals(14, hashTable.size());
        assertEquals(13, hashTable.bucketSize());
    }
}

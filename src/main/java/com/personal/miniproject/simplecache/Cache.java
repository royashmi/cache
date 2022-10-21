package com.personal.miniproject.simplecache;

/**
 * Interface for a simple cache
 * @param <K> Type of the cache key
 * @param <V> Type of the cache value
 */
public interface Cache<K , V> {

  /**
   * Given a key, returns the value from the cache
   */
  V get(K key);

  /**
   * Inserts (or updates) the value associated with a key
   */
  void put(K key, V value);

  /**
   * Deletes a key from the cache
   */
  void del(K key);

  /**
   * Returns the current size of the cache
   */
  long size();
}
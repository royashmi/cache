package com.personal.miniproject.cachelib;

/**
 * An interface for a cache that will automatically load the value for a missing key using a {@link CacheLoader}
 * interface
 */
public interface LoadingCache<K, V> {

  /**
   * API to get the value of a key from the cache. If the key is missing, the cache will attempt to
   * load the value using a provided {@link CacheLoader}
   */
  V get(K key);

  /**
   * Invalidates a key in the cache
   */
  void invalidate(K key);

  /**
   * Returns the size of the cache
   */
  long size();

}

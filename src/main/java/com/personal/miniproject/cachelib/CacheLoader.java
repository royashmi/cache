package com.personal.miniproject.cachelib;

/**
 * An interface that implements a load function which will return a value of type V given a key of type K.
 * Users of the cache will provide an implementation of this interface to retrieve the value of a key
 * missing from the cache.
 */
public interface CacheLoader<K, V> {
  V load (K key);
}

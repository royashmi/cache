package com.personal.miniproject.cachelib;

public interface CacheLoader<K, V> {
  V load (K key);
}

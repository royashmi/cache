package com.personal.miniproject.cachelib;

public interface LoadingCache<K, V> {

  V get(K key);

  void invalidate(K key);

  long size();

}

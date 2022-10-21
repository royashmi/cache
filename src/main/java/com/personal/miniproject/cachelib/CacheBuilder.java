package com.personal.miniproject.cachelib;

public class CacheBuilder<K, V> {

  private long _maximumSize;

  private CacheBuilder() { }

  public static CacheBuilder newBuilder() {
    return new CacheBuilder<>();
  }

  public CacheBuilder<K, V> maximumSize(long size) {
    _maximumSize = size;
    return (CacheBuilder<K, V>) this;
  }

  public LoadingCache<K, V> build(CacheLoader<K, V> loader) {
    return new LoadingCacheImpl<>(_maximumSize, loader);
  }

}
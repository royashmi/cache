package com.personal.miniproject.cachelib;

/**
 * A class that provides API to build an instance of a {@link LoadingCache}
 */
public final class CacheBuilder<K, V> {

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
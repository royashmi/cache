package com.personal.miniproject.cachelib;

import com.personal.miniproject.simplecache.Cache;
import com.personal.miniproject.simplecache.CacheImpl;
import com.personal.miniproject.simplecache.LRUEvictionPolicy;

/**
 * An implementation of a {@link LoadingCache}.
 */
public class LoadingCacheImpl<K, V> implements LoadingCache<K, V> {

  private final CacheLoader<K, V> _cacheLoader;
  private final Cache<K, V> _lruCache;

  public LoadingCacheImpl(long maximumSize, CacheLoader<K, V> cacheLoader) {
    _cacheLoader = cacheLoader;
    _lruCache = new CacheImpl<>(maximumSize, new LRUEvictionPolicy<>());
  }

  @Override
  public V get(K key) {
    if(_lruCache.get(key) != null) {
      System.out.println("Cache Hit");
      return _lruCache.get(key);
    }
    V value = null;
    try {
      value = _cacheLoader.load(key);
    } catch (Exception ex) {
      throw new RuntimeException("Exception from CacheLoader for key : " + key + ", exception: " + ex);
    }
    if (value != null) {
      _lruCache.put(key, value);
    }
    return value;
  }

  @Override
  public void invalidate(K key) {
    _lruCache.del(key);
  }

  @Override
  public long size() {
    return _lruCache.size();
  }
}

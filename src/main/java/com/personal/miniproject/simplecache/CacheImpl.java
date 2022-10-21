package com.personal.miniproject.simplecache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheImpl<K,V> implements Cache<K,V> {

  private final long _capacity;
  private final EvictionPolicy<K> _evictionPolicy;
  private final Map<K, V> _store;

  public CacheImpl(long capacity, EvictionPolicy<K> evictionPolicy) {
    _capacity = capacity;
    _evictionPolicy = evictionPolicy;
    _store = new ConcurrentHashMap<>();
  }

  @Override
  public V get(K key) {
    if (_store.containsKey(key)) {
      _evictionPolicy.keyAccessed(key);
      return _store.get(key);
    }
    return null;
  }

  @Override
  public void put(K key, V value) {
    if (value == null) {
      throw new RuntimeException("Null value is not supported by this Cache");
    }
    if(_store.size() == _capacity) {
      K evictedKey = _evictionPolicy.evict();
      _store.remove(evictedKey);
    }
    _store.put(key, value);
    _evictionPolicy.keyAccessed(key);
  }

  @Override
  public void del(K key) {
    if (_store.containsKey(key)) {
      _store.remove(key);
    }
  }

  @Override
  public long size() {
    return _store.size();
  }
}
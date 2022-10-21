package com.personal.miniproject.simplecache;

public interface EvictionPolicy<K> {

  void keyAccessed(K key);

  void keyDeleted(K key);

  K evict();

}
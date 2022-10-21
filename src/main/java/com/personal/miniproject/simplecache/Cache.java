package com.personal.miniproject.simplecache;

public interface Cache<K , V> {

  V get(K key);

  void put(K key, V value);

  void del(K key);

  long size();
}
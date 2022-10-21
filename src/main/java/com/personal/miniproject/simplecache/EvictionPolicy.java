package com.personal.miniproject.simplecache;

/**
 * An interface representing a Eviction Policy
 */
public interface EvictionPolicy<K> {

  /**
   * API that should be access whenever a key is acessed
   */
  void keyAccessed(K key);

  /**
   * API that will be called whenever a key is deleted
   */
  void keyDeleted(K key);

  /**
   * API that will evict the next item to be deleted as per the policy
   */
  K evict();

}
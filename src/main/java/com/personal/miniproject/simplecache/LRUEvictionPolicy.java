package com.personal.miniproject.simplecache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An implementation of eviction policy which evicts the least recently accessed item
 */
public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

  private final DoublyLinkedList<K> _doublyLinkedList;
  private final Map<K, DLLNode<K>>_keyToNode;

  public LRUEvictionPolicy() {
    _doublyLinkedList = new DoublyLinkedList<K>();
    _keyToNode = new ConcurrentHashMap<>();
  }

  @Override
  public void keyAccessed(K key) {
    if(_keyToNode.containsKey(key)) {
      DLLNode<K> accessedNode = _keyToNode.get(key);
      _doublyLinkedList.unlinkNode(accessedNode);
      _doublyLinkedList.addNodeAtLast(accessedNode);
    } else {
      DLLNode<K> node = _doublyLinkedList.addLast(key);
      _keyToNode.put(key, node);
    }
  }

  @Override
  public void keyDeleted(K key) {
    if(_keyToNode.containsKey(key)) {
      DLLNode<K> toBeDeletedNode = _keyToNode.get(key);
      _doublyLinkedList.unlinkNode(toBeDeletedNode);
      _keyToNode.remove(key);
    }
  }

  @Override
  public K evict() {
    DLLNode<K> leastRecentlyUsedNode = _doublyLinkedList.getFirstNode();
    if(leastRecentlyUsedNode == null) {
      return null;
    }
    _doublyLinkedList.unlinkNode(leastRecentlyUsedNode);
    System.out.println("LRU policy evicting key " + leastRecentlyUsedNode.getElement());
    return leastRecentlyUsedNode.getElement();
  }
}
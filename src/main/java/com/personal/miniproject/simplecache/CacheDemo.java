package com.personal.miniproject.simplecache;

public class CacheDemo {

  public static void main(String[] args) {
    Cache<String, Integer> intCache = new CacheImpl<>(5, new LRUEvictionPolicy<>());
    intCache.put("k1", 1);
    intCache.put("k2", 2);
    System.out.println(intCache.get("k1"));
    intCache.put("k3", 3);
    intCache.put("k7", 7);
    intCache.put("k4", 4);
    System.out.println(intCache.get("k3"));
    intCache.put("k8", 8);
    intCache.put("k9", 9);
    System.out.println(intCache.get("k7"));
    intCache.del("k8");
  }

}

package com.personal.miniproject.cachelib;

import java.util.HashMap;
import java.util.Map;

public class LoadingCacheDemo {

  private static Map<String, Integer> MOCK_DATABASE = new HashMap<>();

  public static void main(String[] args) {

    MOCK_DATABASE.put("one", 1);
    MOCK_DATABASE.put("two", 2);
    MOCK_DATABASE.put("three", 3);
    MOCK_DATABASE.put("four", 4);
    MOCK_DATABASE.put("five", 5);
    MOCK_DATABASE.put("six", 6);
    MOCK_DATABASE.put("seven", 7);
    MOCK_DATABASE.put("eight", 8);
    MOCK_DATABASE.put("nine", 9);
    MOCK_DATABASE.put("ten", 10);

    LoadingCache<String, Integer> loadingCache =
        CacheBuilder
            .newBuilder()
            .maximumSize(5)
            .build((CacheLoader<String, Integer>) key -> mockDBLookup(key));

    System.out.println(loadingCache.get("one"));
    System.out.println(loadingCache.get("three"));
    System.out.println(loadingCache.get("seven"));
    System.out.println(loadingCache.get("four"));
    System.out.println(loadingCache.get("three"));
    System.out.println(loadingCache.get("ten"));
    System.out.println(loadingCache.get("six"));

    System.out.println(loadingCache.get("seven"));
    loadingCache.invalidate("seven");
    System.out.println(loadingCache.get("seven"));

    System.out.println(loadingCache.get("twelve"));


  }

  private static Integer mockDBLookup(String key) {
    System.out.println("Mock DB Lookup for Key " + key);
    return MOCK_DATABASE.get(key);
  }

}
package org.sample.javase.javaspacialist.lrutest;

import java.util.Map;

public class LRUCacheTest {
    public static void main(String[] args) {
        
        Map<Integer, String> cache = new LRUCache<>(5);
        for(int i = 0; i < 10; i++) {
            cache.put(i, "hi");
        }
        
        System.out.println("cache = " + cache);
        
        System.out.println(cache.get(7));
        
        System.out.println("cache = " + cache);
        
        for(int i = 10; i < 14; i++) {
            cache.put(i, "hi");
        }        
        
        System.out.println("cache = " + cache);
        
        cache.put(42, "meaning of life");
        
        System.out.println("cache = " + cache);
    }
}

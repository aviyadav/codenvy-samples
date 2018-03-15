package org.sample.javase.javaspacialist.lrutest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AccessOrderTest {
    
    public static void main(String[] args) {
        test(new LinkedHashMap<>());
        System.out.println();
        test(new LinkedHashMap<>(16, 0.75f, true));
        System.out.println();
        test(new TreeMap<>());
        System.out.println();
        test(new HashMap<>());
    }
    
    private static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        map.put(42, "Meaning");
        map.put(7, "Days Per Week");
        map.put(86400, "Seconds");
        map.put(1, "Highlander");
        
        System.out.println("map = " + map);
        System.out.println("map.get(42) = " + map.get(42));
        System.out.println("map = " + map);
    }
}

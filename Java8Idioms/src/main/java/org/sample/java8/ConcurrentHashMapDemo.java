package org.sample.java8;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    
    public static void main(String[] args) {
        
        ConcurrentHashMap<String, Integer> certificationCosts = new ConcurrentHashMap<>();
        certificationCosts.put("OCAJP", 246);
        certificationCosts.put("OCPJP", 246);
        certificationCosts.put("Spring Core", 200);
        certificationCosts.put("Spring Web", 200);
        certificationCosts.put("OCMEA", 300);
        
        Set<String> concurrentSet = certificationCosts.keySet();
        
        System.out.println("before adding element into concurrent set: " + concurrentSet);
        // concurrentSet.add("OCEJWCD"); // will throw UnsupportedOperationExcetpion
        System.out.println("after adding element into concurrent set: " + concurrentSet);
        
        Set<String> concurrentHashSet = certificationCosts.newKeySet();
        
        concurrentHashSet.add("OCEJWCD");
        concurrentHashSet.add("OCEJWCD");
        concurrentHashSet.add("OCEJWCD");
        System.out.println("after adding element into concurrent HashSet: " + concurrentSet);
        
        concurrentSet = certificationCosts.keySet(246);
        concurrentSet.add("Spring enterprise");
    }
}

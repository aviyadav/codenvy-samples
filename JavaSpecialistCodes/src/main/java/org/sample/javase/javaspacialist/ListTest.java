package org.sample.javase.javaspacialist;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    
    private static final int NUM_ELEMENTS = 100 * 1000;
    
    public static void main(String[] args) {
        List array = new ArrayList<>();
        for(int i = 0; i < NUM_ELEMENTS; i++) {
            array.add(i);
        }
    }
    
    public static void testListBegining(List list) {
        long time = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.add(0, new Object());
            list.remove(0);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("beginning " + list.getClass().getSimpleName() + " took " + time);
    }
    
    public static void testListMiddle(List list) {
        long time = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.add(NUM_ELEMENTS / 2, new Object());
            list.remove(NUM_ELEMENTS / 2);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("middle " + list.getClass().getSimpleName() + " took " + time);
    }
    
    public static void testListEnd(List list) {
        long time = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.add(new Object());
            list.remove(NUM_ELEMENTS);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("end " + list.getClass().getSimpleName() + " took " + time);
    }
}

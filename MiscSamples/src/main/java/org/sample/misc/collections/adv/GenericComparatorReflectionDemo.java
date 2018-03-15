package org.sample.misc.collections.adv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class GenericComparatorReflectionDemo {

    static List<Employee> allEmp = new ArrayList<>();

    static {
        allEmp.add(new Employee(45, "Vijay", "Bangalore", "Banking", 88, 99999));
        allEmp.add(new Employee(13, "Manoz", "Chennai", "Insurance", 48, 28000));
        allEmp.add(new Employee(79, "Ajay", "Hyderabad", "Real Estate", 54, 24000));
        allEmp.add(new Employee(21, "Sindu", "Noida", "Analyst", 89, 99998));
        allEmp.add(new Employee(67, "Honey", "Mumbai", "Social", 88, 111111));
        allEmp.add(new Employee(12, "Lucky", "Mysore", "Social", 86, 99997));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the field on which you want to sort employee's...");
        
        final String input = scanner.nextLine();
        scanner.close();

        if(null != input && !"".equals(input)) {
            Collections.sort(allEmp, new Comparator<Employee>() {

                @Override
                public int compare(Employee emp1, Employee emp2) {
                    try {
                        Field employeeField = Employee.class.getDeclaredField(input);
                        employeeField.setAccessible(true);
                        
                        Comparable employeeFieldValue1 = ((Comparable) employeeField.get(emp1));
                        Comparable employeeFieldValue2 = ((Comparable) employeeField.get(emp2));
                        
                        return employeeFieldValue1.compareTo(employeeFieldValue2);
                    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }
                
            });
        } else {
            System.out.println("Please enter valid employee field to sort employee's...");
        }
        
        for (Employee empObj : allEmp) {
            System.out.println("\n" + empObj.toString());
        }
    }
    
    /*
    public static <T> Comparator<T> createComparator(Function<T, R extends Comparable<? super R> > getter) {
        return (obj1, obj2) -> getter.apply(obj1).compareTo(getter.apply(obj2));
    }
    */
}

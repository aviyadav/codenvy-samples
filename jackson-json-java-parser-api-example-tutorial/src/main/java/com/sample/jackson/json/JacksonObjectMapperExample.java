package com.sample.jackson.json;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sample.jackson.model.Address;
import com.sample.jackson.model.Employee;

public class JacksonObjectMapperExample {

    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));
        ObjectMapper objectMapper = new ObjectMapper();

        Employee emp = objectMapper.readValue(jsonData, Employee.class);
        System.out.println("Employee Object \n " + emp);

        Employee emp1 = createEmployee();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, emp1);
        System.out.println("Employee JSON \n " + emp1);
    }

    public static Employee createEmployee() {
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[] {123456, 987654});
        emp.setRole("Manager");

        Address add = new Address();
        add.setCity("Bangalore");
        add.setStreet("BTM 1st Stage");
        add.setZipcode(560100);
        emp.setAddress(add);

        List<String> cities = new ArrayList<>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);

        Map<String, String> props = new HashMap<>();
        props.put("salary", "1000 Rs");
        props.put("age", "28 years");
        emp.setProperties(props);
        return emp;
    }
}

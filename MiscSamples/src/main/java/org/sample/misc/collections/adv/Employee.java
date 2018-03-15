package org.sample.misc.collections.adv;

public class Employee {

    private long   id;
    private String name;
    private String location;
    private String department;
    private int    rewardPoints;
    private double salary;

    public Employee(long id, String name, String location, String department, int rewardPoints, double salary) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.department = department;
        this.rewardPoints = rewardPoints;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", department=" + department + ", rewardPoints=" + rewardPoints + ", salary=" + salary + "]";
    }
}

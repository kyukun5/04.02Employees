package model;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private double employmentTime;
    private String currentWork;

    public Employee(String name, int age, double salary, double employmentTime, String currentWork){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.employmentTime=employmentTime;
        this.currentWork=currentWork;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getEmploymentTime() {
        return employmentTime;
    }
    public void setEmploymentTime(double employmentTime) {
        this.employmentTime = employmentTime;
    }
    public String getCurrentWork() {
        return currentWork;
    }
    public void setCurrentWork(String currentWork) {
        this.currentWork = currentWork;
    }

}

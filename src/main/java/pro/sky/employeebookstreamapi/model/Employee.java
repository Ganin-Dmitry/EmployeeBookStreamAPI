package pro.sky.employeebookstreamapi.model;

import java.util.Map;
import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private int salary;
    private int department;

    private final Map<Integer, String> departmentMap = Map.of(
            1, "Отдел управления",
            2, "Отдел маркетинга",
            3, "Отдел разработки",
            4, "Отдел кадров",
            5, "Отдел обслуживания");

    public Employee (String firstName,
                     String middleName,
                     String lastName,
                     int salary,
                     int department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.setSalary(salary);
        this.setDepartment(department);
    }

    public String getFullName () {
        return this.firstName + " " + this.middleName + " " + this.lastName;
    }

    public String getKey () {
        return this.firstName + this.middleName + this.lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, salary, department);
    }

    @Override
    public String toString () {
        return "Ф.И.О.: " + this.getFullName() + "<br>" +
                "ЗП: " + this.salary + "<br>" +
                "Отдел: " + departmentMap.get(this.department) + "<br>";
    }
}
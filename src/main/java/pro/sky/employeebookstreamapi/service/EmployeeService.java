package pro.sky.employeebookstreamapi.service;

import pro.sky.employeebookstreamapi.model.Employee;

import java.util.Map;

public interface EmployeeService {
    String addEmployee(String firstName,
                       String middleName,
                       String lastName,
                       int salary,
                       int department);
    String removeEmployee(String fullName);
    String findEmployee(String fullName);

    String getEmployeeList();

    Map<String, Employee> getEmployeeBook();
}


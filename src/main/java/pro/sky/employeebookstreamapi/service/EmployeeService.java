package pro.sky.employeebookstreamapi.service;

public interface EmployeeService {
    String addEmployee(String firstName,
                       String middleName,
                       String lastName,
                       int salary,
                       int department);
    String removeEmployee(String fullName);
    String findEmployee(String fullName);

    String getEmployeeList();
}


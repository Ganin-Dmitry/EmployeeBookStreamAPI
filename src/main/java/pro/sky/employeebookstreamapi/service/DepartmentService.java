package pro.sky.employeebookstreamapi.service;

import pro.sky.employeebookstreamapi.model.Employee;

import java.util.List;

public interface DepartmentService {
    Employee findEmployeeMaxSalary (Integer departmentId);
    Employee findEmployeeMinSalary (Integer departmentId);
    List<Employee> getEmployeeByDepartment (Integer departmentId);
    String getAllEmployee();

    String toStringListByDepartment(List<Employee> employeeList);
}

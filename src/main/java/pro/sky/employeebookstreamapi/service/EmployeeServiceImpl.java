package pro.sky.employeebookstreamapi.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebookstreamapi.exception.EmployeeAlreadyAddedException;
import pro.sky.employeebookstreamapi.exception.EmployeeNotFoundException;
import pro.sky.employeebookstreamapi.exception.EmployeeStorageIsFullException;
import pro.sky.employeebookstreamapi.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeBook;
    private final int maxLengthMap = 10;
    public EmployeeServiceImpl (Map<String, Employee> employeeBook) {
        this.employeeBook = new HashMap<>();
    }

    @Override
    public String addEmployee(String firstName,
                              String middleName,
                              String lastName,
                              int salary,
                              int department) {
        Employee employee = new Employee(firstName, middleName, lastName, salary, department);
        if (employeeBook.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (!checkCapacityMap()) {
            throw new EmployeeStorageIsFullException();
        }
        this.employeeBook.put(employee.getKey(), employee);
        return "Сотрудник успешно добавлен!<br>" + employee.toString();
    }

    @Override
    public String removeEmployee(String fullName) {
        if (employeeBook.containsKey(fullName)){
            Employee employee = this.employeeBook.get(fullName);
            this.employeeBook.remove(fullName);
            return "Сотрудник удален!<br>" + employee.toString();
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String findEmployee(String fullName) {
        if (employeeBook.containsKey(fullName)) {
            Employee employee = this.employeeBook.get(fullName);
            return "Сотрудник найден!<br>" + employee.toString();
        }
        throw new EmployeeNotFoundException();
    }

    private boolean checkCapacityMap () {
        return employeeBook.size() <= maxLengthMap;
    }

    @Override
    public String getEmployeeList() {
        if (employeeBook.size() == 0) {
            throw new EmployeeNotFoundException();
        }
        String strEmployeeList = "";
        for (Employee employee: employeeBook.values()) {
            strEmployeeList = strEmployeeList + employee.toString() + "<br><br>";
        }
        return strEmployeeList;
    }

}

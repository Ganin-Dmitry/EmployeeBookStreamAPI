package pro.sky.employeebookstreamapi.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebookstreamapi.model.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService service;
    public DepartmentServiceImpl(EmployeeService service) {
        this.service = service;
    }

    @Override
    public Employee findEmployeeMaxSalary(Integer departmentId) {
        if (departmentId < 0 || departmentId > 5) {
            throw new IllegalArgumentException("ID отдела не может быть меньше 0 или больше 5");
        }
        return service.getEmployeeBook().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee :: getSalary))
                .orElseThrow();
    }

    @Override
    public Employee findEmployeeMinSalary(Integer departmentId) {
        if (departmentId < 0 || departmentId > 5) {
            throw new IllegalArgumentException("ID отдела не может быть меньше 0 или больше 5");
        }
        return service.getEmployeeBook().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee :: getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> getEmployeeByDepartment(Integer departmentId) {
        if (departmentId < 0 || departmentId > 5) {
            throw new IllegalArgumentException("ID отдела не может быть меньше 0 или больше 5");
        }
        return service.getEmployeeBook().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public String getAllEmployee() {
        String listAllEmployee = "";
        for (int departmentID = 1; departmentID < 6; departmentID++) {
            listAllEmployee = listAllEmployee + toStringListByDepartment(getEmployeeByDepartment(departmentID)) + "<br><br>";
        }
        return listAllEmployee;
    }

    @Override
    public String toStringListByDepartment(List<Employee> employeeList) {
        try {
            String employeeStringList = employeeList.stream()
                    .map(employee -> employee.toString())
                    .collect(Collectors.joining("<br><br>"));
            return "Список сотрудников по отделу: " + Employee.getDepartmentById(employeeList.get(1).getDepartment()) +
                    "<br><br>" + employeeStringList;
        } catch (IndexOutOfBoundsException e) {
            return "Сотрудников в отделе не найдено.";
        }

    }
}
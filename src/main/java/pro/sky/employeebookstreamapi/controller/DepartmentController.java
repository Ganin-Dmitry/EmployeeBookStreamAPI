package pro.sky.employeebookstreamapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeebookstreamapi.model.Employee;
import pro.sky.employeebookstreamapi.service.DepartmentService;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService service;
    public DepartmentController (DepartmentService service) {
        this.service = service;
    }

    @GetMapping(path = "/max-salary")
    public String maxSalary (@RequestParam (required = false) Integer departmentID) {
        if (departmentID == null) {
            return "Неверно введен ID отдела";
        }
        try {
            return "Сотрудник с большей зарплатой в отделе: " +
                    Employee.getDepartmentById(departmentID) + "<br>" +
                    service.findEmployeeMaxSalary(departmentID).toString();
        } catch (IllegalArgumentException e) {
            return "Введен несуществующий ID отдела";
        } catch (NoSuchElementException e) {
            return "Сотрудники в этом отделе не найдены";
        }
    }

    @GetMapping(path = "/min-salary")
    public String minSalary (@RequestParam (required = false) Integer departmentID) {
        if (departmentID == null) {
            return "Неверно введен ID отдела";
        }
        try {
            return "Сотрудник с меньшей зарплатой в отделе: " +
                    Employee.getDepartmentById(departmentID) + "<br>" +
                    service.findEmployeeMinSalary(departmentID).toString();
        } catch (IllegalArgumentException e) {
            return "Введен несуществующий ID отдела";
        } catch (NoSuchElementException e) {
            return "Сотрудники в этом отделе не найдены";
        }
    }

    @GetMapping(value = "/all", params = "departmentID")
    public String printEmployeeByDepartment (@RequestParam (required = false) Integer departmentID) {
        if (departmentID == null) {
            return "Неверно введен ID отдела";
        }
        try {
            return service.toStringListByDepartment(service.getEmployeeByDepartment(departmentID));
        } catch (IllegalArgumentException e) {
            return "Введен несуществующий ID отдела";
        }
    }

    @GetMapping(value = "/all", params = "!departmentID")
    public String printAllEmployee () {
        return service.getAllEmployee();
    }

}

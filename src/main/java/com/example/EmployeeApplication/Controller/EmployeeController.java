
package com.example.EmployeeApplication.Controller;

import com.example.EmployeeApplication.Model.Employee;
import com.example.EmployeeApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService s;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return s.getAllEmployees();
    }

    @GetMapping("employees/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") int empId) {
        return s.getEmployeeById(empId);
    }

    @PostMapping("employees")
    public String addEmployee(@RequestBody Employee emp) {
        s.addEmployee(emp);
        return "Employee added";
    }

    @PutMapping("employees")
    public String updateEmployee(@RequestBody Employee emp) {
        return s.updateEmployee(emp);
    }

    @DeleteMapping("employees/{empId}")
    public String deleteEmployee(@PathVariable("empId") int empId) {
        return s.deleteEmployeeById(empId);
    }
}

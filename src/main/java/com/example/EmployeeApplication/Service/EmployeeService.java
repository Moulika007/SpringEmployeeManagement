
package com.example.EmployeeApplication.Service;

import com.example.EmployeeApplication.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "Arun", "IT", 35000),
                    new Employee(2, "Priya", "HR", 40000),
                    new Employee(3, "Kumar", "Finance", 45000)
            )
    );

    public List<Employee> getAllEmployees() {
        return list;
    }

    public Employee getEmployeeById(int empId) {

        int index = 0;
        boolean flag = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmpId() == empId) {
                index = i;
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        }
        else {
            return list.get(index);
        }
    }

    public String addEmployee(Employee emp) {
        list.add(emp);
        return "Employee added Successfully";
    }

    public String updateEmployee(Employee emp) {

        int index = 0;
        boolean flag = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmpId() == emp.getEmpId()) {
                index = i;
                flag = true;
                break;
            }
        }

        if (!flag) {
            return "No such employee";
        }
        else {
            list.set(index, emp);
            return "Employee updated Successfully";
        }
    }

    public String deleteEmployeeById(int empId) {

        int index = 0;
        boolean flag = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmpId() == empId) {
                index = i;
                flag = true;
                break;
            }
        }

        if (!flag) {
            return "No such employee";
        }
        else {
            list.remove(index);
            return "Employee deleted Successfully";
        }
    }
}

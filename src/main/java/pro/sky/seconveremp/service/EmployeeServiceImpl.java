package pro.sky.seconveremp.service;

import org.springframework.stereotype.Service;
import pro.sky.seconveremp.Employee;
import pro.sky.seconveremp.exceptions.EmployeeAlreadyAddedException;
import pro.sky.seconveremp.exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee addEmp = new Employee(firstName, lastName);
        if (employeeList.contains(addEmp)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(addEmp);
        return addEmp;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee remEmp = new Employee(firstName, lastName);
        if (employeeList.contains(remEmp)) {
            employeeList.remove(remEmp);
            return remEmp;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee findEmp = new Employee(firstName, lastName);
        if (employeeList.contains(findEmp)) {
            return findEmp;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}

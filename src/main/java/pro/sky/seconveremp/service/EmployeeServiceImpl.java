package pro.sky.seconveremp.service;

import org.springframework.stereotype.Service;
import pro.sky.seconveremp.exceptions.EmployeeAlreadyAddedException;
import pro.sky.seconveremp.exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map <Integer, String> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public String add(Integer passportNumber, String name) {
        if (employeeMap.containsKey(passportNumber)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(passportNumber, name);
        return "Сотрудник " + passportNumber + " " + name + " успешно добавлен";
    }

    @Override
    public String remove(Integer passportNumber, String name) {
        if (employeeMap.containsKey(passportNumber)) {
            employeeMap.remove(passportNumber, name);
            return "Сотрудник " + passportNumber + " " + name + " успешно удален";
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String find(Integer passportNumber, String name) {
        if (employeeMap.containsKey(passportNumber)) {
            return "Сотрудник " + passportNumber + " " + name + " найден";
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<Integer, String> printAll() {
        return employeeMap;
    }

}

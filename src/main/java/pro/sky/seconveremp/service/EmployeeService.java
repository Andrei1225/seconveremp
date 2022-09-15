package pro.sky.seconveremp.service;

import java.util.Map;

public interface EmployeeService {

    String add(Integer passportNumber, String name);

    String remove(Integer passportNumber, String name);

    String find(Integer passportNumber, String name);

    Map<Integer, String> printAll();
}

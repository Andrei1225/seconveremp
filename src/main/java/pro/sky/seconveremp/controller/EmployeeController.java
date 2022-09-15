package pro.sky.seconveremp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.seconveremp.service.EmployeeService;

import java.util.Map;

@RestController

@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam Integer passportNumber, @RequestParam String name) {
        return service.add(passportNumber, name);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam Integer passportNumber, @RequestParam String name) {
        return service.remove(passportNumber, name);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam Integer passportNumber, @RequestParam String name) {
        return service.find(passportNumber, name);
    }

    @GetMapping
    public Map<Integer, String> findAll() {
        return service.printAll();
    }
}

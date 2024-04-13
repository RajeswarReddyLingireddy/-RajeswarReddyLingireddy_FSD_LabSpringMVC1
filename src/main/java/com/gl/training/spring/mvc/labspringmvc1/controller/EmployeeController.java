package com.gl.training.spring.mvc.labspringmvc1.controller;

import com.gl.training.spring.mvc.labspringmvc1.entity.Employee;
import com.gl.training.spring.mvc.labspringmvc1.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/all")
    public String listOfEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("employees",allEmployees);
        return "employees";

    }

    @GetMapping("/new")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")  Employee employee){
        Employee emp = employeeService.saveEmployee(employee);
        return "redirect:/employee/all";

    }

    @GetMapping("/edit")
    public String editEmployeeForm(@RequestParam("employeeId") int employeeId,Model model){
        Employee employeeById = employeeService.getEmployeeById(employeeId);
        if(employeeById != null){
         model.addAttribute("employee",employeeById);
        }
        return "edit_employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int employeeId,@ModelAttribute("employee") Employee emp){
        Employee employeeById = employeeService.getEmployeeById(employeeId);
        employeeById.setFirstName(emp.getFirstName());
        employeeById.setLastName(emp.getLastName());
        employeeById.setEmail(emp.getEmail());
        employeeService.updateEmployee(employeeById);
        return "redirect:/employee/all";
    }
    @GetMapping("/delete")
    public String deleteEmployeeForm(@RequestParam("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employee/all";
    }
}

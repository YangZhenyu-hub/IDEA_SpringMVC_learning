package com.yzy.rest.controller;

import com.yzy.rest.bean.Employee;
import com.yzy.rest.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-03-30 10:53
 * @Version
 **/

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employees" ,method= RequestMethod.GET)
    public String getAllEmployees(Model model) {
        Collection<Employee> employeeList = employeeDAO.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }
    @RequestMapping(value = "/employee/{id}",method=RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDAO.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDAO.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }


    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        employeeDAO.save(employee);
        return "redirect:/employees";
    }
}

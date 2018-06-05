package com.empmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpManageController {

    // @Autowired
    // EmployeeDAO empDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/addEmp")
    public String getEmpManage(final ModelMap model) {

        System.out.println("In getEmpManage method of EmpManageController Controller");
        return "addEmp";
    }

    /*
     * @RequestMapping(method = RequestMethod.POST, value = "/addEmp") public
     * String postEmpManage(final ModelMap model, @RequestParam final Map
     * empData) {
     * 
     * System.out.println(
     * "In postEmpManage method of EmpManageController Controller");
     * model.put("welcomeerrormessage", "Employee Added Successfully..");
     * 
     * return "welcome"; }
     */
}

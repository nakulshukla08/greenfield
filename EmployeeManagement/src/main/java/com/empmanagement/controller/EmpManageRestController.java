/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.empmanagement.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.model.EmployeeDTO;
import com.empmanagement.model.EmployeeDTOList;
import com.empmanagement.service.EmpManagementService;

@RestController
public class EmpManageRestController {


    @Autowired
    private EmpManagementService empService;


    /*
     * @GetMapping("/allEmployees") public List<EmployeeDTO>
     * retrieveEmployees() { return this.empDao.findAll(); }
     */

    /*
     * @GetMapping("/employee/{empid}") public EmployeeDTO
     * retrieveEmployee(@PathVariable int empid){ empDao.findById(empid); }
     */

    /*
     * public void deleteEmployee(@PathVariable int empid){ empDao.dele }
     */

    @PostMapping("/addEmp")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDTOList createEmployee(final EmployeeDTO empDto) {

        System.out.println("In createEmployee method of EmpManage Rest Controller");
        EmployeeDTOList empListResponse = null;
        ArrayList<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
        empList.add(empDto);
        // save emp dto here in database
        empListResponse = new EmployeeDTOList();
        empListResponse.setEmployeeList(empList);

        return empListResponse;
    }
}

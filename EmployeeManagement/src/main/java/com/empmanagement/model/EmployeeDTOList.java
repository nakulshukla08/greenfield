/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.empmanagement.model;

import java.util.List;

public class EmployeeDTOList {

    private List<EmployeeDTO> employeeList;

    /**
     * @return the employeeList
     */
    public List<EmployeeDTO> getEmployeeList() {
        return this.employeeList;
    }

    /**
     * @param employeeList
     *            the employeeList to set
     */
    public void setEmployeeList(final List<EmployeeDTO> employeeList) {
        this.employeeList = employeeList;
    }
}
